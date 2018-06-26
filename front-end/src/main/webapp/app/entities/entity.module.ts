import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { ServiceModule } from './service/service.module';
import {AddressModule} from "./address/address.module";
import {ModuleModule} from "./module/module.module";


@NgModule({
    imports: [
        ModuleModule,
        AddressModule,
        ServiceModule
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PfaEntityModule {

}
