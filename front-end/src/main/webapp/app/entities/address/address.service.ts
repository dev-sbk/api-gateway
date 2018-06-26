import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {SERVER_API_SERVICE_MANEGEMENT_URL, SERVER_API_URL} from '../../app.constants';

import { Address } from './address.model';
import { createRequestOption } from '../../shared';
import {LocalStorageService, SessionStorageService} from "ngx-webstorage";

export type EntityResponseType = HttpResponse<Address>;

@Injectable()
export class AddressService {

    private resourceUrl =  SERVER_API_SERVICE_MANEGEMENT_URL + 'api/addresses';

    constructor(private http: HttpClient,private $localStorage: LocalStorageService,
                private $sessionStorage: SessionStorageService) { }

    create(address: Address): Observable<EntityResponseType> {
        const copy = this.convert(address);
        return this.http.post<Address>(this.resourceUrl, copy, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    update(address: Address): Observable<EntityResponseType> {
        const copy = this.convert(address);
        return this.http.put<Address>(this.resourceUrl, copy, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response' })
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    find(id: string): Observable<EntityResponseType> {
        return this.http.get<Address>(`${this.resourceUrl}/${id}`, { headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}),observe: 'response'})
            .map((res: EntityResponseType) => this.convertResponse(res));
    }

    query(req?: any): Observable<HttpResponse<Address[]>> {
        const options = createRequestOption(req);
        return this.http.get<Address[]>(this.resourceUrl, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), params: options, observe: 'response' })
            .map((res: HttpResponse<Address[]>) => this.convertArrayResponse(res));
    }

    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, {headers:new HttpHeaders({'Authorization':'Bearer '+this.getToken()}), observe: 'response'});
    }

    private convertResponse(res: EntityResponseType): EntityResponseType {
        const body: Address = this.convertItemFromServer(res.body);
        return res.clone({body});
    }

    private convertArrayResponse(res: HttpResponse<Address[]>): HttpResponse<Address[]> {
        const jsonResponse: Address[] = res.body;
        const body: Address[] = [];
        for (let i = 0; i < jsonResponse.length; i++) {
            body.push(this.convertItemFromServer(jsonResponse[i]));
        }
        return res.clone({body});
    }

    /**
     * Convert a returned JSON object to Address.
     */
    private convertItemFromServer(address: Address): Address {
        const copy: Address = Object.assign({}, address);
        return copy;
    }

    /**
     * Convert a Address to a JSON which can be sent to the server.
     */
    private convert(address: Address): Address {
        const copy: Address = Object.assign({}, address);
        return copy;
    }
    getToken() {
        return this.$localStorage.retrieve('authenticationToken') || this.$sessionStorage.retrieve('authenticationToken');
    }
}
