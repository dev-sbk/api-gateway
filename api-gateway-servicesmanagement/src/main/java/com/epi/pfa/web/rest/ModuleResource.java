package com.epi.pfa.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.epi.pfa.domain.Module;

import com.epi.pfa.domain.Service;
import com.epi.pfa.repository.ModuleRespository;
import com.epi.pfa.repository.ServiceRepository;
import com.epi.pfa.web.rest.errors.BadRequestAlertException;
import com.epi.pfa.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Module.
 */
@RestController
@RequestMapping("/api")
public class ModuleResource {

    private final Logger log = LoggerFactory.getLogger(ModuleResource.class);

    private static final String ENTITY_NAME = "module";

    private final ServiceRepository serviceRepository;
    private final ModuleRespository moduleRespository;

    public ModuleResource(ServiceRepository serviceRepository,ModuleRespository moduleRespository) {
        this.moduleRespository=moduleRespository;
        this.serviceRepository = serviceRepository;
    }

    /**
     * POST  /modules : Create a new module.
     *
     * @param module the module to create
     * @return the ResponseEntity with status 201 (Created) and with body the new module, or with status 400 (Bad Request) if the module has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/modules/{serviceId}")
    @Timed
    public ResponseEntity<Service> createModule(@PathVariable("serviceId") String serviceid,@Valid @RequestBody Module module) throws URISyntaxException {
        log.debug("REST request to save Module : {}", module);
        if (module.getId() != null) {
            throw new BadRequestAlertException("A new module cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Service service=serviceRepository.findOne(serviceid);
        moduleRespository.save(module);
        service.getMoudles().add(module);
        log.info("module",module.toString());
        Service result=serviceRepository.save(service);
        return ResponseEntity.created(new URI("/api/services/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /modules : Updates an existing module.
     *
     * @param module the module to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated module,
     * or with status 400 (Bad Request) if the module is not valid,
     * or with status 500 (Internal Server Error) if the module couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/modules/{serviceId}")
    @Timed
    public ResponseEntity<Service> updateModule(@PathVariable("serviceId") String serviceid,@Valid @RequestBody Module module) throws URISyntaxException {
        log.debug("REST request to update Module : {}", module);
        if (module.getId() == null) {
            return createModule(serviceid,module);
        }
        Service service=serviceRepository.findOne(serviceid);
        for(int i=0;i<service.getMoudles().size();i++){
            if(service.getMoudles().get(i).getId().equals(module.getId()))
                service.getMoudles().set(i,module);
        }
        Service result=serviceRepository.save(service);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * GET  /modules : get all the modules.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of modules in body
     */
    @GetMapping("/modules/{servicesid}")
    @Timed
    public List<Module> getAllModules(@PathVariable("servicesid") String id) {
        log.debug("REST request to get all Modules");
        return serviceRepository.findOne(id).getMoudles();
    }

    /**
     * GET MODULE
     * @param serviceid
     * @param moduleid
     * @return
     */
    @GetMapping("/modules/{serviceid}/{moduleid}")
    @Timed
    public ResponseEntity<Module> getModule(@PathVariable("serviceid") String serviceid,@PathVariable("moduleid") String moduleid) {

         Module module= serviceRepository.findOne(serviceid).getMoudles().stream().filter(m -> m.getId().equals(moduleid)).findFirst().get();

        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(module));
    }

    /**
     * DELETE MODULE
     * @param serviceid
     * @param moduleid
     * @return
     */
    @DeleteMapping("/modules/{serviceid}/{moduleid}")
    @Timed
    public ResponseEntity<Void> deleteModule(@PathVariable("serviceid") String serviceid,@PathVariable("moduleid") String moduleid) {

        Service service=serviceRepository.findOne(serviceid);
        Module module= service.getMoudles().stream().filter(m -> m.getId().equals(moduleid)).findFirst().get();
        service.getMoudles().remove(module);
        Service result=serviceRepository.save(service);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, serviceid)).build();
    }
}
