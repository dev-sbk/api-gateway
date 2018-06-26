import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {SERVER_API_SERVICE_MANEGEMENT_URL, SERVER_API_URL} from '../../app.constants';

import { Module } from './module.model';
import {LocalStorageService, SessionStorageService} from "ngx-webstorage";

export type EntityResponseType = HttpResponse<Module>;

@Injectable()
export class ModuleService {

    private resourceUrl =   SERVER_API_SERVICE_MANEGEMENT_URL  + 'api/modules';

    constructor(private http: HttpClient,private $localStorage: LocalStorageService,
                private $sessionStorage: SessionStorageService) { }

    create(id:string,module: Module): Observable<EntityResponseType> {
        const copy = this.convert(module);
        return this.http.post<Module>(`${this.resourceUrl}/${id}`, copy, { headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}),observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(id:string,module: Module): Observable<EntityResponseType> {
        const copy = this.convert(module);
        return this.http.put<Module>(`${this.resourceUrl}/${id}`, copy, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }
    find(serviceId: string ,moduleId :string): Observable<EntityResponseType> {
        return this.http.get<Module>(`${this.resourceUrl}/${serviceId}/${moduleId}`, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }
    query(id:string): Observable<HttpResponse<Module[]>> {
        return this.http.get<Module[]>(`${this.resourceUrl}/${id}`, { headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response' })
            .map((res: HttpResponse<Module[]>) => this.convertArrayResponse(res));
    }

    delete(serviceId: string ,moduleId :string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${serviceId}/${moduleId}`, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Module = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Module[]>): HttpResponse<Module[]> {
        const jsonResponse: Module[] = res.body;
        const body: Module[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Module.
     */
    private convertItemFromServer(module: Module): Module {
        const copy: Module = Object.assign({}, module);
        return copy;
    }

    /**
     * Convert a Module to a JSON which can be sent to the server.
     */
    private convert(module: Module): Module {
        const copy: Module = Object.assign({}, module);
        return copy;
    }
    getToken() {
        return this.$localStorage.retrieve('authenticationToken') || this.$sessionStorage.retrieve('authenticationToken');
    }
}
