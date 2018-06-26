package com.epi.pfa.domain;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Document(collection = "customer")
public class Customer implements Serializable {
    @Id
    private String id;
    @Size(max = 50)
    @Field("first_name")
    private String firstName;
    @Size(max = 50)
    @Field("last_name")
    private String lastName;
    @Email
    @Size(min = 5, max = 100)
    @Indexed
    private String email;
    @CreatedDate
    @Field("birth_day")
    private Instant birthDay = Instant.now();
    @Size(max = 50)
    @Field("company")
    private String company;
    @Size(max = 50)
    @Field("secure_key")
    private String secureKey;
    @Field("active")
    private boolean active;
    @Field("delete")
    private boolean delete;
    @Size(max = 50)
    @Field("gender")
    private Gender gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Instant birthDay) {
        this.birthDay = birthDay;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSecureKey() {
        return secureKey;
    }

    public void setSecureKey(String secureKey) {
        this.secureKey = secureKey;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthDay=" + birthDay +
                ", company='" + company + '\'' +
                ", secureKey='" + secureKey + '\'' +
                ", active=" + active +
                ", delete=" + delete +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return active == customer.active &&
                delete == customer.delete &&
                Objects.equals(id, customer.id) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(birthDay, customer.birthDay) &&
                Objects.equals(company, customer.company) &&
                Objects.equals(secureKey, customer.secureKey) &&
                gender == customer.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, lastName, email, birthDay, company, secureKey, active, delete, gender);
    }
}
