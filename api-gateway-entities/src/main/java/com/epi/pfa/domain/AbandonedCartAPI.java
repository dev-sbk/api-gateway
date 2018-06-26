package com.epi.pfa.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Collection;

@Document(collection = "service")
@TypeAlias("abandoned_cart_api")
public class AbandonedCartAPI extends Service {
  @Field("date_add")
   private Instant dateAdd=Instant.now();
   @Field("delete")
   private boolean delete;
   @Field("actived")
   private boolean active;
   @Field("recyclebale")
   private boolean recycleable;
   private Collection<CronJobs> cronJobs;
    public Instant getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Instant dateAdd) {
        this.dateAdd = dateAdd;
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

    public boolean isRecycleable() {
        return recycleable;
    }

    public void setRecycleable(boolean recycleable) {
        this.recycleable = recycleable;
    }

    public Collection<CronJobs> getCronJobs() {
        return cronJobs;
    }

    public void setCronJobs(Collection<CronJobs> cronJobs) {
        this.cronJobs = cronJobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbandonedCartAPI)) return false;

        AbandonedCartAPI that = (AbandonedCartAPI) o;

        if (isDelete() != that.isDelete()) return false;
        if (isActive() != that.isActive()) return false;
        if (isRecycleable() != that.isRecycleable()) return false;
        if (getDateAdd() != null ? !getDateAdd().equals(that.getDateAdd()) : that.getDateAdd() != null) return false;
        return getCronJobs() != null ? getCronJobs().equals(that.getCronJobs()) : that.getCronJobs() == null;
    }

    @Override
    public int hashCode() {
        int result = getDateAdd() != null ? getDateAdd().hashCode() : 0;
        result = 31 * result + (isDelete() ? 1 : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (isRecycleable() ? 1 : 0);
        result = 31 * result + (getCronJobs() != null ? getCronJobs().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AbandonedCartAPI{" +
            "dateAdd=" + dateAdd +
            ", delete=" + delete +
            ", active=" + active +
            ", recycleable=" + recycleable +
            ", cronJobs=" + cronJobs +
            '}';
    }
}
