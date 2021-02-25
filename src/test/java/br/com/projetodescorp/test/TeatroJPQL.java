package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Teatro;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author guthemberg
 */
public class TeatroJPQL extends GenericTest {
    
    
    @Test
    public void teatroPorCidade() {
        logger.info("Executando TeatroPorCidade()");
        TypedQuery<Teatro> query = em.createQuery(
                "SELECT teatro FROM Teatro teatro WHERE teatro.endereco.cidade LIKE :cidade",
                Teatro.class);
        query.setParameter("cidade", "Recife");

        List<Teatro> teatros = query.getResultList();

        assertEquals(4, teatros.size());
    }
    
    @Test
    public void teatroPorCidadeNamedQuery() {
        logger.info("Executando TeatroPorCidade()");
        TypedQuery<Teatro> query = em.createNamedQuery("Teatro.PorCidade",Teatro.class);
        query.setParameter("cidade", "Recife");

        List<Teatro> teatros = query.getResultList();

        assertEquals(4, teatros.size());
    }
    
    @Test
    public void teatroPorEspetaculo(){
        logger.info("Executando teatroPorEspetaculo()");
        TypedQuery<Teatro> query = em.createQuery(
                "SELECT teatro FROM Teatro teatro WHERE teatro.id in (select espetaculo.teatro.id from Espetaculo espetaculo) and  teatro.id = :idTeatro",
                Teatro.class);
        query.setParameter("idTeatro", 1);

        List<Teatro> teatros = query.getResultList();
        assertEquals(1, teatros.size());

    }
    
    @Test
    public void teatroPorDataEspetaculo(){
        logger.info("Executando teatroPorDataEspetaculo()");
        TypedQuery<Teatro> query = em.createQuery(
                "SELECT teatro FROM Teatro teatro WHERE teatro.id in (select espetaculo.teatro.id from Espetaculo espetaculo where espetaculo.dataInicio < :dataEspetaculo and espetaculo.dataFim > :dataEspetaculo)",
                Teatro.class);
        query.setParameter("dataEspetaculo",this.getData(10, 1, 2020) );
        List<Teatro> teatros = query.getResultList();
        assertEquals(3, teatros.size());

    }
    
    protected Date getData(Integer dia, Integer mes, Integer ano) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, ano);
        c.set(Calendar.MONTH, mes);
        c.set(Calendar.DAY_OF_MONTH, dia);
        return c.getTime();
    }
}
