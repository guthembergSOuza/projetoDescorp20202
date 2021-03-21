/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Ator;
import br.com.projetodescorp.model.Endereco;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author taoal
 */
public class AtorValidationTest extends GenericTest {

    Endereco mEndereco = new Endereco();

    @Test(expected = ConstraintViolationException.class)
    public void persistirAtorInvalido() {

        Ator ator = new Ator();

        try {
            //Dados de usuário
            ator.setNome("Teste Validation");
            ator.setEmail("FulanodaSilva@gmail.com");
            ator.setLogin("FulanodaSilva");
            ator.setSenha("Senha1234");
            //Dados de artor
            ator.setDrt("");
            ator.setDisponivel(Boolean.TRUE);
            ator.setEndereco(mEndereco.criarEndereco());

            em.persist(ator);
            em.flush();

            ator = em.find(Ator.class, 7L);
            assertEquals("Teste Validation", ator.getNome());

        } catch (ConstraintViolationException ex) {

            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class br.com.projetodescorp.model.Ator.drt: Drt inválido, o tamanho deve ser 6")
                        )
                );
            });

            assertEquals(1, constraintViolations.size());

            throw ex;

        }
    }
}
