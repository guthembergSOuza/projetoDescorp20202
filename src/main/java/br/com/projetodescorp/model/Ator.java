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
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author guthemberg
 */
@Entity
@Table(name = "ATOR")
@DiscriminatorValue(value = "A")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@NamedQueries(
        {
            @NamedQuery(
                    name = "Ator.PorEstado",
                    query = "SELECT a FROM Ator a WHERE a.endereco.uf LIKE :estado"
            )
        }
)
public class Ator extends Usuario implements Serializable {

    @Column(name = "drt", nullable = false, unique = true)
    @Size(min = 6)
    @NotBlank
    private String drt;

    @Column(name = "disponivel", nullable = false)
    private Boolean disponivel;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "ator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contrato> contrato;

    public String getDrt() {
        return drt;
    }

    public void setDrt(String drt) {
        this.drt = drt;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Ator{" + "drt=" + drt + ", disponivel=" + disponivel + ", endereco=" + endereco + ", contrato=" + contrato + '}';
    }

}
