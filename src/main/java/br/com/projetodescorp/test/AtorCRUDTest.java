/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Endereco;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author thiagoaraujo
 */
public class AtorCRUDTest extends GenericTest {

    @Test
    public void persistirAtor() {
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

        em.persist(ator);
        em.flush();

        assertNotNull(ator.getId());

    }

    @Test
    public static void consultarAtor(Long id) {

    }

    private Endereco criarEndereco() {
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
