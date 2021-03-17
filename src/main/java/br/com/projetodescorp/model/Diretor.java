/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author guthemberg
 */
@Entity
@Table(name = "DIRETOR")
@DiscriminatorValue(value = "D")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Diretor.PorId",
                    query = "SELECT d FROM Diretor d WHERE d.id = :id"
            )
        }
)
public class Diretor extends Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="companhia_de_teatro",nullable = false)
    private String companhiaDeTeatro;
    
    @OneToMany(mappedBy = "diretor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Espetaculo> esptetaculosDirigidos;
    
    @NotBlank
    //@ValidaTipoDiretor
    @Pattern(regexp = "[1-4]{1}", message = "{br.com.projetodescorp.model.Diretor.tipoDiretor}")
    @Size(min = 1, max = 1)
    @Column(name = "tipoDiretor")
    
    private TipoDiretor tipoDiretor;
    
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Diretor other = (Diretor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
