/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import br.com.projetodescorp.model.Espetaculo;
import br.com.projetodescorp.model.Teatro;
import java.util.Calendar;
import java.util.Date;
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
        espetaculo.setDataInicio(this.getData(25, 4, 2021));
        espetaculo.setDataFim(this.getData(27, 4, 2021));
        espetaculo.setDiretor(em.createNamedQuery("Diretor.PorId", Diretor.class).setParameter("id", 1).getResultList().get(0));
        espetaculo.setEmCartaz(Boolean.TRUE);
        espetaculo.setTeatro(em.createNamedQuery("Teatro.PorId", Teatro.class).setParameter("id", 1).getResultList().get(0));
        
        em.persist(espetaculo);
        em.flush();

        assertNotNull(espetaculo.getId());

    }
    
    public Date getData(Integer dia, Integer mes, Integer ano) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, ano);
        c.set(Calendar.MONTH, mes);
        c.set(Calendar.DAY_OF_MONTH, dia);
        return c.getTime();
    }
    
    @Test
    public void consultarEspetaculos() {
        
        Espetaculo esp = em.find(Espetaculo.class, 1L);
        
        assertEquals("O Beijo no Asfalto", esp.getTitulo());
       
    }
    
    
}
