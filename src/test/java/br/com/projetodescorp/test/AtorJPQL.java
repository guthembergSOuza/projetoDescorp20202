/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Contrato;
import java.util.List;
import org.junit.Test;
import javax.persistence.TypedQuery;
import static org.junit.Assert.*;

/**
 *
 * @author taoal
 */
public class AtorJPQL extends GenericTest {

    @Test
    public void atorPorDRT() {
        logger.info("Executando atorPorDRT()");
        TypedQuery<Ator> query = em.createQuery(
                "SELECT ator FROM Ator ator WHERE ator.drt LIKE :drt",
                Ator.class);
        query.setParameter("drt", "20200102");

        List<Ator> atores = query.getResultList();

        assertEquals(1, atores.size());

    }

    @Test
    public void atorPorNome() {
        logger.info("Executando atorPorNome()");
        TypedQuery<Ator> query = em.createQuery(
                "SELECT ator FROM Ator ator WHERE ator.nome LIKE :nome", Ator.class);
        query.setParameter("nome", "Victor Lins");

        List<Ator> atores = query.getResultList();

        assertEquals(1, atores.size());

    }

    @Test
    public void atorPorUF() {
        logger.info("Executando atorPorUF()");
        TypedQuery<Ator> query = em.createQuery(
                "SELECT ator FROM Ator ator WHERE ator.endereco.uf LIKE :uf", Ator.class);
        query.setParameter("uf", "PE");

        List<Ator> atores = query.getResultList();

        assertEquals(5, atores.size());

    }
    
    @Test
    public void atorPorUFNamedQuery() {
        logger.info("Executando atorPorUFNamedQuery()");
        TypedQuery<Ator> query = em.createNamedQuery("Ator.PorEstado", Ator.class);
        query.setParameter("estado", "PE");

        List<Ator> atores = query.getResultList();

        assertEquals(5, atores.size());

    }

    @Test
    public void atorContratos() {
        logger.info("Executando atorContratos()");
        TypedQuery<Contrato> query = em.createQuery(
                "SELECT contrato FROM Contrato contrato WHERE contrato.ator.id = :id", Contrato.class);
        query.setParameter("id", 1);

        List<Contrato> contratos = query.getResultList();

        assertNotNull(contratos);

    }

//    @Test
//    public void atorEspetaculos() {
//        logger.info("Executando atorEspetaculos()");
//        TypedQuery<Espetaculo> query = em.createQuery(
//                "Select  es.id, es.DESCRICAO \n" +
//                "    from espetaculo es, CONTRATO_ESPETACULO ce, contrato co \n" +
//                "        where es.ID = ce.ESPETACULO_ID\n" +
//                "        and co.ID = ce.CONTRATO_ID\n" +
//                "        and co.ID_ATOR = :id_ator;", Espetaculo.class);
//        query.setParameter("id_ator", 1);
//
//        List<Espetaculo> espetaculos = query.getResultList();
//
//        assertNotNull(espetaculos);
//
//    }

}
