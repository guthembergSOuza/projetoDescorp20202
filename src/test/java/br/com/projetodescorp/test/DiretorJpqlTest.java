/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import static br.com.projetodescorp.test.GenericTest.logger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gersonbrandao
 */
public class DiretorJpqlTest extends GenericTest{
    
    
    @Test
    public void diretorPorNome(){
        logger.info("Executando diretorPorNome()");
        TypedQuery<Diretor> query = em.createQuery("SELECT d FROM Diretor d WHERE d.nome LIKE :nome", Diretor.class);
        query.setParameter("nome", "Jorge Vercillo");
        List<Diretor> diretores = query.getResultList();
        assertNotNull(diretores);
        assertEquals(2, diretores.size());
    }
    
//    @Test
//    public void diretorPorTipo(){
//        logger.info("Executando diretorPorTipo()");
//        TypedQuery<Diretor> query = em.createQuery("SELECT tipoDiretor FROM Diretor d WHERE d.tipoDiretor = :tipodiretor", Diretor.class);
//        query.setParameter("tipodiretor", 2);
//        List<Diretor> diretores = query.getResultList();
//        assertEquals(2, diretores.get(0).getTipoDiretor());
//    }
}