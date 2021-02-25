package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Contrato;
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

    @org.junit.Test
    public void consultarContrato() {
        Contrato contrato1 = em.find(Contrato.class, 11L);

        //procurar Teatro de Santa Isabel - bairro = Santo Antônio
        //assertEquals("Victor Lins", contrato1.getAtor().getNome());
        contrato1 = em.find(Contrato.class, 3L);

        assertEquals("Lucas Marques", contrato1.getAtor().getNome());
    }
    
}
