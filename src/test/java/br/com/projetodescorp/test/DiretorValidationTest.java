package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import br.com.projetodescorp.model.TipoDiretor;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolationException;

import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class DiretorValidationTest extends GenericTest {
    
   /* 
    @Test(expected = ConstraintViolationException.class)
    public void PersistirDiretorInvalido(){
       
        try {
            Diretor diretor = new Diretor();
            diretor.setNome("Lucimar Junior");
            diretor.setCompanhiaDeTeatro("Escola de Teatro de Camaragibe");
            diretor.setEmail("lucimar.junior@gmail.com");
            diretor.setSenha("11223344");
            diretor.setLogin("lucimar.junior");
            diretor.setTipoDiretor(TipoDiretor.MUSICAL);
            em.persist(diretor);
            em.flush();
            
            assertNotNull(diretor.getId());

                    
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class br.com.projetodescorp.model.Diretor.companhiaDeTeatro: Companhia de Teatro Inválida."),
                                startsWith("class br.com.projetodescorp.modelDiretor.email: deve ser um endereço de e-mail bem formado")

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
