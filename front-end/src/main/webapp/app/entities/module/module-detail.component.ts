import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiDataUtils } from 'ng-jhipster';

import { Module } from './module.model';
import { ModuleService } from './module.service';

@Component({
    selector: 'jhi-module-detail',
    templateUrl: './module-detail.component.html'
})
export class ModuleDetailComponent implements OnInit, OnDestroy {

    module: Module;
    private subscription: Subscription;
    private eventSubscriber: Subscription;
    serviceId:string;
    constructor(
        private eventManager: JhiEventManager,
        private dataUtils: JhiDataUtils,
        private moduleService: ModuleService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.serviceId=params['serviceId'];
            this.load(params['serviceId'],params['moduleId']);
        });
        this.registerChangeInModules();
    }

    load(serviceId: string ,moduleId :string) {
        this.moduleService.find(serviceId ,moduleId)
            .subscribe((moduleResponse: HttpResponse<Module>) => {
                this.module = moduleResponse.body;
            });
    }
    byteSize(field) {
        return this.dataUtils.byteSize(field);
    }

    openFile(contentType, field) {
        return this.dataUtils.openFile(contentType, field);
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInModules() {
        this.eventSubscriber = this.eventManager.subscribe(
            'moduleListModification',
            (response) => this.load(this.serviceId,this.module.id)
        );
    }
}
