package com.epi.pfa.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Country controller
 */
@RestController
@RequestMapping("/api/country")
public class CountryResource {

    private final Logger log = LoggerFactory.getLogger(CountryResource.class);

    /**
    * GET countries
    */
    @GetMapping("/countries")
    public String countries() {
        return "countries";
    }

    /**
    * GET country
    */
    @GetMapping("/country")
    public String getCountryByName() {
        return "country";
    }

    /**
    * POST country
    */
    @PostMapping("/country")
    public String addCountry() {
        return "country";
    }

    /**
    * PUT country
    */
    @PutMapping("/country")
    public String updateCountry() {
        return "country";
    }

    /**
    * DELETE country
    */
    @DeleteMapping("/country")
    public String deleteCountry() {
        return "country";
    }

}
