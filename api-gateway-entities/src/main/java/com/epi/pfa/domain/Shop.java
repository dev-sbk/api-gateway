package com.epi.pfa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document(collection = "shop")
public class Shop implements Serializable {
    @Id
    private String id;
    @Field("name")
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @Field("theme_name")
    @NotNull
    @Size(min = 1, max = 50)
    private String themeName;
    @Field("actived")
    private boolean active;
    @Field("delete")
    private boolean delete;

    private Store store;

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

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;

        Shop shop = (Shop) o;

        if (isActive() != shop.isActive()) return false;
        if (isDelete() != shop.isDelete()) return false;
        if (getId() != null ? !getId().equals(shop.getId()) : shop.getId() != null) return false;
        if (getName() != null ? !getName().equals(shop.getName()) : shop.getName() != null) return false;
        if (getThemeName() != null ? !getThemeName().equals(shop.getThemeName()) : shop.getThemeName() != null)
            return false;
        return getStore() != null ? getStore().equals(shop.getStore()) : shop.getStore() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getThemeName() != null ? getThemeName().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (isDelete() ? 1 : 0);
        result = 31 * result + (getStore() != null ? getStore().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", themeName='" + themeName + '\'' +
            ", active=" + active +
            ", delete=" + delete +
            ", store=" + store +
            '}';
    }
}
