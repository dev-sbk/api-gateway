import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { ModuleComponent } from './module.component';
import { ModuleDetailComponent } from './module-detail.component';
import { ModulePopupComponent } from './module-dialog.component';
import { ModuleDeletePopupComponent } from './module-delete-dialog.component';

export const moduleRoute: Routes = [
    {
        path: 'service/:serviceId/module',
        component: ModuleComponent,
        data: {
            authorities: ['ROLE_ADMIN','ROLE_USER'],
            pageTitle: 'Modules'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'service/:serviceId/module/:moduleId',
        component: ModuleDetailComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Modules'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const modulePopupRoute: Routes = [
    {
        path: 'module-new/:serviceId',
        component: ModulePopupComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Modules'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'module/:serviceId/:moduleId/edit',
        component: ModulePopupComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Modules'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'module/:serviceId/:moduleId/delete',
        component: ModuleDeletePopupComponent,
        data: {
            authorities: ['ROLE_ADMIN'],
            pageTitle: 'Modules'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
