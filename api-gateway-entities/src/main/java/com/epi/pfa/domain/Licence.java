package com.epi.pfa.domain;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Document(collection = "licence")
public class Licence implements Serializable {
    @Id
    private String id;
    @Field("key")
    @NotNull
    @Size(min = 10, max = 255)
    private String key;
    @CreatedDate
    @Field("start_date")
    @NotNull
    private Instant startDate = Instant.now();
    @LastModifiedDate
    @Field("end_date")
    @NotNull
    private Instant endDate = Instant.now();
    @Field("enabled")
    private Boolean enabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licence licence = (Licence) o;
        return Objects.equals(id, licence.id) &&
                Objects.equals(key, licence.key) &&
                Objects.equals(startDate, licence.startDate) &&
                Objects.equals(endDate, licence.endDate) &&
                Objects.equals(enabled, licence.enabled);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, key, startDate, endDate, enabled);
    }

    @Override
    public java.lang.String toString() {
        return "Licence{" +
                "id=" + id +
                ", key=" + key +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", enabled=" + enabled +
                '}';
    }
}
