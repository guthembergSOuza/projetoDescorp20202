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

//    @Test
//    public void persistirContrato() {
//        Contrato contrato = new Contrato();
//
//        Ator ator = em.find(Ator.class, 1L);
//        assertNotNull(ator);
//
//        contrato.setAtor(ator);
//        contrato.setCache("2000");
//
//        em.persist(contrato);
//        em.flush();
//
//        assertNotNull(contrato.getId());
//
//    }
//
//    @Test
//    public void consultarContrato() {
//        Contrato contrato1 = em.find(Contrato.class, 11L);
//        contrato1 = em.find(Contrato.class, 3L);
//
//        assertEquals("Lucas Marques", contrato1.getAtor().getNome());
//    }
//
//    @Test
//    public void atualizarContrato() {
//        logger.info("Executando atualizarContrato()");
//
//        Contrato contrato = em.find(Contrato.class, 5L);        
//        
//        contrato.setCache("5000");
//        
//        em.flush();
//        em.clear();
//
//        contrato = em.find(Contrato.class, 5L);
//        
//        assertEquals("5000", contrato.getCache());       
//        
//    }
//
//    @Test
//    public void atualizarContratoMerge() {
//        logger.info("Executando atualizarContratoMerge()");
//
//        Contrato contrato = em.find(Contrato.class, 4L);
//
//        contrato.setCache("10000");        
//
//        em.clear();
//        em.merge(contrato);
//        em.flush();
//
//        contrato = em.find(Contrato.class, 4L);
//
//        assertEquals("10000", contrato.getCache());        
//
//    }
//
//    @Test
//    public void deletarContrato() {
////        logger.info("Executando deletarContrato()");
////        Contrato contrato = em.find(Contrato.class, 11L);
////
////        assertNotNull(contrato);
////
////        em.remove(contrato);
////        em.flush();
////
////        contrato = em.find(Contrato.class, 11L);
////
////        assertEquals(null, contrato);
//
//    }

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

        assertEquals("Lucas Marques".toUpperCase(), contrato1.getAtor().getNome().toUpperCase());
    }
    
}
