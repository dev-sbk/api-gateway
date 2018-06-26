package com.epi.pfa.repository;

import com.epi.pfa.domain.Module;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 6/11/18
 * @time 10:38 PM
 * @utitlity ModuleRespository
 */
@Repository
public interface ModuleRespository  extends MongoRepository<Module,ObjectId>{
}
