
package com.practica1.enums;

/**
 *
 * @author elvis_agui
 */
public enum Identificador {
    IDENTIFICADOR("ID"),
    ENTERO("Entero"),
    DECIMAL("Decimal"),
    CORCHETES("Caracter '['  ']'"),
    LLAVES("simbo '{'  '}'"),
    PUNTO_COMA("Simbolo ';'"),
    COMA("Simbolo ','"),
    ERROR("Error"),
    ESPACIO(" ");

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
    
    private String forma;
    
    private Identificador(String forma){
        this.forma = forma; 
    }
    
    
}
