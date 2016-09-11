/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Funcionario;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JCalendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allef
 */
public class DaoFuncionarioTest {
    
    public DaoFuncionarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of chaveEstrangeira method, of class DaoFuncionario.
     */
    @Test
    public void testChaveEstrangeira() {
        System.out.println("chaveEstrangeira");
        String sql = "";
        int idChave = 0;
        DaoFuncionario instance = new DaoFuncionario();
        String expResult = "";
        String result = instance.chaveEstrangeira(sql, idChave);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insereFuncionario method, of class DaoFuncionario.
     */
    @Test
    public void testInsereFuncionario() {
        System.out.println("insereFuncionario");
        JCalendar calendario = new JCalendar();
        Date a = calendario.getDate();
      
        Funcionario funcionario = new Funcionario("Allef", "545455", "545544454", a, 16991580393l, "Motorista", 24545445, "jose martins", "São Paulo", "Aeroprot 2 ", a, 1444, "Complemento","12345678000312", 7);
        DaoFuncionario instance = new DaoFuncionario();
        boolean expResult = true;
        boolean result = instance.insereFuncionario(funcionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarFunc method, of class DaoFuncionario.
     */
    @Test
    public void testAtualizarFunc() {
        System.out.println("atualizarFunc");
        Funcionario funcionario = null;
        DaoFuncionario instance = new DaoFuncionario();
        boolean expResult = false;
        boolean result = instance.atualizarFunc(funcionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarFunc method, of class DaoFuncionario.
     */
    @Test
    public void testDeletarFunc() {
        System.out.println("deletarFunc");
        Funcionario funcionario = null;
        DaoFuncionario instance = new DaoFuncionario();
        boolean expResult = false;
        boolean result = instance.deletarFunc(funcionario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuncionario method, of class DaoFuncionario.
     */
    @Test
    public void testGetFuncionario() {
        System.out.println("getFuncionario");
        int codigo = 0;
        DaoFuncionario instance = new DaoFuncionario();
        Funcionario expResult = null;
        Funcionario result = instance.getFuncionario(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
