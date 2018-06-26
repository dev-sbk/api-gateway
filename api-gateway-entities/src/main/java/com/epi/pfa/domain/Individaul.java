package com.epi.pfa.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Document(collection = "user")
@TypeAlias("Individaul")
public class Individaul extends User {
    @Field("cin")
    @NotNull
    @Size(min = 1, max = 255)
    private String cin;
    @Field("passport_number")
    @Size(min = 1, max = 255)
    private String passportNumber;
    @Field("gender")
    @Size(min = 1, max = 50)
    private Gender gender;
    @Field("tel")
    @Size(min = 1, max = 255)
    private String tel;
    public Collection<Address> address;
    public BankCard bankCard;
    public Collection<Service> services;

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Address> getAddress() {
        return address;
    }

    public void setAddress(Collection<Address> address) {
        this.address = address;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public Collection<Service> getServices() {
        return services;
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Individaul)) return false;
        if (!super.equals(o)) return false;

        Individaul that = (Individaul) o;

        if (getCin() != null ? !getCin().equals(that.getCin()) : that.getCin() != null) return false;
        if (getPassportNumber() != null ? !getPassportNumber().equals(that.getPassportNumber()) : that.getPassportNumber() != null)
            return false;
        if (getGender() != that.getGender()) return false;
        if (getTel() != null ? !getTel().equals(that.getTel()) : that.getTel() != null) return false;
        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
        if (getBankCard() != null ? !getBankCard().equals(that.getBankCard()) : that.getBankCard() != null)
            return false;
        return getServices() != null ? getServices().equals(that.getServices()) : that.getServices() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCin() != null ? getCin().hashCode() : 0);
        result = 31 * result + (getPassportNumber() != null ? getPassportNumber().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getTel() != null ? getTel().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getBankCard() != null ? getBankCard().hashCode() : 0);
        result = 31 * result + (getServices() != null ? getServices().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Individaul{" +
            "cin='" + cin + '\'' +
            ", passportNumber='" + passportNumber + '\'' +
            ", gender=" + gender +
            ", tel='" + tel + '\'' +
            ", address=" + address +
            ", bankCard=" + bankCard +
            ", services=" + services +
            '}';
    }
}
