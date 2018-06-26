import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { Module } from './module.model';
import { ModuleService } from './module.service';

@Injectable()
export class ModulePopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private moduleService: ModuleService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, serviceId?: number | any ,moduleId?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (moduleId) {
                this.moduleService.find(serviceId,moduleId)
                    .subscribe((moduleResponse: HttpResponse<Module>) => {
                        const module: Module = moduleResponse.body;
                        this.ngbModalRef = this.moduleModalRef(component, module,serviceId);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.moduleModalRef(component, new Module(),serviceId);
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    moduleModalRef(component: Component, module: Module ,serviceId:string): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.module = module;
        modalRef.componentInstance.serviceId=serviceId;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
