package com.epi.pfa.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.*;

@Document(collection = "service")
@TypeAlias("recommendation_engine_api")
public class RecommendationEngineAPI extends Service {
    @Field("tag")
    @NotNull
    @Size(min = 1, max = 50)
    private String tag;
    @CreatedDate
    @Field("date_add")
    private Instant dateAdd = Instant.now();
    @LastModifiedDate
    @Field("date_upd")
    private Instant dateUpd = Instant.now();
    @Field("delete")
    private boolean delete;
    @Field("active")
    private boolean active;
    private Collection<TrackingCustomer> trackingCustomers;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Collection<TrackingCustomer> getTrackingCustomers() {
        return trackingCustomers;
    }

    public void setTrackingCustomers(Collection<TrackingCustomer> trackingCustomers) {
        this.trackingCustomers = trackingCustomers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecommendationEngineAPI)) return false;

        RecommendationEngineAPI that = (RecommendationEngineAPI) o;

        if (isDelete() != that.isDelete()) return false;
        if (isActive() != that.isActive()) return false;
        if (getTag() != null ? !getTag().equals(that.getTag()) : that.getTag() != null) return false;
        if (getDateAdd() != null ? !getDateAdd().equals(that.getDateAdd()) : that.getDateAdd() != null) return false;
        if (getDateUpd() != null ? !getDateUpd().equals(that.getDateUpd()) : that.getDateUpd() != null) return false;
        return getTrackingCustomers() != null ? getTrackingCustomers().equals(that.getTrackingCustomers()) : that.getTrackingCustomers() == null;
    }

    @Override
    public int hashCode() {
        int result = getTag() != null ? getTag().hashCode() : 0;
        result = 31 * result + (getDateAdd() != null ? getDateAdd().hashCode() : 0);
        result = 31 * result + (getDateUpd() != null ? getDateUpd().hashCode() : 0);
        result = 31 * result + (isDelete() ? 1 : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getTrackingCustomers() != null ? getTrackingCustomers().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RecommendationEngineAPI{" +
            "tag='" + tag + '\'' +
            ", dateAdd=" + dateAdd +
            ", dateUpd=" + dateUpd +
            ", delete=" + delete +
            ", active=" + active +
            ", trackingCustomers=" + trackingCustomers +
            '}';
    }
}
