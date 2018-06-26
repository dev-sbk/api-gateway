package com.epi.pfa.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Module.
 */
@Document(collection = "module")
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Size(min = 3, max = 255)
    @Field("name")
    private String name;

    @NotNull
    @Size(min = 3, max = 255)
    @Field("description")
    private String description;

    @NotNull
    @Field("module")
    private byte[] module;

    @Field("module_content_type")
    private String moduleContentType;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Module name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Module description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getModule() {
        return module;
    }

    public Module module(byte[] module) {
        this.module = module;
        return this;
    }

    public void setModule(byte[] module) {
        this.module = module;
    }

    public String getModuleContentType() {
        return moduleContentType;
    }

    public Module moduleContentType(String moduleContentType) {
        this.moduleContentType = moduleContentType;
        return this;
    }

    public void setModuleContentType(String moduleContentType) {
        this.moduleContentType = moduleContentType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Module module = (Module) o;
        if (module.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), module.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Module{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", module='" + getModule() + "'" +
            ", moduleContentType='" + getModuleContentType() + "'" +
            "}";
    }
}
