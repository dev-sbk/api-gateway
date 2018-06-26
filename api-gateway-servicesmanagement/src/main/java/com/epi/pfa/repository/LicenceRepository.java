package com.epi.pfa.repository;

import com.epi.pfa.domain.Licence;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Licence entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LicenceRepository extends MongoRepository<Licence, String> {

}
