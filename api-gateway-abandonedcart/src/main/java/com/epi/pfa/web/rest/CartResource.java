package com.epi.pfa.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.epi.pfa.domain.Cart;
import com.epi.pfa.repository.CartRepository;
import com.epi.pfa.web.rest.errors.BadRequestAlertException;
import com.epi.pfa.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Cart controller
 */
@RestController
@RequestMapping("/api/abandoned-cart-api")
public class CartResource {

    private static final String ENTITY_NAME = "cart";
    private CartRepository cartRepository;
    private final Logger log = LoggerFactory.getLogger(AbandonedCartAPIResource.class);
    public CartResource (CartRepository cartRepository){
        this.cartRepository=cartRepository;
    }
    /**
     * ADD NEW CART
     * @param cart
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/cart")
    @Timed
    public ResponseEntity<Cart> createCart (@Valid @RequestBody Cart cart) throws URISyntaxException {
        log.debug("REST request to save Service : {}", cart);
        if (cart.getId() != null) {
            throw new BadRequestAlertException("A new cart cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cart result = cartRepository.save(cart);
        return ResponseEntity.created(new URI("/api/abandoned-cart-api/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * DELETE CART BY SECURE KEY
     * @param key
     * @return
     */
    @DeleteMapping("/cart/{key}")
    @Timed
    public ResponseEntity<Void> deleteService(@PathVariable String key) {
        log.debug("REST request to delete Cart : {}", key);
        Cart cart=cartRepository.findCartBySecureKey(key);
        if(cart!=null){
            cartRepository.delete(cart);
        }
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, key)).build();
    }

}
