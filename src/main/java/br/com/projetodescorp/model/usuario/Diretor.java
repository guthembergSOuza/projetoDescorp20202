package br.com.projetodescorp.model.usuario;

import br.com.projetodescorp.model.espetaculo.Espetaculo;
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
   /* @OneToMany(mappedBy = "diretor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Espetaculo> esptetaculosDirigidos;*/

    public TipoDiretor tipodiretor;
    
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

    /*public List<Espetaculo> getEsptetaculosDirigidos() {
        return esptetaculosDirigidos;
    }

    public void setEsptetaculosDirigidos(List<Espetaculo> esptetaculosDirigidos) {
        this.esptetaculosDirigidos = esptetaculosDirigidos;
    }*/

    public TipoDiretor getTipoDiretor() {
        return tipodiretor;
    }

    public void setTipoDiretor(TipoDiretor tipodiretor) {
        this.tipodiretor = tipodiretor;
    }
    
}
