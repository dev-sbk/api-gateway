import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager, JhiAlertService, JhiDataUtils } from 'ng-jhipster';

import { Module } from './module.model';
import { ModuleService } from './module.service';
import { Principal } from '../../shared';
import {ActivatedRoute} from "@angular/router";

@Component({
    selector: 'jhi-module',
    templateUrl: './module.component.html'
})
export class ModuleComponent implements OnInit, OnDestroy {
modules: Module[];
    currentAccount: any;
    eventSubscriber: Subscription;
    serviceId:string;
    private subscription: Subscription;
    constructor(
        private moduleService: ModuleService,
        private jhiAlertService: JhiAlertService,
        private dataUtils: JhiDataUtils,
        private eventManager: JhiEventManager,
        private principal: Principal,
        private route:ActivatedRoute
    ) {
        this.subscription = this.route.params.subscribe((params) => {
            this.serviceId=params['serviceId'];
        });
    }

    loadAll() {
        this.moduleService.query(this.serviceId).subscribe(
            (res: HttpResponse<Module[]>) => {
                this.modules = res.body;
                console.log(res.body);
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }
    ngOnInit() {
        this.loadAll();
        this.principal.identity().then((account) => {
            this.currentAccount = account;
        });
        this.registerChangeInModules();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: Module) {
        return item.id;
    }

    byteSize(field) {
        return this.dataUtils.byteSize(field);
    }

    openFile(contentType, field) {
        return this.dataUtils.openFile(contentType, field);
    }
    registerChangeInModules() {
        this.eventSubscriber = this.eventManager.subscribe('moduleListModification', (response) => this.loadAll());
    }

    private onError(error) {
        this.jhiAlertService.error(error.message, null, null);
    }
    public downloadModule(module){

        console.log(module);
        var a = document.createElement('a');
        var blob = new Blob([module.module], {'type':module.contentType});
        a.href = URL.createObjectURL(blob);
        a.download = module.name+"-"+module.id+".zip";
        a.click();

    }
}
