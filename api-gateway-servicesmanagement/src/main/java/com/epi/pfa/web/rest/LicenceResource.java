package com.epi.pfa.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.epi.pfa.domain.Licence;

import com.epi.pfa.repository.LicenceRepository;
import com.epi.pfa.web.rest.errors.BadRequestAlertException;
import com.epi.pfa.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Licence.
 */
@RestController
@RequestMapping("/api")
public class LicenceResource {

    private final Logger log = LoggerFactory.getLogger(LicenceResource.class);

    private static final String ENTITY_NAME = "licence";

    private final LicenceRepository licenceRepository;

    public LicenceResource(LicenceRepository licenceRepository) {
        this.licenceRepository = licenceRepository;
    }

    /**
     * POST  /licences : Create a new licence.
     *
     * @param licence the licence to create
     * @return the ResponseEntity with status 201 (Created) and with body the new licence, or with status 400 (Bad Request) if the licence has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/licences")
    @Timed
    public ResponseEntity<Licence> createLicence(@RequestBody Licence licence) throws URISyntaxException {
        log.debug("REST request to save Licence : {}", licence);
        if (licence.getId() != null) {
            throw new BadRequestAlertException("A new licence cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Licence result = licenceRepository.save(licence);
        return ResponseEntity.created(new URI("/api/licences/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /licences : Updates an existing licence.
     *
     * @param licence the licence to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated licence,
     * or with status 400 (Bad Request) if the licence is not valid,
     * or with status 500 (Internal Server Error) if the licence couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/licences")
    @Timed
    public ResponseEntity<Licence> updateLicence(@RequestBody Licence licence) throws URISyntaxException {
        log.debug("REST request to update Licence : {}", licence);
        if (licence.getId() == null) {
            return createLicence(licence);
        }
        Licence result = licenceRepository.save(licence);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, licence.getId().toString()))
            .body(result);
    }

    /**
     * GET  /licences : get all the licences.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of licences in body
     */
    @GetMapping("/licences")
    @Timed
    public List<Licence> getAllLicences() {
        log.debug("REST request to get all Licences");
        return licenceRepository.findAll();
        }

    /**
     * GET  /licences/:id : get the "id" licence.
     *
     * @param id the id of the licence to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the licence, or with status 404 (Not Found)
     */
    @GetMapping("/licences/{id}")
    @Timed
    public ResponseEntity<Licence> getLicence(@PathVariable String id) {
        log.debug("REST request to get Licence : {}", id);
        Licence licence = licenceRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(licence));
    }

    /**
     * DELETE  /licences/:id : delete the "id" licence.
     *
     * @param id the id of the licence to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/licences/{id}")
    @Timed
    public ResponseEntity<Void> deleteLicence(@PathVariable String id) {
        log.debug("REST request to delete Licence : {}", id);
        licenceRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
