package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import br.com.projetodescorp.model.TipoDiretor;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class DiretorValidationTest extends GenericTest {
    
    /*
    @Test(expected = ConstraintViolationException.class)
    public void PersistirDiretorInvalido(){
        Diretor diretor = new Diretor();
        try {
            diretor.setCompanhiaDeTeatro("Risadaria");
            diretor.setEmail("alex.siqueira@gmail.com");
            diretor.setLogin("alex.siqueira");
            diretor.setNome("Alex Siqueira");
            diretor.setSenha("@123456@");
            diretor.setTipoDiretor(TipoDiretor.MUSICAL);
            em.persist(diretor);
            em.flush();
                    
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class br.com.projetodescorp.model.Diretor.companhiaDeTeatro = Companhia de Teatro Inválida.")
                        )
                );
            });

            assertEquals(1, constraintViolations.size());
            //assertNull(diretor.getId());
            throw ex;
            
        }
    }
    */
}
