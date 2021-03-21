/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.model;

import java.io.Serializable;
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
@Embeddable
public class Endereco implements Serializable {

    @NotNull
    @Min(1)
    @Max(99999)
    @Column(name = "numero")
    private Integer numero;
    @NotBlank
    @Size(max = 150)
    @Column(name = "rua")
    private String rua;
    @NotBlank
    @Size(max = 150)
    @Column(name = "bairro")
    private String bairro;
    @NotBlank
    @Size(max = 50)
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "uf")
    private String uf;
    @NotNull
    @Pattern(regexp = "[0-90]{2}.[0-9]{3}-[0-9]{3}", message = "{exemplo.jpa.Endereco.cep}")
    @Column(name = "cep")
    private String cep;
    @Size(max = 40)
    @Column(name = "complemento")
    private String complemento;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public Endereco criarEndereco() {

        Endereco endereco = new Endereco();
        endereco.setRua("Rua Iolanda Rodrigues Sobral");
        endereco.setBairro("Iputinga");
        endereco.setComplemento("A");
        endereco.setCidade("Recife");
        endereco.setUf("PE");
        endereco.setCep("50690-220");
        endereco.setNumero(550);

        return endereco;

    }

}
