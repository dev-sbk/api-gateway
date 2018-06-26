package com.epi.pfa.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

@Document(collection = "store")
public class Store implements Serializable {
    @Id
    private String id;
    @Field("city")
    @NotNull
    @Size(min = 3, max = 45)
    private String city;
    @Field("zip_code")
    @NotNull
    private String posCode;
    @Field("latitude")
    private double latitude;
    @Field("longitude")
    private double longitude;
    @Field("phone")
    private String phone;
    @Field("fax")
    private String fax;
    @Email()
    private String email;
    @Field("actived")
    private boolean active;
    @CreatedDate
    @Field("date_add")
    private Instant dateAdd = Instant.now();
    @LastModifiedDate
    @Field("date_upd")
    private Instant dateUpd = Instant.now();
    public Country country;
    public Shop shop;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (Double.compare(store.getLatitude(), getLatitude()) != 0) return false;
        if (Double.compare(store.getLongitude(), getLongitude()) != 0) return false;
        if (isActive() != store.isActive()) return false;
        if (getId() != null ? !getId().equals(store.getId()) : store.getId() != null) return false;
        if (getCity() != null ? !getCity().equals(store.getCity()) : store.getCity() != null) return false;
        if (getPosCode() != null ? !getPosCode().equals(store.getPosCode()) : store.getPosCode() != null) return false;
        if (getPhone() != null ? !getPhone().equals(store.getPhone()) : store.getPhone() != null) return false;
        if (getFax() != null ? !getFax().equals(store.getFax()) : store.getFax() != null) return false;
        if (getEmail() != null ? !getEmail().equals(store.getEmail()) : store.getEmail() != null) return false;
        if (getDateAdd() != null ? !getDateAdd().equals(store.getDateAdd()) : store.getDateAdd() != null) return false;
        if (getDateUpd() != null ? !getDateUpd().equals(store.getDateUpd()) : store.getDateUpd() != null) return false;
        if (getCountry() != null ? !getCountry().equals(store.getCountry()) : store.getCountry() != null) return false;
        return getShop() != null ? getShop().equals(store.getShop()) : store.getShop() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getPosCode() != null ? getPosCode().hashCode() : 0);
        temp = Double.doubleToLongBits(getLatitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLongitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getFax() != null ? getFax().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getDateAdd() != null ? getDateAdd().hashCode() : 0);
        result = 31 * result + (getDateUpd() != null ? getDateUpd().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getShop() != null ? getShop().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Store{" +
            "id='" + id + '\'' +
            ", city='" + city + '\'' +
            ", posCode='" + posCode + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", phone='" + phone + '\'' +
            ", fax='" + fax + '\'' +
            ", email='" + email + '\'' +
            ", active=" + active +
            ", dateAdd=" + dateAdd +
            ", dateUpd=" + dateUpd +
            ", country=" + country +
            ", shop=" + shop +
            '}';
    }
}
