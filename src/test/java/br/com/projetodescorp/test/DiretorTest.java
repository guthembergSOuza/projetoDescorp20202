package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import br.com.projetodescorp.model.TipoDiretor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author guthemberg
 */
public class DiretorTest extends GenericTest {
    
    @Test
    public void persistirDiretor() {
        Diretor diretor = new Diretor();
        diretor.setNome("Lucas Sobral");
        diretor.setCompanhiaDeTeatro("Escola de Teatro de Camaragibe");
        diretor.setEmail("lucas.sobral@gmail.com");
        diretor.setSenha("123456");
        diretor.setLogin("lucas.sobral");
        diretor.setTipoDiretor(TipoDiretor.MUSICAL);
        em.persist(diretor);
        em.flush();

        assertNotNull(diretor.getId());

    }
    
    @org.junit.Test
    public void consultarDiretor() {
        Diretor diretor = em.find(Diretor.class, 31L);
        
        //procurar Teatro de Santa Isabel - bairro = Santo Antônio
        assertEquals("Thiago Antonio", diretor.getNome());
        assertEquals("thiago.a@gmail.com", diretor.getEmail());
       
    }
}
