/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Endereco;
import br.com.projetodescorp.model.Teatro;
import br.com.projetodescorp.test.DbUnitUtil;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.dbunit.DatabaseUnitException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author guthemberg
 */
public class TeatroTest extends GenericTest {
    
    @org.junit.Test
    public void persistirTeatro() {
        Teatro teatro;
        teatro = criarTeatro("Teatro Arraial Ariano Suassuna",94,457,"R. da Aurora","Boa Vista","Recife","PE","50050000","na avenida");
        em.persist(teatro);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(teatro.getId());
    }
    
    private Teatro criarTeatro(String nome, int quantidadeLugares, 
            Integer numero,
            String rua,
            String bairro,
            String cidade,
            String uf,
            String cep,
            String complemento  ) {
        
        Teatro novoTeatro = new Teatro();
        novoTeatro.setNome(nome);
        novoTeatro.setQuantidadeLugares(quantidadeLugares);
        novoTeatro.setEndereco(criarEndereco(numero,rua,bairro,cidade,uf,cep,complemento));
        
        return novoTeatro;
    }
    
    private Endereco criarEndereco( Integer numero,
            String rua,
            String bairro,
            String cidade,
            String uf,
            String cep,
            String complemento  ) {
        
        Endereco endereco = new Endereco();
        endereco.setNumero(numero);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setUf(uf);
        endereco.setCep(cep);
        endereco.setComplemento(complemento);
        
        return endereco;
    }
    
    @org.junit.Test
    public void consultarTeatro() {
        Teatro teatro = em.find(Teatro.class, 1L);
        
        //procurar Teatro de Santa Isabel - bairro = Santo Antônio
        assertEquals("Teatro de Santa Isabel", teatro.getNome());
        assertEquals("Santo Antônio", teatro.getEndereco().getBairro());
       
    }
}
