package br.com.projetodescorp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author guthemberg
 */
@Entity
@Table(name="TEATRO")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Teatro.PorCidade",
                    query = "SELECT t FROM Teatro t WHERE t.endereco.cidade LIKE :cidade"
            ),
            @NamedQuery(
                    name = "Teatro.PorId",
                    query = "SELECT t FROM Teatro t WHERE t.id = :id"
            )
        }
)
public class Teatro implements Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nome")
    private String nome;
    @Column(name="quantidade_lugares")
    private int quantidadeLugares;
    @Embedded
    private Endereco endereco;
    
    @OneToMany(mappedBy = "teatro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Espetaculo> espetaculos;

    public List<Espetaculo> getEspetaculos() {
        return espetaculos;
    }

    public void setEspetaculos(List<Espetaculo> espetaculos) {
        this.espetaculos = espetaculos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setQuantidadeLugares(int quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Teatro other = (Teatro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
