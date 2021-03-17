/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Endereco;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taoal
 */
public class AtorTest extends GenericTest {

    Endereco mEndereco = new Endereco();

    @Test
    public void criarAtor() {
        logger.info("Executando criarAtor()");
        Ator ator = new Ator();
        //Dados de usuário
        ator.setNome("Fulano da Silva Junior");
        ator.setEmail("FulanodaSilva@gmail.com");
        ator.setLogin("FulanodaSilva");
        ator.setSenha("Senha1234");
        //Dados de artor
        ator.setDrt("80825728410");
        ator.setDisponivel(Boolean.TRUE);
        ator.setEndereco(mEndereco.criarEndereco());

        em.persist(ator);
        em.flush();
    }

    @Test
    public void atualizarAtor() {
        logger.info("Executando atualizarAtor()");

        Ator ator = em.find(Ator.class, 5L);

        ator.setNome("Nome Ator Atualizado");
        ator.setEmail("emailAtualizado@gmail.com");

        em.flush();

        assertEquals("Nome Ator Atualizado", ator.getNome());
        assertEquals("emailAtualizado@gmail.com", ator.getEmail());
    }

    @Test
    public void atualizarAtorMerge() {
        logger.info("Executando atualizarAtorMerge()");

        Ator ator = em.find(Ator.class, 5L);

        ator.setNome("Nome Ator Atualizado Merge");
        ator.setEmail("emailAtualizadoMerge@gmail.com");
        
        em.clear();
        em.merge(ator);
        em.flush();

        ator = em.find(Ator.class, 5L);

        assertEquals("Nome Ator Atualizado Merge", ator.getNome());
        assertEquals("emailAtualizadoMerge@gmail.com", ator.getEmail());

    }

    @Test
    public void consultarAtor() {
        logger.info("Executando consultarAtor()");
        Ator ator = em.find(Ator.class, 5L);

        assertEquals("Nome Ator Atualizado", ator.getNome());

    }

    @Test
    public void deletarAtor() {
        logger.info("Executando deletarAtor()");
        Ator ator = em.find(Ator.class, 6L);

        assertNotNull(ator);

        em.remove(ator);
        em.flush();

        ator = em.find(Ator.class, 6L);

        assertEquals(null, ator);

    }

}
