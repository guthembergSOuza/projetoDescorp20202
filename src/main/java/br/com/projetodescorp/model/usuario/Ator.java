/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.model.usuario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author guthemberg
 */
@Entity
@Table(name="ATOR")
public class Ator extends Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @Column(name="drt",nullable = false, unique=true)
    public String drt;
    @Column(name="cidade",nullable = false)
    public String cidade;
    @Column(name="uf",nullable = false)
    public String uf;
    @Column(name="disponivel",nullable = false)
    public Boolean disponivel;
    //public List<Espetaculo> espetaculos;
    //public 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrt() {
        return drt;
    }

    public void setDrt(String drt) {
        this.drt = drt;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
