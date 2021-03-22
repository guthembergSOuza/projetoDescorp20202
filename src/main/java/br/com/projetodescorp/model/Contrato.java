/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gersonbrandao
 */
@Entity
@Table(name = "CONTRATO")
public class Contrato implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cache", nullable = false)
    @Min(100)
    private Double cache;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @NotNull
    @JoinColumn(name = "id_ator", referencedColumnName = "id", nullable = false)
    private Ator ator;

    public Long getId() {
        return id;
    }

    public Ator getAtor() {
        return ator;
    }

    public Double getCache() {
        return cache;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public void setCache(Double cache) {
        this.cache = cache;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contrato other = (Contrato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

}
