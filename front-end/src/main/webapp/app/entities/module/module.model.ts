import { BaseEntity } from './../../shared';

export class Module implements BaseEntity {
    constructor(
        public id?: string,
        public name?: string,
        public description?: string,
        public moduleContentType?: string,
        public module?: any,
    ) {
    }
}
