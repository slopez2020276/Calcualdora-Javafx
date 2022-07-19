/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marlonhernandez.controller;

import org.marlonhernandez.bean.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author Marlon PC
 */
public class FXMLCalcController implements Initializable {

    @FXML
    private Label lblpantalla;
    @FXML
    private Button btnAC;
    @FXML
    private Button btnPorciento;
    @FXML
    private Button btndividido;
    @FXML
    private Button btnsiete;
    @FXML
    private Button btnocho;
    @FXML
    private Button btnnueve;
    @FXML
    private Button btnpor;
    @FXML
    private Button btncuatro;
    @FXML
    private Button btncinco;
    @FXML
    private Button btnseis;
    @FXML
    private Button btnmenos;
    @FXML
    private Button btn1;
    @FXML
    private Button btndos;
    @FXML
    private Button btntres;
    @FXML
    private Button btnmas;
    @FXML
    private Button btnmasmenos;
    @FXML
    private Button btncero;
    @FXML
    private Button btnpunto;
    @FXML
    private Button btnigual;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicAc(ActionEvent event) {
    }

    @FXML
    private void clicPorciento(ActionEvent event) {
        calcular ("%");
    }

    @FXML
    private void clicdividido(ActionEvent event) {
        calcular ("/");
    }

    @FXML
    private void clicsiete(ActionEvent event) {
        actualizarPantalla("7");
    }

    @FXML
    private void clicocho(ActionEvent event) {
        actualizarPantalla("8");
    }

    @FXML
    private void clicnueve(ActionEvent event) {
        actualizarPantalla("9");
    }

    @FXML
    private void clicpor(ActionEvent event) {
        calcular ("*");       
    }

    @FXML
    private void cliccuatro(ActionEvent event) {
        actualizarPantalla("4");
    }

    @FXML
    private void cliccinco(ActionEvent event) {
        actualizarPantalla("5");
    }

    @FXML
    private void clicseis(ActionEvent event) {
        actualizarPantalla("6");
    }

    @FXML
    private void clicmenos(ActionEvent event) {
        calcular ("-");
    }

    @FXML
    private void clic1(ActionEvent event) {
        actualizarPantalla("1");
    }

    @FXML
    private void clic2(ActionEvent event) {
        actualizarPantalla("2");
    }

    @FXML
    private void clictres(ActionEvent event) {
        actualizarPantalla("3");
    }

    @FXML
    private void clicmas(ActionEvent event) {
        calcular ("+");
    }

    @FXML
    private void clicmasmenos(ActionEvent event) {        
        double numMasMenos = Double.parseDouble(lblpantalla.getText());
        lblpantalla.setText(String.valueOf(numMasMenos * (-1)));
     }

    @FXML
    private void cliccero(ActionEvent event) {
        actualizarPantalla("0");
    }

    @FXML
    private void clicpunto(ActionEvent event) {
        agregarPunto();
    }

    @FXML
    private void clicigual(ActionEvent event) {
        calcular(this.operadorAnt);
        lblpantalla.setText(String.valueOf(this.resultado));
    
    }
    
    private double resultado;
    private double numero;
    private int contadorOp = 0;
    private String operadorAnt;
    private boolean ingresoNuevo = false;
    
 
    
    public void agregarPunto(){
         if (ingresoNuevo){
         lblpantalla.setText("");
         }
         
        String cadena = lblpantalla.getText();
        
        if (cadena.length() <= 0){
            lblpantalla.setText("0.");
            ingresoNuevo = false;
        } else if (!(lblpantalla.getText().contains("."))) {
            actualizarPantalla(".");
        }
    }
    
    
    public void actualizarPantalla(String digito){
        if (ingresoNuevo){
            lblpantalla.setText("");
            
        }
        lblpantalla.setText(lblpantalla.getText().concat(digito));
        ingresoNuevo = false;
    }
    

    
    public void calcular (String operador){
        if(!(lblpantalla.getText().equals("")));{
        
            String strPantalla = lblpantalla.getText();
            
            if(ingresoNuevo == false){
                this.numero = Double.parseDouble(strPantalla);
                contadorOp++;
                
                if(contadorOp == 1){
                    this.resultado = numero; 
                } else if (contadorOp >= 2){
                    
                    switch(this.operadorAnt){
                        case "+":
                            Suma sum = new Suma();
                            sum.setNumero1(resultado);
                            sum.setNumero2(numero);
                            this.resultado =sum.sumar(sum.getNumero1(), sum.getNumero2());
                            break;
                            
                        case "-":
                            Resta rest = new Resta();
                            rest.setNumero1(resultado);
                            rest.setNumero2(numero);
                            this.resultado =rest.restar(rest.getNumero1(), rest.getNumero2());
                            break;                            
                            
                        case "*":
                            Multiplicacion multi = new Multiplicacion();
                            multi.setNumero1(resultado);
                            multi.setNumero2(numero);
                            this.resultado = multi.multiplicar(multi.getNumero1(), multi.getNumero2());
                            break;
                            
                        case"/":
                            Division div = new Division();
                            div.setNumero1(resultado);
                            div.setNumero2(numero);
                            this.resultado =div.dividir(div.getNumero1(), div.getNumero2());
                            break;
                            
                        case"%":
                            Porciento porcen = new Porciento();
                            porcen.setNumero1(resultado);
                            porcen.setNumero2(numero);
                            this.resultado =porcen.porcentaje(porcen.getNumero1(), porcen.getNumero2());
                            break;
                      
                            
                    }
                    lblpantalla.setText(String.valueOf(this.resultado));
                }
                
            }
            this.operadorAnt = operador;
        } 
        ingresoNuevo = true;
    }


}