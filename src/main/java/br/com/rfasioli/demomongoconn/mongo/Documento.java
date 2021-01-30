package br.com.rfasioli.demomongoconn.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Documento {
    public static enum STATUS {
        PENDING,
        DONE
    }

    @Id
    private String id;

    private String description;

    private STATUS status;

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

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public Documento() {}

    public Documento(String description, STATUS status) {
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Documento [id=" + id + ", description=" + description + ", status=" + status + "]";
    }

}