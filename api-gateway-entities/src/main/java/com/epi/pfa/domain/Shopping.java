package com.epi.pfa.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;
@Document(collection = "shopping")
public class Shopping implements Serializable {
    @Id
   private String id;
    @CreatedDate
    @Field("date_shopping")
   private Instant dateShopping=Instant.now();
   @Field("time")
   @DateTimeFormat
    private Instant time=Instant.now();
   @Field("tag")
   private String tag;
    @Field("min_price")
   private double minPrice;
    @Field("max_price")
   private double maxPrice;
    @Field("secure_key")
   private String secureKey;
    public TrackingCustomer trackingCustomer;
   public Customer customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDateShopping() {
        return dateShopping;
    }

    public void setDateShopping(Instant dateShopping) {
        this.dateShopping = dateShopping;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        this.secureKey = secureKey;
    }

    public TrackingCustomer getTrackingCustomer() {
        return trackingCustomer;
    }

    public void setTrackingCustomer(TrackingCustomer trackingCustomer) {
        this.trackingCustomer = trackingCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shopping)) return false;

        Shopping shopping = (Shopping) o;

        if (Double.compare(shopping.getMinPrice(), getMinPrice()) != 0) return false;
        if (Double.compare(shopping.getMaxPrice(), getMaxPrice()) != 0) return false;
        if (getId() != null ? !getId().equals(shopping.getId()) : shopping.getId() != null) return false;
        if (getDateShopping() != null ? !getDateShopping().equals(shopping.getDateShopping()) : shopping.getDateShopping() != null)
            return false;
        if (getTime() != null ? !getTime().equals(shopping.getTime()) : shopping.getTime() != null) return false;
        if (getTag() != null ? !getTag().equals(shopping.getTag()) : shopping.getTag() != null) return false;
        if (getSecureKey() != null ? !getSecureKey().equals(shopping.getSecureKey()) : shopping.getSecureKey() != null)
            return false;
        if (getTrackingCustomer() != null ? !getTrackingCustomer().equals(shopping.getTrackingCustomer()) : shopping.getTrackingCustomer() != null)
            return false;
        return getCustomer() != null ? getCustomer().equals(shopping.getCustomer()) : shopping.getCustomer() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDateShopping() != null ? getDateShopping().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        result = 31 * result + (getTag() != null ? getTag().hashCode() : 0);
        temp = Double.doubleToLongBits(getMinPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMaxPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getSecureKey() != null ? getSecureKey().hashCode() : 0);
        result = 31 * result + (getTrackingCustomer() != null ? getTrackingCustomer().hashCode() : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shopping{" +
            "id='" + id + '\'' +
            ", dateShopping=" + dateShopping +
            ", time=" + time +
            ", tag='" + tag + '\'' +
            ", minPrice=" + minPrice +
            ", maxPrice=" + maxPrice +
            ", secureKey='" + secureKey + '\'' +
            ", trackingCustomer=" + trackingCustomer +
            ", customer=" + customer +
            '}';
    }
}
