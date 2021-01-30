package br.com.rfasioli.demomongoconn.pgsql;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_entidade")
public class Entidade implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "description")
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Entidade() {
    }

    public Entidade(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Entidade [description=" + description + ", id=" + id + "]";
    }

}