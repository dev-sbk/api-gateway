package com.epi.pfa.domain;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;
@Document(collection = "message")
public class Message implements Serializable {
    @Id
   private String id;
    @Field("message")
    @NotNull
    @Size(min=1,max = 255)
    private String message;
    @CreatedDate
    @Field("date_add")
    @NotNull
    private Instant dateAdd=Instant.now();
    private Cart cart;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Instant dateAdd) {
        this.dateAdd = dateAdd;
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
        if (!(o instanceof Message)) return false;

        Message message1 = (Message) o;

        if (getId() != null ? !getId().equals(message1.getId()) : message1.getId() != null) return false;
        if (getMessage() != null ? !getMessage().equals(message1.getMessage()) : message1.getMessage() != null)
            return false;
        if (getDateAdd() != null ? !getDateAdd().equals(message1.getDateAdd()) : message1.getDateAdd() != null)
            return false;
        return getCart() != null ? getCart().equals(message1.getCart()) : message1.getCart() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getDateAdd() != null ? getDateAdd().hashCode() : 0);
        result = 31 * result + (getCart() != null ? getCart().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
            "id='" + id + '\'' +
            ", message='" + message + '\'' +
            ", dateAdd=" + dateAdd +
            ", cart=" + cart +
            '}';
    }
}
