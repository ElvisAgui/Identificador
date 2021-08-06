
package com.practica1.enums;

/**
 *
 * @author elvis_agui
 */
public enum Identificador {
    IDENTIFICADOR("ID"),
    ENTERO("Entero"),
    DECIMAL("Decimal"),
    CORCHETES("Simbolo'['']'"),
    LLAVES("simbolo'{''}'"),
    PUNTO_COMA("Simbolo';'"),
    COMA("Simbolo ','"),
    ERROR("Error"),
    SALTO("\n"),
    ESPACIO(" "),
    PUNTO(".");

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
