package br.com.projetodescorp.model.usuario;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author guthemberg
 */
@MappedSuperclass
public class Usuario implements Serializable{
    
    public String nome;
    public String email;
    public String login;
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
