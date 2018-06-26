package com.epi.pfa.repository;

import com.epi.pfa.domain.Service;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring Data MongoDB repository for the Service entity.
 */
@Repository
@Transactional
public interface ServiceRepository extends MongoRepository<Service, String> {

}
