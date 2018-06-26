package com.epi.pfa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
@Document(collection = "cron_jobs")
public class CronJobs implements Serializable {
    @Id
   private String id;
    @Field("description")
    @NotNull
   private String description;
    @Field("tax")
    @NotNull
   private String task;
    @Field("hour")
    @NotNull
   private int hour;
    @Field("day")
    @NotNull
   private int day;
    @Field("month")
    @NotNull
   private int month;
    @Field("day_of_week")
    @NotNull
    private int dayOfWeek;
    @LastModifiedDate
   @Field("update_at")
   private Instant updateAt=Instant.now();
    @Field("active")
   private boolean active;
   public Cart cart;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CronJobs)) return false;

        CronJobs cronJobs = (CronJobs) o;

        if (getHour() != cronJobs.getHour()) return false;
        if (getDay() != cronJobs.getDay()) return false;
        if (getMonth() != cronJobs.getMonth()) return false;
        if (getDayOfWeek() != cronJobs.getDayOfWeek()) return false;
        if (isActive() != cronJobs.isActive()) return false;
        if (getId() != null ? !getId().equals(cronJobs.getId()) : cronJobs.getId() != null) return false;
        if (getDescription() != null ? !getDescription().equals(cronJobs.getDescription()) : cronJobs.getDescription() != null)
            return false;
        if (getTask() != null ? !getTask().equals(cronJobs.getTask()) : cronJobs.getTask() != null) return false;
        if (getUpdateAt() != null ? !getUpdateAt().equals(cronJobs.getUpdateAt()) : cronJobs.getUpdateAt() != null)
            return false;
        return getCart() != null ? getCart().equals(cronJobs.getCart()) : cronJobs.getCart() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getTask() != null ? getTask().hashCode() : 0);
        result = 31 * result + getHour();
        result = 31 * result + getDay();
        result = 31 * result + getMonth();
        result = 31 * result + getDayOfWeek();
        result = 31 * result + (getUpdateAt() != null ? getUpdateAt().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getCart() != null ? getCart().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CronJobs{" +
            "id='" + id + '\'' +
            ", description='" + description + '\'' +
            ", task='" + task + '\'' +
            ", hour=" + hour +
            ", day=" + day +
            ", month=" + month +
            ", dayOfWeek=" + dayOfWeek +
            ", updateAt=" + updateAt +
            ", active=" + active +
            ", cart=" + cart +
            '}';
    }
}
