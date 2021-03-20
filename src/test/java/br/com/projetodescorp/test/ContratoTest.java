package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Contrato;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

        Ator ator = em.find(Ator.class, 31L);
        assertNotNull(ator);

        contrato.setAtor(ator);
        contrato.setCache("1500");        

        em.persist(contrato);
        em.flush();

        assertNotNull(contrato.getId());

    }

    @Test
    public void consultarContrato() {
        Contrato contrato1 = em.find(Contrato.class, 33L);
        contrato1 = em.find(Contrato.class, 33L);

        assertEquals("Lucas Marques", contrato1.getAtor().getNome());
    }
    
}
