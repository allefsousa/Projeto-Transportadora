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
        Veiculo veiculo = new Veiculo("1245-asbd","2154655",3,"Volvo",12456554,1,1);
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = true;
        boolean result = instance.insereVeiculo(veiculo);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeletarVeiculo() {
        System.out.println("deletarVeiculo");
        Veiculo veiculo = new Veiculo(13);
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = true;
        boolean result = instance.deletarVeiculo(veiculo);
        assertEquals(expResult, result);
    }
    @Test
    public void testAtualizarFunc() {
        System.out.println("atualizarFunc");
        Veiculo veiculo = new Veiculo("6548-gsca","2154655",2,"Toyota",12456554,1,1,15);
        DaoVeiculo instance = new DaoVeiculo();
        boolean expResult = true;
        boolean result = instance.atualizarFunc(veiculo);
        assertEquals(expResult, result);
    }

}
