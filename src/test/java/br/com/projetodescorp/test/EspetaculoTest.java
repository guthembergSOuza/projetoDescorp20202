/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import br.com.projetodescorp.model.Espetaculo;
import br.com.projetodescorp.model.Teatro;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author guthemberg
 */
public class EspetaculoTest extends GenericTest{
    
    
    @Test
    public void persistirEspetaculo() {
        Espetaculo espetaculo = new Espetaculo();
        
        espetaculo.setTitulo("A volta dos que não foram");
        espetaculo.setDescricao("Peça baseada na vida de quem ainda está presente em lembranças");
        espetaculo.setDataInicio(getData(25, 4, 2021));
        espetaculo.setDataFim(getData(27, 4, 2021));
        espetaculo.setDiretor(em.createNamedQuery("Diretor.PorId", Diretor.class).setParameter("id", 1).getResultList().get(0));
        espetaculo.setEmCartaz(Boolean.TRUE);
        espetaculo.setTeatro(em.createNamedQuery("Teatro.PorId", Teatro.class).setParameter("id", 1).getResultList().get(0));
        
        em.persist(espetaculo);
        em.flush();

        assertNotNull(espetaculo.getId());

    }
    
    
    @Test
    public void consultarEspetaculos() {
        
        Espetaculo esp = em.find(Espetaculo.class, 1L);
        
        assertEquals("O Beijo no Asfalto", esp.getTitulo());
       
    }
    
    
}
