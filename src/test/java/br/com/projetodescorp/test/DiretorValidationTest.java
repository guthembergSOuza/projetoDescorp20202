/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;
import br.com.projetodescorp.model.Diretor;
import br.com.projetodescorp.model.TipoDiretor;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class DiretorValidationTest {
    @Test(expected = ConstraintViolationException.class)
    public void PersistirDiretorInvalido(){
        Diretor diretor = null;
        try {
//            diretor = new Diretor();
//            diretor.setCompanhiaDeTeatro(companhiaDeTeatro);
//            diretor.setEmail(email);
//            diretor.setEsptetaculosDirigidos(esptetaculosDirigidos);
//            diretor.setLogin(login);
//            diretor.setNome(nome);
//            diretor.setSenha(senha);
//            diretor.setTipoDiretor(TipoDiretor.MUSICAL);
            
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                                startsWith("class br.con.projetodescorp.model.Diretor.tipoDiretor: Tipo inválido. Os diretores podem ter os seguintes tipos: 1 - GERAL, 2 - MUSICAL, 3 - PRODUCAO e 4 - ILUMINACAO.")
                        )
                );
            });

            assertEquals(1, constraintViolations.size());
            assertNull(diretor.getId());
            throw ex;
            
        }
    }
    
}
