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
public class AtorTest extends GenericTest{
    
    @Test
    public void persistirAtor() {
        Ator ator = new Ator();
        //Dados de usuário
        ator.setNome("Fulano da Silva Junior3");
        ator.setEmail("FulanodaSilva@gmail.com");
        ator.setLogin("FulanodaSilva");
        ator.setSenha("Senha1234");
        //Dados de artor
        ator.setDrt("80825728410");
        ator.setDisponivel(Boolean.TRUE);
        ator.setEndereco(criarEndereco());

        em.persist(ator);
        em.flush();

        //assertNotNull(ator.getId());

    }

    private Endereco criarEndereco() {
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
 
    @org.junit.Test
    public void consultarAtor() {
        Ator ator = em.find(Ator.class, 1L);
        
        //procurar Teatro de Santa Isabel - bairro = Santo Antônio
        //assertEquals("victor Lins", ator.getNome());
        //assertEquals("v.lins@gmail.com", ator.getEmail());
       
    }
    
}
