import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {SERVER_API_SERVICE_MANEGEMENT_URL, SERVER_API_URL} from '../../app.constants';

import { JhiDateUtils } from 'ng-jhipster';

import { Service } from './service.model';
import { createRequestOption } from '../../shared';
import {LocalStorageService, SessionStorageService} from "ngx-webstorage";

export type EntityResponseType = HttpResponse<Service>;

@Injectable()
export class ServiceService {

    private resourceUrl =  SERVER_API_SERVICE_MANEGEMENT_URL + 'api/services';

    constructor(private http: HttpClient, private dateUtils: JhiDateUtils,private $localStorage: LocalStorageService,
                private $sessionStorage: SessionStorageService) {

    }

    create(service: Service): Observable<EntityResponseType> {
        const copy = this.convert(service);
        return this.http.post<Service>(this.resourceUrl, copy, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(service: Service): Observable<EntityResponseType> {
        const copy = this.convert(service);
        return this.http.put<Service>(this.resourceUrl, copy, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: string): Observable<EntityResponseType> {
        return this.http.get<Service>(`${this.resourceUrl}/${id}`, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<Service[]>> {
        const options = createRequestOption(req);
        return this.http.get<Service[]>(this.resourceUrl, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), params: options, observe: 'response' })
            .map((res: HttpResponse<Service[]>) => this.convertArrayResponse(res));
    }

    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Service = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Service[]>): HttpResponse<Service[]> {
        const jsonResponse: Service[] = res.body;
        const body: Service[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Service.
     */
    private convertItemFromServer(service: Service): Service {
        const copy: Service = Object.assign({}, service);
        copy.dateadd = this.dateUtils
            .convertLocalDateFromServer(service.dateadd);
        return copy;
    }

    /**
     * Convert a Service to a JSON which can be sent to the server.
     */
    private convert(service: Service): Service {
        const copy: Service = Object.assign({}, service);
        copy.dateadd = this.dateUtils
            .convertLocalDateToServer(service.dateadd);
        return copy;
    }
    getToken() {
        return this.$localStorage.retrieve('authenticationToken') || this.$sessionStorage.retrieve('authenticationToken');
    }
}
