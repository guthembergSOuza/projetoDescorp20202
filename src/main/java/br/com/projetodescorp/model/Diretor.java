package br.com.projetodescorp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "DIRETOR")
@DiscriminatorValue(value = "D")
@PrimaryKeyJoinColumn(name="ID", referencedColumnName = "ID")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Diretor.PorId",
                    query = "SELECT d FROM Diretor d WHERE d.id = :id"
            )
        }
)
public class Diretor extends Usuario implements Serializable {
    
    @NotNull
    @ValidaCompanhiaDiretor
    @Column(name="companhia_de_teatro",nullable = false)
    private String companhiaDeTeatro;
    
    @OneToMany(mappedBy = "diretor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Espetaculo> espetaculosDirigidos;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDiretor")
    private TipoDiretor tipoDiretor;

    public String getCompanhiaDeTeatro() {
        return companhiaDeTeatro;
    }

    public void setCompanhiaDeTeatro(String companhiaDeTeatro) {
        this.companhiaDeTeatro = companhiaDeTeatro;
    }

    public List<Espetaculo> getEsptetaculosDirigidos() {
        return espetaculosDirigidos;
    }

    public void setEspetaculosDirigidos(List<Espetaculo> espetaculosDirigidos) {
        this.espetaculosDirigidos = espetaculosDirigidos;
    }

    public TipoDiretor getTipoDiretor() {
        return tipoDiretor;
    }

    public void setTipoDiretor(TipoDiretor tipoDiretor) {
        this.tipoDiretor = tipoDiretor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("br.com.projetodescorp.model.Diretor[");
        sb.append(super.toString());
        sb.append(", ");
        sb.append(companhiaDeTeatro);
        sb.append(", ");
        sb.append(espetaculosDirigidos);  
        sb.append(tipoDiretor);
        sb.append("]");
        return sb.toString();
    }    

}
