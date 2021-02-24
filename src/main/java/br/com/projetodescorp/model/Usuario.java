package br.com.projetodescorp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author guthemberg
 */
@MappedSuperclass
public class Usuario implements Serializable{
    
    @Column(name = "nome")
    public String nome;
    @Column(name = "email", unique = true)
    public String email;
    @Column(name = "login", unique = true)
    public String login;
    @Column(name = "senha")
    public String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
