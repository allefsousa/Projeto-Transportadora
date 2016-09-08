/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Veiculo;
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
public class DaoVeiculoTest {
    
    public DaoVeiculoTest() {
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
     * Test of insereVeiculo method, of class DaoVeiculo.
     */
    @Test
    public void testInsereVeiculo() {
        System.out.println("insereVeiculo");
        Veiculo veiculo = null;
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = false;
        boolean result = instance.insereVeiculo(veiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletarVeiculo method, of class DaoVeiculo.
     */
    @Test
    public void testDeletarVeiculo() {
        System.out.println("deletarVeiculo");
        Veiculo veiculo = null;
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = false;
        boolean result = instance.deletarVeiculo(veiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizarFunc method, of class DaoVeiculo.
     */
    @Test
    public void testAtualizarFunc() {
        System.out.println("atualizarFunc");
        Veiculo veiculo = null;
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = false;
        boolean result = instance.atualizarFunc(veiculo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVeiculo method, of class DaoVeiculo.
     */
    @Test
    public void testGetVeiculo() {
        System.out.println("getVeiculo");
        int codigo = 0;
        DaoVeiculo instance = new DaoVeiculo();
        Veiculo expResult = null;
        Veiculo result = instance.getVeiculo(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
