package com.epi.pfa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Document(collection = "image")
public class Image implements Serializable {
  @Id
   private String id;
  @Field("legende")
  @Size(min = 5,max = 255)
   private String legende;
    @Field("path")
    @Size(min = 5,max = 255)
    @NotNull
   private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegende() {
        return legende;
    }

    public void setLegende(String legende) {
        this.legende = legende;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
                Objects.equals(legende, image.legende) &&
                Objects.equals(path, image.path);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, legende, path);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", legende='" + legende + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
