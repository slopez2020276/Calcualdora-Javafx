/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.marlonhernandez.bean;

/**
 *
 * @author Marlon PC
 * @date 22/04/2021
 * @time 22:09:36
 * Código Técnico: IN5BV
 *
 *
 */
public class Division extends Operacion {
    private static final char OPERADOR = '/';
    public Division(){
}
    
    public Division(double numero1, double numero2){
        super(numero1, numero2, OPERADOR);
        dividir();
    }
    private double dividir (){
        this.setResultado(this.getNumero1() / this.getNumero2());
        return this.getResultado();
    }
    
    public double dividir (double numero1, double numero2){
        this.setNumero1(numero1);
        this.setNumero2(numero2);
        this.setOperador(OPERADOR);
        return this.dividir();
    }
}
