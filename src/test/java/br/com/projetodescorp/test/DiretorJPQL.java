/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.test;

import br.com.projetodescorp.model.Diretor;
import static br.com.projetodescorp.test.GenericTest.logger;
import java.util.List;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gersonbrandao
 */
public class DiretorJPQL extends GenericTest{
//    
//    
//    @Test
//    public void diretorPorNome(){
//        logger.info("Executando diretorPorNome()");
//        TypedQuery<Diretor> query = em.createQuery("SELECT d FROM Diretor d WHERE d.nome LIKE :nome", Diretor.class);
//        query.setParameter("nome", "Jorge Vercillo");
//        List<Diretor> diretores = query.getResultList();
//        assertNotNull(diretores);
//        assertEquals(2, diretores.size());
//    }
//    
//    @Test
//    public void diretorCompanhiaTeatro(){
//        logger.info("Executando diretorCompanhiaTeatro()");
//        TypedQuery<Diretor> query = em.createQuery("SELECT d FROM Diretor d WHERE d.companhiaDeTeatro LIKE ?1", Diretor.class);
//        query.setParameter(1, "Teatro em Foco");
//        List<Diretor> diretores = query.getResultList();
//        assertNotNull(diretores);
//        assertEquals(2, diretores.size());
//    }
//    
//
//     @Test
//    public void diretorPorLogin() {
//        logger.info("Executando diretorPorLogin()");
//        TypedQuery<Diretor> query;
//        query = em.createQuery(
//                "SELECT d FROM Diretor d WHERE d.login = ?1", Diretor.class);
//        query.setParameter(1, "j.vercillo");
//        Diretor diretor = query.getSingleResult();
//        assertEquals("j.vercillo", diretor.getLogin());
//        
//    }
//
//    
//    @Test
//    public void diretorTipoDistinto() {
//        logger.info("Executando diretorTipoDistinto()");
//        TypedQuery<String> query
//                = em.createQuery("SELECT DISTINCT(d.tipoDiretor) FROM Diretor d ORDER BY d.tipoDiretor", String.class);
//        List<String> diretores = query.getResultList();
//        assertNotNull(diretores);
//        assertEquals(2, diretores.size());
//    }
//    
// 
//    @Test
//    public void diretorPorId() {
//        logger.info("Executando diretorPorId()");
//        TypedQuery<Diretor> query = em.createQuery("SELECT d FROM Diretor d WHERE d.id = ?1", Diretor.class);
//        query.setParameter(1, 8);
//        List<Diretor> diretores = query.getResultList();
//        assertNotNull(diretores);
//        assertEquals(1, diretores.size());
//    }
//    
//    
//    
//    
//    
//    ///////////////////////////////////////////////////////////////////////////////////////////////////
//
////    @Test
////    public void categoriaQuantidadeItens() {
////        logger.info("Executando categoriaQuantidadeItens()");
////        Query query = em.createQuery("SELECT c, COUNT(i) FROM Categoria c, Item i WHERE c MEMBER OF i.categorias GROUP BY c");
////        List<Object[]> resultados = query.getResultList();
////        assertEquals(4, resultados.size());
////        assertEquals("Instrumentos Musicais: 5", getCategoriaQuantidade(resultados.get(0)));
////        assertEquals("Guitarras: 1", getCategoriaQuantidade(resultados.get(1)));
////        assertEquals("Pedais: 2", getCategoriaQuantidade(resultados.get(2)));
////        assertEquals("Instrumentos de Sopro: 2", getCategoriaQuantidade(resultados.get(3)));
////    }
//    
//    
//    
//    //    @Test
////    public void diretorPorEspetaculo() {
////        logger.info("Executando diretorPorEspetaculo()");
////        Diretor diretor = em.find(Diretor.class, new Long(2));
////        TypedQuery<Diretor> query = em.createQuery("SELECT c FROM Diretor c WHERE ?1 MEMBER OF c.esptetaculosDirigidos", Diretor.class);
////        query.setParameter(1, diretor);
////        diretor = query.getSingleResult();
////        assertNotNull(diretor);
////    }
//    
//    
////    @Test
////    public void itensPorReputacaoVendedor() {
////        logger.info("Executando itensPorReputacaoVendedor()");
////        TypedQuery<Item> query;
////        query = em.createQuery(
////                "SELECT i FROM Item i WHERE i.vendedor.reputacao = :reputacao",
////                Item.class);
////        query.setParameter("reputacao", Reputacao.EXPERIENTE);
////        List<Item> itens = query.getResultList();
////        assertEquals(3, itens.size());
////    }
//    
//    
}