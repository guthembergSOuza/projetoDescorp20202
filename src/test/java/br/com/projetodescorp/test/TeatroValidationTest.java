package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Endereco;
import br.com.projetodescorp.model.Teatro;
import java.util.Set;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author guthemberg
 */
public class TeatroValidationTest extends GenericTest {
    
    
    
    @Test(expected = ConstraintViolationException.class)
    public void persistirTeatro() {
        
        Teatro teatro = null;
        
        try{
            teatro = new Teatro();
            teatro = criarTeatro("Teat",1,457,"R. da Aurora","Boa Vista","Recife","PE","52121021","na avenida");
            em.persist(teatro);
            em.flush();

        } catch(ConstraintViolationException ex){
            
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

            constraintViolations.forEach(violation -> {
                assertThat(violation.getRootBeanClass() + "." + violation.getPropertyPath() + ": " + violation.getMessage(),
                        CoreMatchers.anyOf(
                            startsWith("class br.com.projetodescorp.model.Teatro.quantidadeLugares: deve ser maior que ou igual à 20"),
                            startsWith("class br.com.projetodescorp.model.Teatro.nome: Deve possuir pelomenos 5 caracteres.")
                        )
                );
            });

            assertEquals(2, constraintViolations.size());
            //assertNull(teatro.getId());
            throw ex;
            
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizarTeatroInvalido (){
        
        TypedQuery<Teatro> query = em.createQuery("SELECT t FROM Teatro t WHERE t.id = :id", Teatro.class);
        query.setParameter("id", 32);
        Teatro teatroUpdate = query.getSingleResult();
        
        teatroUpdate.setNome("nome");
        
        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            ConstraintViolation violation = ex.getConstraintViolations().iterator().next();
            assertEquals("Deve possuir pelomenos 5 caracteres.", violation.getMessage());
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
        
        
            
    }
    
     private Teatro criarTeatro(String nome, int quantidadeLugares, 
            Integer numero,
            String rua,
            String bairro,
            String cidade,
            String uf,
            String cep,
            String complemento  ) {
        
        Teatro novoTeatro = new Teatro();
        novoTeatro.setNome(nome);
        novoTeatro.setQuantidadeLugares(quantidadeLugares);
        novoTeatro.setEndereco(criarEndereco(numero,rua,bairro,cidade,uf,cep,complemento));
        
        return novoTeatro;
    }
     
    private Endereco criarEndereco( Integer numero,
            String rua,
            String bairro,
            String cidade,
            String uf,
            String cep,
            String complemento  ) {
        
        Endereco endereco = new Endereco();
        endereco.setNumero(numero);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setUf(uf);
        endereco.setCep(cep);
        endereco.setComplemento(complemento);
        
        return endereco;
    }
    
}
