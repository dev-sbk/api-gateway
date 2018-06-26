package com.epi.pfa.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;

@Document(collection = "conversation")
public class Conversation implements Serializable {
   @Id
   private String id;
   @Field("query")
   private String query;
   @Field("version")
   private Date version;
   @CreatedDate
   @Field
   @NotNull
   private Instant dateAdd=Instant.now();
   @Field("active")
   private boolean active;
   @Field("delete")
   private boolean delete;
   private Customer customer;
   private Collection<Message> messages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Instant dateAdd) {
        this.dateAdd = dateAdd;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<Message> getMessages() {
        return messages;
    }

    public void setMessages(Collection<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Conversation{" +
            "id='" + id + '\'' +
            ", dateAdd=" + dateAdd +
            ", active=" + active +
            ", delete=" + delete +
            ", customer=" + customer +
            ", messages=" + messages +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conversation)) return false;

        Conversation that = (Conversation) o;

        if (isActive() != that.isActive()) return false;
        if (isDelete() != that.isDelete()) return false;
        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getDateAdd() != null ? !getDateAdd().equals(that.getDateAdd()) : that.getDateAdd() != null) return false;
        if (getCustomer() != null ? !getCustomer().equals(that.getCustomer()) : that.getCustomer() != null)
            return false;
        return getMessages() != null ? getMessages().equals(that.getMessages()) : that.getMessages() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDateAdd() != null ? getDateAdd().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (isDelete() ? 1 : 0);
        result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
        result = 31 * result + (getMessages() != null ? getMessages().hashCode() : 0);
        return result;
    }
}
