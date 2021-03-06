/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author guthemberg
 */
@Entity
@Table(name="DIRETOR")
public class Diretor extends Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @Column(name="companhia_de_teatro",nullable = false)
    public String companhiaDeTeatro;
    
    @OneToMany(mappedBy = "diretor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Espetaculo> esptetaculosDirigidos;

    public TipoDiretor tipoDiretor;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanhiaDeTeatro() {
        return companhiaDeTeatro;
    }

    public void setCompanhiaDeTeatro(String companhiaDeTeatro) {
        this.companhiaDeTeatro = companhiaDeTeatro;
    }

    public List<Espetaculo> getEsptetaculosDirigidos() {
        return esptetaculosDirigidos;
    }

    public void setEsptetaculosDirigidos(List<Espetaculo> esptetaculosDirigidos) {
        this.esptetaculosDirigidos = esptetaculosDirigidos;
    }

    public TipoDiretor getTipoDiretor() {
        return tipoDiretor;
    }

    public void setTipoDiretor(TipoDiretor tipoDiretor) {
        this.tipoDiretor = tipoDiretor;
    }
    
    
}
