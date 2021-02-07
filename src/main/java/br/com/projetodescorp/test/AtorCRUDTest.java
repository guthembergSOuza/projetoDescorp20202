/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Endereco;
import static br.com.projetodescorp.test.Test.preencherEndereco;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author thiagoaraujo
 */
public class AtorCRUDTest extends GenericTest {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetodescorp20201");
    private static EntityManager em;
    private static EntityTransaction et;

    public static void main(String[] args) throws IOException {
        persistirAtor();
        consultarAtor(1L);
    }

    @Test
    public static void persistirAtor() throws IOException {
        Ator ator = criarAtor();
        em = null;
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
        } //Persiste

        assertNotNull(ator.getId());
        //assertNotNull(ator.getCartaoCredito().getId());
    }

    @Test
    public static void consultarAtor(Long id) throws IOException {
        em = emf.createEntityManager();
        Ator ator = em.find(Ator.class, id);

        assertEquals("80825728410", ator.drt);
        assertEquals("fulano6@gmail.com", ator.email); //Esse teste falha

//        assertEquals(2, usuario.getTelefones().size());
//        assertTrue(usuario.getTelefones().contains("(81)99800-7846"));
//        assertTrue(usuario.getTelefones().contains("(81)3232-6899"));
//        Endereco endereco = usuario.getEndereco();
//        assertNotNull(endereco);
//        assertEquals("Iputinga", endereco.getBairro());
//        assertEquals("50670-210", endereco.getCep());
    }

    @Test
    private static Ator criarAtor() throws IOException {
        Ator ator = new Ator();
        //Dados de usuário
        ator.setNome("Fulano da Silva Junior");
        ator.setEmail("FulanodaSilva@gmail.com");
        ator.setLogin("FulanodaSilva");
        ator.setSenha("Senha1234");
        //Dados de artor
        ator.setDrt("80825728410");
        ator.setDisponivel(Boolean.TRUE);
        ator.setEndereco(criarEndereco());
        return ator;
    }

    @Test
    private static Endereco criarEndereco() throws IOException {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua Iolanda Rodrigues Sobral");
        endereco.setBairro("Iputinga");
        endereco.setCidade("Recife");
        endereco.setUf("Pernambuco");
        endereco.setCep("50690-220");
        endereco.setNumero(550);
        return endereco;
    }

}
