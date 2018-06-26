package com.epi.pfa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Document(collection = "addresse")
public class Address implements Serializable {
    @Id
    private String id;
    private Country country;
    @NotNull
    @Size(min = 5, max = 255)
    @Field("city")
    private String city;

    @NotNull
    @Size(max = 255)
    @Field("addressline_1")
    private String addressline1;

    @NotNull
    @Size(max = 255)
    @Field("addressline_2")
    private String addressline2;

    @NotNull
    @Size(max = 255)
    @Field("zipcode")
    private String zipcode;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public Address city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public Address addressline1(String addressline1) {
        this.addressline1 = addressline1;
        return this;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public Address addressline2(String addressline2) {
        this.addressline2 = addressline2;
        return this;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Address zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(addressline1, address.addressline1) &&
                Objects.equals(addressline2, address.addressline2) &&
                Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, country, city, addressline1, addressline2, zipcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", country=" + country +
                ", city='" + city + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
