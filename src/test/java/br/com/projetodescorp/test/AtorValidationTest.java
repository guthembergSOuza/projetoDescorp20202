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

    @Test(expected = ConstraintViolationException.class)
    public void persistirAtorInvalido() {
        Ator ator = null;
        Endereco endereco = new Endereco();

        endereco.setBairro("Bairo X");
        endereco.setCep("00585-889"); //Inválido
        endereco.setCidade("Cidade X");
        endereco.setComplemento("");
        endereco.setNumero(0);//Inválido
        endereco.setRua("Rua X");
        endereco.setUf("XX");

        try {
            ator = new Ator();

            ator.setNome("Fulaninho");
            ator.setDisponivel(Boolean.TRUE);
            ator.setDrt("0");//Inválido
            ator.setEmail("@email");//Inválido
            ator.setEndereco(endereco);
            ator.setLogin("login");
            ator.setSenha("1234"); //

            em.persist(ator);
            em.flush();

        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class br.com.projetodescorp.model.Ator.endereco.cep: CEP inválido. Deve estar no formado NN.NNN-NNN, onde N é número natural"),
                                startsWith("class br.com.projetodescorp.model.Ator.endereco.numero: Número inválido"),
                                startsWith("class br.com.projetodescorp.model.Ator.endereco.uf: Estado inválido"),
                                startsWith("class br.com.projetodescorp.model.Ator.drt: Drt inválido, o tamanho deve ser 6"),
                                startsWith("class br.com.projetodescorp.model.Ator.email: deve ser um endereço de e-mail bem formado")
                        )
                );
            });

            assertEquals(5, constraintViolations.size());
            assertNull(ator.getId());
            throw e;

        }
    }
}
