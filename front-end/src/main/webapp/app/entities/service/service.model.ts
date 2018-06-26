import { BaseEntity } from './../../shared';

export const enum State {
    'RUNNING',
    'DOWN'
}

export const enum LicenceType {
    'TRIAL',
    'PAYANT'
}

export class Service implements BaseEntity {
    constructor(
        public id?: string,
        public name?: string,
        public description?: string,
        public url?: string,
        public dateadd?: any,
        public state?: State,
        public licenceType?: LicenceType,
    ) {
    }
}
