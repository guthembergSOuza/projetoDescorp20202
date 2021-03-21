package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import br.com.projetodescorp.model.TipoDiretor;
import java.util.Set;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolationException;

import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;


public class DiretorValidationTest extends GenericTest {
    
   
    @Test(expected = ConstraintViolationException.class)
    public void PersistirDiretorInvalido(){
            Diretor diretor = null;
            String companhiaInvalida = "Renascer";
            String companhiaValida = "Risadaria";
            
        try {
            diretor = new Diretor();
            diretor.setNome("lucimar");
            diretor.setCompanhiaDeTeatro(companhiaInvalida); //
            diretor.setEmail("lucimar.junior@gmail.com");
            diretor.setSenha("112"); //
            diretor.setLogin("lucimar.junior");
            diretor.setTipoDiretor(TipoDiretor.MUSICAL);
            em.persist(diretor);
            em.flush();
            
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class br.com.projetodescorp.model.Diretor.companhiaDeTeatro: Companhia de Teatro Inválida.")
                                //startsWith("class br.com.projetodescorp.model.Usuario.nome : Deve possuir uma única letra maiúscula, seguida por letras minúsculas.")
                                //startsWith("class br.com.projetodescorp.model.Usuario.senha: A senha deve possuir pelo menos um caractere de: pontuação, maiúscula, minúscula e número.")
                        )
                );
            });
            
            assertEquals(1, constraintViolations.size());
            assertNull(diretor.getId());
            throw ex;
            
        }
    }
    
//    @Test(expected = ConstraintViolationException.class)
//    public void atualizarDiretorInvalido() {
//        String senhaInvalida = "ola";
//        String senhaValida = "@MVmv2021";
//        String nomeInvalido = "mario";
//        String nomeValido = "Mario";
//        
//        TypedQuery<Diretor> query = em.createQuery("SELECT d FROM Diretor d WHERE d.id = ?1", Diretor.class);
//        query.setParameter(1, 44);
//        Diretor diretor = query.getSingleResult();
//        System.out.println("br.com.projetodescorp.test.DiretorValidationTest.atualizarDiretorInvalido " + diretor.getNome());
//        //diretor.setSenha(senhaInvalida);
//        diretor.setNome(nomeValido);
//
//        try {
//            em.flush();
//        } catch (ConstraintViolationException ex) {    
//            ConstraintViolation violation = ex.getConstraintViolations().iterator().next();
//            assertEquals("Deve possuir uma única letra maiúscula, seguida por letras minúsculas.", violation.getMessage());
//            assertEquals(1, ex.getConstraintViolations().size());
//            throw ex;
//        }
//    }
    
}
