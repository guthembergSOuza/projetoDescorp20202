/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Espetaculo;
import java.util.List;
import javax.persistence.TypedQuery;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author guthemberg
 */
public class EspetaculoJPQL extends GenericTest {
    
    @Test
    public void espetaculoPorCidade() {
        logger.info("Executando espetaculoPorCidade()");
        TypedQuery<Espetaculo> query = em.createQuery(
                "SELECT e FROM Espetaculo e WHERE e.teatro.endereco.cidade like :cidade",
                Espetaculo.class);
        query.setParameter("cidade", "Recife");

        List<Espetaculo> espetaculos = query.getResultList();

        assertEquals(4, espetaculos.size());

    }
    
    @Test
    public void espetaculoPorDiretor() {
        logger.info("Executando espetaculoPorDiretor()");
        TypedQuery<Espetaculo> query = em.createQuery(
                "SELECT e FROM Espetaculo e WHERE e.diretor.id = :idDiretor",
                Espetaculo.class);
        query.setParameter("idDiretor", 1);

        List<Espetaculo> espetaculos = query.getResultList();

        assertEquals(1, espetaculos.size());

    }
    
}
