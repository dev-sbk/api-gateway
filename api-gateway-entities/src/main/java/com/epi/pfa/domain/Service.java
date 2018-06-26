package com.epi.pfa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A Service.
 */
@Document(collection = "service")
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Size(min = 5, max = 255)
    @Field("name")
    private String name;

    @NotNull
    @Size(max = 255)
    @Field("description")
    private String description;

    @NotNull
    @Size(max = 255)
    @Field("url")
    private String url;

    @NotNull
    @Field("dateadd")
    private LocalDate dateadd;

    @NotNull
    @Field("state")
    private State state;

    @NotNull
    @Field("licence_type")
    private LicenceType licenceType;
    @DBRef()
    private List<Module> moudles=new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDate getDateadd() {
        return dateadd;
    }

    public void setDateadd(LocalDate dateadd) {
        this.dateadd = dateadd;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LicenceType getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(LicenceType licenceType) {
        this.licenceType = licenceType;
    }

    public List<Module> getMoudles() {
        return moudles;
    }

    public void setMoudles(List<Module> moudles) {
        this.moudles = moudles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id) &&
                Objects.equals(name, service.name) &&
                Objects.equals(description, service.description) &&
                Objects.equals(url, service.url) &&
                Objects.equals(dateadd, service.dateadd) &&
                state == service.state &&
                licenceType == service.licenceType &&
                Objects.equals(moudles, service.moudles);
    }
    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, url, dateadd, state, licenceType, moudles);
    }
    @Override
    public String toString() {
        return "Service{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", dateadd=" + dateadd +
                ", state=" + state +
                ", licenceType=" + licenceType +
                ", moudles=" + moudles +
                '}';
    }
}
