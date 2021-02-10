package br.com.projetodescorp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.projetodescorp.model.Contrato;

/**
 *
 * @author guthemberg
 */
@Entity
@Table(name = "ESPETACULO")
public class Espetaculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String titulo;
    
    @Column(nullable = false)
    public String descricao;
    
    @Embedded
    public Endereco endereco;
    
    @Column(name = "em_cartaz")
    public Boolean emCartaz;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DIRETOR", referencedColumnName = "ID", nullable = false)
    protected Diretor diretor;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CONTRATO_ESPETACULO", joinColumns = {
        @JoinColumn(name = "espetaculo_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "contrato_id", referencedColumnName = "id", nullable = false)
            }
    )
    public List<Contrato> elenco;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_INICIO", nullable = false)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_FIM", nullable = false)
    private Date dataFim;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_TEATRO", referencedColumnName = "ID")
    private Teatro teatro;
    
    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getEmCartaz() {
        return emCartaz;
    }

    public void setEmCartaz(Boolean emCartaz) {
        this.emCartaz = emCartaz;
    }

    public List<Contrato> getElenco() {
        return elenco;
    }

    public boolean setElenco(Contrato contrato) {
        return this.elenco.add(contrato);
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public Teatro getTeatro() {
        return teatro;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }

}
