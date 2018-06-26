import { BaseEntity } from './../../shared';

export class Address implements BaseEntity {
    constructor(
        public id?: string,
        public country?: Country,
        public city?: string,
        public addressline1?: string,
        public addressline2?: string,
        public zipcode?: string,
    ) {
    }
}
export class Country implements BaseEntity{
    
    constructor(public id?:string ,public country?:string){
        
    }
}
