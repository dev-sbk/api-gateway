package com.epi.pfa.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Document(collection = "product")
public class Product implements Serializable {
    @Id
    private String id;
    @Field("isbn")
    private String isbn;
    @Field("reference")
    private String reference;
    @Field("upc")
    private String upc;
    @Field("price")
    private double price;
    @Field("quantite")
    private int quantite;
    @Field("avaible_date")
    private Instant avaibleDate = Instant.now();
    @CreatedDate
    @Field("date_add")
    @NotNull
    private Instant dateAdd = Instant.now();
    @LastModifiedDate
    @Field("date_upd")
    private Instant dateUpd = Instant.now();
    @Field("width")
    private double width;
    @Field("height")
    private double height;
    @Field("weight")
    private double weight;
    public Image image;
    public Category category;
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Instant getAvaibleDate() {
        return avaibleDate;
    }

    public void setAvaibleDate(Instant avaibleDate) {
        this.avaibleDate = avaibleDate;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getQuantite() != product.getQuantite()) return false;
        if (Double.compare(product.getWidth(), getWidth()) != 0) return false;
        if (Double.compare(product.getHeight(), getHeight()) != 0) return false;
        if (Double.compare(product.getWeight(), getWeight()) != 0) return false;
        if (getImage() != null ? !getImage().equals(product.getImage()) : product.getImage() != null) return false;
        if (getCategory() != null ? !getCategory().equals(product.getCategory()) : product.getCategory() != null)
            return false;
        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
        if (getIsbn() != null ? !getIsbn().equals(product.getIsbn()) : product.getIsbn() != null) return false;
        if (getReference() != null ? !getReference().equals(product.getReference()) : product.getReference() != null)
            return false;
        if (getUpc() != null ? !getUpc().equals(product.getUpc()) : product.getUpc() != null) return false;
        if (getAvaibleDate() != null ? !getAvaibleDate().equals(product.getAvaibleDate()) : product.getAvaibleDate() != null)
            return false;
        if (getDateAdd() != null ? !getDateAdd().equals(product.getDateAdd()) : product.getDateAdd() != null)
            return false;
        return getDateUpd() != null ? getDateUpd().equals(product.getDateUpd()) : product.getDateUpd() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getImage() != null ? getImage().hashCode() : 0;
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getIsbn() != null ? getIsbn().hashCode() : 0);
        result = 31 * result + (getReference() != null ? getReference().hashCode() : 0);
        result = 31 * result + (getUpc() != null ? getUpc().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getQuantite();
        result = 31 * result + (getAvaibleDate() != null ? getAvaibleDate().hashCode() : 0);
        result = 31 * result + (getDateAdd() != null ? getDateAdd().hashCode() : 0);
        result = 31 * result + (getDateUpd() != null ? getDateUpd().hashCode() : 0);
        temp = Double.doubleToLongBits(getWidth());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
            "image=" + image +
            ", category=" + category +
            ", id='" + id + '\'' +
            ", isbn='" + isbn + '\'' +
            ", reference='" + reference + '\'' +
            ", upc='" + upc + '\'' +
            ", price=" + price +
            ", quantite=" + quantite +
            ", avaibleDate=" + avaibleDate +
            ", dateAdd=" + dateAdd +
            ", dateUpd=" + dateUpd +
            ", width=" + width +
            ", height=" + height +
            ", weight=" + weight +
            '}';
    }
}
