package com.epi.pfa.repository;

import com.epi.pfa.domain.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Saber Ben Khalifa <dev.saberkhalifda@gmail.com>
 * @date 5/30/18
 * @time 11:18 PM
 * @utitlity CartRepository
 */
@Repository
public interface CartRepository  extends MongoRepository<Cart,String>{
    public Cart findCartBySecureKey(String key);
}
