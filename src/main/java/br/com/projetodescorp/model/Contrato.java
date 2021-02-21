/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gersonbrandao
 */
@Entity
@Table(name="Contrato")
public class Contrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "cache", nullable = false)
    public String cache;

    public Long getId() {
        return id;
    }

    public Ator getAtor() {
        return ator;
    }

    public String getCache() {
        return cache;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }
    
    
}
