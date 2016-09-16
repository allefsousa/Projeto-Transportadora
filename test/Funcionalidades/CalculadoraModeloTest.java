/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

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
public class CalculadoraModeloTest {
    
    public CalculadoraModeloTest() {
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
    public void testSomar() {
        System.out.println("somar");
        double a = 10.0;
        double b = 30.0;
        CalculadoraModelo instance = new CalculadoraModelo();
        Double expResult = 45.0;
        Double result = instance.somar(a, b);
        assertEquals(expResult, result);
      
        
    }

   
    @Test
    public void testDividir() {
        System.out.println("Dividir");
        double a = 20.0;
        double b = 1.0;
        CalculadoraModelo instance = new CalculadoraModelo();
        double expResult = 20.0;
        double result = instance.Dividir(a, b);
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of Multiplicar method, of class CalculadoraModelo.
     */
    @Test
    public void testMultiplicar() {
        System.out.println("Multiplicar");
        double a = 100.0;
        double b = 1.0;
        CalculadoraModelo instance = new CalculadoraModelo();
        double expResult = 100.0;
        double result = instance.Multiplicar(a, b);
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of Subtrair method, of class CalculadoraModelo.
     */
    @Test
    public void testSubtrair() {
        System.out.println("Subtrair");
        double a = 20.0;
        double b = 10.0;
        CalculadoraModelo instance = new CalculadoraModelo();
        double expResult = 10.0;
        double result = instance.Subtrair(a, b);
        assertEquals(expResult, result, 0.0);
       
    }
    
}
