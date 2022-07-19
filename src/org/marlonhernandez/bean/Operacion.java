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
 * @time 22:10:20
 * Código Técnico: IN5BV
 *
 *
 */
public abstract class Operacion {
    //Atributos
    private double numero1;
    private double numero2;
    private double resultado;
    private char operador;

    //Constructor nulo
    public Operacion() {
        this.operador = ',';
    }
    
    public Operacion(double numero1, double numero2){
        this.numero1 = numero1;
        this.numero2 = numero2;
    }
    public Operacion(double numero1, double numero2, char operacion){
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operador = operacion;
    }

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }
    
    
}