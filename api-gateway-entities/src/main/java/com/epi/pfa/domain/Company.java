package com.epi.pfa.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Document(collection = "user")
@TypeAlias("company")
public class Company extends User {
    @Field("name")
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    @Field("fax")
    @NotNull
    @Size(min = 1, max = 255)
    private String fax;
    @Field("tax_number")
    @NotNull
    @Size(min = 1, max = 50)
    private String taxNumber;
    @Field("phone")
    @NotNull
    @Size(min = 1, max = 50)
    private String phone;
    public Collection<Address> address;
    public BankCard bankCard;
    public Collection<Service> services;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (!(o instanceof Company)) return false;
        if (!super.equals(o)) return false;

        Company company = (Company) o;

        if (getName() != null ? !getName().equals(company.getName()) : company.getName() != null) return false;
        if (getFax() != null ? !getFax().equals(company.getFax()) : company.getFax() != null) return false;
        if (getTaxNumber() != null ? !getTaxNumber().equals(company.getTaxNumber()) : company.getTaxNumber() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(company.getPhone()) : company.getPhone() != null) return false;
        if (getAddress() != null ? !getAddress().equals(company.getAddress()) : company.getAddress() != null)
            return false;
        if (getBankCard() != null ? !getBankCard().equals(company.getBankCard()) : company.getBankCard() != null)
            return false;
        return getServices() != null ? getServices().equals(company.getServices()) : company.getServices() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getFax() != null ? getFax().hashCode() : 0);
        result = 31 * result + (getTaxNumber() != null ? getTaxNumber().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getBankCard() != null ? getBankCard().hashCode() : 0);
        result = 31 * result + (getServices() != null ? getServices().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
            "name='" + name + '\'' +
            ", fax='" + fax + '\'' +
            ", taxNumber='" + taxNumber + '\'' +
            ", phone='" + phone + '\'' +
            ", address=" + address +
            ", bankCard=" + bankCard +
            ", services=" + services +
            '}';
    }
}
