/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Endereco;
import br.com.projetodescorp.model.Usuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author guthemberg
 */
public class Test {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("projetodescorp20201");

    public static void main(String[] args) throws IOException {
        persistirUsuario();
        consultarUsuario(1L);
    }

    private static void persistirUsuario() throws IOException {
        Ator ator = new Ator();
        preencherUsuario(ator);
        EntityManager em = null;
        EntityTransaction et;
        try {
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();
            em.persist(ator);
            et.commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    private static void preencherUsuario(Ator ator) throws IOException {
        //Dados de usuário
        ator.setNome("Fulano da Silva");
        ator.setEmail("FulanodaSilva@gmail.com");
        ator.setLogin("FulanodaSilva");
        ator.setSenha("Senha1234");        
        //Dados de artor
        ator.setDrt("65456488864");
        ator.setDisponivel(Boolean.TRUE);
        ator.setEndereco(preencherEndereco());
    }

    public static Endereco preencherEndereco() {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua Iolanda Rodrigues Sobral");
        endereco.setBairro("Varzea");
        endereco.setCidade("Recife");
        endereco.setUf("Pernambuco");
        endereco.setCep("50690-220");
        endereco.setNumero(550);        
        return endereco;
    }

    private static void consultarUsuario(long l) {
        EntityManager em = emf.createEntityManager();
        Ator ator = em.find(Ator.class, l);
        System.out.println(ator.getNome());
        //usuario.getTelefones().iterator() vai provocar uma consulta à tabela TB_TELEFONE.
        System.out.println(ator.getEndereco());
        //usuario.getFoto().length vai as informações de TB_USUARIO, incluindo IMG_FOTO.
        System.out.println(ator.getDisponivel());
        em.close();
    }

}
