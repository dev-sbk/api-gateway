package com.epi.pfa.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;
@Document(collection = "tracking_customer")
public class TrackingCustomer implements Serializable {
    @Id
   private String id;
    @CreatedDate
    @Field("trace_date")
   private Instant traceDate;
   @DateTimeFormat
   @Field("time")
   private Instant time;
   @Field("id_address")
   private String ipAddresse;
   @Field("os")
   private String os;
   @Field("web_browser")
   private String webBorwser;
   public Collection<Cart> carts;
   public Collection<Shopping> shoppings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTraceDate() {
        return traceDate;
    }

    public void setTraceDate(Instant traceDate) {
        this.traceDate = traceDate;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getIpAddresse() {
        return ipAddresse;
    }

    public void setIpAddresse(String ipAddresse) {
        this.ipAddresse = ipAddresse;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getWebBorwser() {
        return webBorwser;
    }

    public void setWebBorwser(String webBorwser) {
        this.webBorwser = webBorwser;
    }

    public Collection<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Collection<Cart> carts) {
        this.carts = carts;
    }

    public Collection<Shopping> getShoppings() {
        return shoppings;
    }

    public void setShoppings(Collection<Shopping> shoppings) {
        this.shoppings = shoppings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrackingCustomer)) return false;

        TrackingCustomer that = (TrackingCustomer) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getTraceDate() != null ? !getTraceDate().equals(that.getTraceDate()) : that.getTraceDate() != null)
            return false;
        if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
        if (getIpAddresse() != null ? !getIpAddresse().equals(that.getIpAddresse()) : that.getIpAddresse() != null)
            return false;
        if (getOs() != null ? !getOs().equals(that.getOs()) : that.getOs() != null) return false;
        if (getWebBorwser() != null ? !getWebBorwser().equals(that.getWebBorwser()) : that.getWebBorwser() != null)
            return false;
        if (getCarts() != null ? !getCarts().equals(that.getCarts()) : that.getCarts() != null) return false;
        return getShoppings() != null ? getShoppings().equals(that.getShoppings()) : that.getShoppings() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTraceDate() != null ? getTraceDate().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        result = 31 * result + (getIpAddresse() != null ? getIpAddresse().hashCode() : 0);
        result = 31 * result + (getOs() != null ? getOs().hashCode() : 0);
        result = 31 * result + (getWebBorwser() != null ? getWebBorwser().hashCode() : 0);
        result = 31 * result + (getCarts() != null ? getCarts().hashCode() : 0);
        result = 31 * result + (getShoppings() != null ? getShoppings().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrackingCustomer{" +
            "id='" + id + '\'' +
            ", traceDate=" + traceDate +
            ", time=" + time +
            ", ipAddresse='" + ipAddresse + '\'' +
            ", os='" + os + '\'' +
            ", webBorwser='" + webBorwser + '\'' +
            ", carts=" + carts +
            ", shoppings=" + shoppings +
            '}';
    }
}
