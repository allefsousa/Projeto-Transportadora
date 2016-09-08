/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

/**
 *
 * @author Allef
 */
public class CalculadoraModelo {
    double res;
    public Double somar(double a, double b){
        res = a + b;
        return res;
    }
    public double Dividir(double a, double b){
        res = a / b;
        return res;
    }
    public double Multiplicar(double a, double b){
        res = a * b;
        return res;
    }
    public double Subtrair(double a, double b){
        res = a - b;
        return res;
    }
}
