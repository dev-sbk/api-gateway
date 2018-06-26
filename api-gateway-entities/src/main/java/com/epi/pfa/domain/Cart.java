package com.epi.pfa.domain;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
@Document(collection = "cart")
public class Cart implements Serializable {
   @Id
   private String id;
   @Field("secured_key")
   @NotNull
   @Size(min = 1,max = 255)
   private String secureKey;
   @Field("recyclable")
   private boolean recyclable;
   @CreatedDate
   @Field("date_add")
   private Instant dateAdd= Instant.now();
   @LastModifiedDate
   @Field("date_upd")
   private Instant dateUpd=Instant.now();
    @DBRef
   public Collection<Product> products;
    @DBRef
   public Customer customer;
    @DBRef
   private Shop shop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        this.secureKey = secureKey;
    }

    public boolean isRecyclable() {
        return recyclable;
    }

    public void setRecyclable(boolean recyclable) {
        this.recyclable = recyclable;
    }

    public Instant getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Instant dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Instant getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Instant dateUpd) {
        this.dateUpd = dateUpd;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        if (isRecyclable() != cart.isRecyclable()) return false;
        if (getId() != null ? !getId().equals(cart.getId()) : cart.getId() != null) return false;
        if (getSecureKey() != null ? !getSecureKey().equals(cart.getSecureKey()) : cart.getSecureKey() != null)
            return false;
        if (getDateAdd() != null ? !getDateAdd().equals(cart.getDateAdd()) : cart.getDateAdd() != null) return false;
        if (getDateUpd() != null ? !getDateUpd().equals(cart.getDateUpd()) : cart.getDateUpd() != null) return false;
        if (getProducts() != null ? !getProducts().equals(cart.getProducts()) : cart.getProducts() != null)
            return false;
        if (getCustomer() != null ? !getCustomer().equals(cart.getCustomer()) : cart.getCustomer() != null)
            return false;
        return getShop() != null ? getShop().equals(cart.getShop()) : cart.getShop() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getSecureKey() != null ? getSecureKey().hashCode() : 0);
        result = 31 * result + (isRecyclable() ? 1 : 0);
        result = 31 * result + (getDateAdd() != null ? getDateAdd().hashCode() : 0);
        result = 31 * result + (getDateUpd() != null ? getDateUpd().hashCode() : 0);
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getShop() != null ? getShop().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cart{" +
            "id='" + id + '\'' +
            ", secureKey='" + secureKey + '\'' +
            ", recyclable=" + recyclable +
            ", dateAdd=" + dateAdd +
            ", dateUpd=" + dateUpd +
            ", products=" + products +
            ", customer=" + customer +
            ", shop=" + shop +
            '}';
    }
}
