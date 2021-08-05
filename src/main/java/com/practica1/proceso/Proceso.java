
package com.practica1.proceso;

import com.practica1.enums.Identificador;
import javax.swing.JTextArea;

/**
 *
 * @author elvis_agui
 */
public class Proceso {
    
    private JTextArea cadena;
    private char caracter;
    private String token;
    private int temporal = 0;

    public Proceso(JTextArea cadena) {
        this.cadena = cadena;
    }
    public void Identificar(JTextArea areaLista){
        
    }
    public String token(){
        String token = "" ;
        for (int i = temporal; i < cadena.getText().length(); i++) {
            if (Character.compare(cadena.getText().charAt(i),(Identificador.ESPACIO.getForma().charAt(0))) == 0) {
                this.temporal++;
                break;
            }else{
                token = token+cadena.getText().charAt(i);
                this.temporal++;
            }
        }
        return token;
    }
    
    
    public boolean esIdentificador(String token){
        if (Character.isLetter(token.charAt(0))) {
            return true;
        }else{
            return false;
        }
        
    }
    
    public void verificarEsNumero(String token){
        for (int i = 0; i < token.length(); i++) {
            if (Character.isDigit(token.charAt(i))) {
                
            }
        }
    }  
}
