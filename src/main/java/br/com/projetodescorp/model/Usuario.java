package br.com.projetodescorp.model;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author guthemberg
 */
@Inheritance(strategy = InheritanceType.JOINED) //Estratégia de herança.
@DiscriminatorColumn(name = "TIPO_USUARIO", //Nome da coluna que vai discriminar subclasses.
        discriminatorType = DiscriminatorType.STRING, length = 1)
@Access(AccessType.FIELD)
public class Usuario implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "nome", nullable = false)
    protected String nome;
    @Column(name = "email", nullable = false)
    protected String email;
    @Column(name = "login", nullable = false)
    protected String login;
    @Column(name = "senha", nullable = false)
    protected String senha;

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
