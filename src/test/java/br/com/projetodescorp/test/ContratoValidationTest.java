
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Contrato;
import java.util.Set;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author guthemberg
 */
public class ContratoValidationTest extends GenericTest {
    
    @Test(expected = ConstraintViolationException.class)
    public void persistirContratoInvalido() {
        
        Contrato contrato = null;
        
        try{
            contrato = new Contrato();

            contrato.setAtor(null);
            contrato.setCache(10.00);        

            em.persist(contrato);
            em.flush();

        } catch(ConstraintViolationException ex){
            
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                            startsWith("class br.com.projetodescorp.model.Contrato.cache: deve ser maior que ou igual à 100")
                            ,startsWith("class br.com.projetodescorp.model.Contrato.ator: não deve ser nulo")
                        )
                );
            });

            assertEquals(2, constraintViolations.size());
            throw ex;
            
        }
        
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizarContratoInvalido (){

        TypedQuery<Contrato> query = em.createQuery("SELECT c FROM Contrato c WHERE c.id = :id", Contrato.class);
        query.setParameter("id", 32);
        Contrato contratoUpdate = query.getSingleResult();

        contratoUpdate.setCache(10.00);

        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            ConstraintViolation violation = ex.getConstraintViolations().iterator().next();
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }



    }
    
    
}
