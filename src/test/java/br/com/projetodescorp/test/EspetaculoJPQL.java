/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Contrato;
import br.com.projetodescorp.model.Espetaculo;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author guthemberg
 */
public class EspetaculoJPQL extends GenericTest {
    
    @Test
    public void espetaculoPorCidade() {
        logger.info("Executando espetaculoPorCidade()");
        TypedQuery<Espetaculo> query = em.createQuery(
                "SELECT e FROM Espetaculo e WHERE e.teatro.endereco.cidade like :cidade",
                Espetaculo.class);
        query.setParameter("cidade", "Recife");

        List<Espetaculo> espetaculos = query.getResultList();

        assertEquals(4, espetaculos.size());

    }
    
    @Test
    public void espetaculoPorDiretor() {
        logger.info("Executando espetaculoPorDiretor()");
        TypedQuery<Espetaculo> query = em.createQuery(
                "SELECT e FROM Espetaculo e WHERE e.diretor.id = :idDiretor",
                Espetaculo.class);
        query.setParameter("idDiretor", 31);

        List<Espetaculo> espetaculos = query.getResultList();

        assertEquals(1, espetaculos.size());

    }
    
    @Test
    public void espetaculoDeDiretoresDistintos() {
        logger.info("Executando espetaculoDeDiretoresDistintos()");
        TypedQuery<String> query
                = em.createQuery("SELECT DISTINCT(e.diretor) FROM Espetaculo e ORDER BY e.diretor", String.class);
        List<String> diretores = query.getResultList();
        assertEquals(5, diretores.size());
    }
    
    
    @Test
    public void espetaculoQuantidadeElenco() {
        logger.info("Executando espetaculoQuantidadeElenco()");
        Query query = em.createQuery("SELECT e, COUNT(c) FROM Espetaculo e, Contrato c WHERE c MEMBER OF e.elenco GROUP BY e");
        List<Object[]> resultados = query.getResultList();
        assertEquals(2, resultados.size());
        assertEquals("O Beijo no Asfalto: 5 Atores", getContratoQuantidade(resultados.get(0)));
        assertEquals("Geni: 5 Atores", getContratoQuantidade(resultados.get(1)));
    }
    
    private String getContratoQuantidade(Object[] resultado) {
        Espetaculo esp = (Espetaculo) resultado[0];
        Long quantidade = (Long) resultado[1];
        return esp.getTitulo()+ ": " + quantidade + " Atores";
    }
    
}
