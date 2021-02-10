/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Contrato;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gersonbrandao
 */
public class ContratoTest extends GenericTest {

    @Test
    public void persistirContrato() {
        Contrato contrato = new Contrato();

        Ator ator = em.find(Ator.class, 1L);
        assertNotNull(ator);

        contrato.setAtor(ator);
        contrato.setCache("2000");

        em.persist(contrato);
        em.flush();

        assertNotNull(contrato.getId());

    }

}
