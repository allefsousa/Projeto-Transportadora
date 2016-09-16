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
import sun.rmi.runtime.Log;

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

    
    @Test
    public void testInsereVeiculo() {
        System.out.println("insereVeiculo");
        Veiculo veiculo = new Veiculo("BBB1111 ","9876511",2,"Volvo","12345678000112",2,1);
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = true;
        boolean result = instance.insereVeiculo(veiculo);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeletarVeiculo() {
        System.out.println("deletarVeiculo");
        Veiculo veiculo = new Veiculo(14);
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = true;
        boolean result = instance.deletarVeiculo(veiculo);
        assertEquals(expResult, result);
    }
    @Test
    public void testAtualizarFunc() {
        System.out.println("atualizarFunc");
        Veiculo veiculo = new Veiculo("xxx1111","123456",8,"Toyota","12345678000112",2,2,5);
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = true;
        boolean result = instance.atualizarVeiculo(veiculo);
        assertEquals(expResult, result);
    }

}
