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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author guthemberg
 */
@Entity
@Table(name = "ATOR")
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
public class Ator extends Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "drt", nullable = false, unique = true)
    public String drt;
    @Column(name = "disponivel", nullable = false)
    public Boolean disponivel;
    @Embedded
    public Endereco endereco;
    @OneToMany(mappedBy = "ator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Contrato> contrato;

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

}
