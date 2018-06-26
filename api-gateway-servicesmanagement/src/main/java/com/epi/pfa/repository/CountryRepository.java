package com.epi.pfa.repository;

import com.epi.pfa.domain.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 5/30/18
 * @time 6:54 PM
 * @utitlity Country
 */
@Repository
public interface CountryRepository  extends MongoRepository<Country,String>{
}
