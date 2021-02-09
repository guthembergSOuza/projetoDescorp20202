package br.com.projetodescorp.test;

import br.com.projetodescorp.model.usuario.Diretor;
import br.com.projetodescorp.model.usuario.TipoDiretor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.dbunit.DatabaseUnitException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author guthemberg
 */
public class UsuarioTest {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;
    
    @BeforeClass
    public static void setUpClass() throws DatabaseUnitException {
        emf = Persistence.createEntityManagerFactory("projetodescorp20201");
        DbUnitUtil.inserirDados();
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
    }

    @After
    public void tearDown() {
        if (!et.getRollbackOnly()) {
            et.commit();
        }
        em.close();
    }
    
    @org.junit.Test
    public void persistirUsuarioDiretor() {
        Diretor usuario;
        usuario = criarDiretor();
        em.persist(usuario);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(usuario.getId());
    }
    
    private Diretor criarDiretor() {
        Diretor usuario = new Diretor();
        usuario.setNome("Fulaninho da Silva");
        usuario.setEmail("fulano6@gmail.com");
        usuario.setLogin("fulano6");
        usuario.setSenha("teste");
        usuario.setTipoDiretor(TipoDiretor.GERAL);
        usuario.setCompanhiaDeTeatro("Cia do Ator");
        return usuario;
    }
}
