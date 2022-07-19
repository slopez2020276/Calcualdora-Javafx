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
 * @time 22:10:28
 * Código Técnico: IN5BV
 *
 *
 */
public class Porciento extends Operacion {
    private static final char OPERADOR = '%';
    public Porciento(){
}
    
    public Porciento(double numero1, double numero2){
        super(numero1, numero2, OPERADOR);
        porcentaje();
    }
    private double porcentaje (){
        this.setResultado(this.getNumero1() * this.getNumero2() /100);
        return this.getResultado();
    }
    
    public double porcentaje (double numero1, double numero2){
        this.setNumero1(numero1);
        this.setNumero2(numero2);
        this.setOperador(OPERADOR);
        return this.porcentaje();
    }
}
