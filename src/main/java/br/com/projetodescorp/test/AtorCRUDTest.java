/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Endereco;
import org.junit.Test;

/**
 *
 * @author thiagoaraujo
 */
public class AtorCRUDTest extends GenericTest {

    @Test
    public void criarArtesao() {
        logger.info("Executando CriarArtesao()");

        Ator ator = new Ator();

        String nome = "Thiago";
        Endereco endereco = new Endereco(100, "Rua x", "Bairro x", "Cidade x", "PE", "54730080", "Complemento X");
        boolean disponivel = true;

        ator.setDisponivel(disponivel);
        ator.setDrt("drtx");
        ator.setEmail("taoalu@gmail.com");
        ator.setEndereco(endereco);
        ator.setLogin("taoalu");
        ator.setSenha("1234");
        ator.setNome("Usuario X");

        em.persist(ator);
        em.flush();

    }

    @Test
    public void buscarArtesao() {

    }

}
