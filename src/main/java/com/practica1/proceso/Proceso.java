package com.practica1.proceso;

import com.practica1.enums.Identificador;
import javax.swing.JTextArea;

/**
 *
 * @author elvis_agui
 */
public class Proceso {

    private JTextArea cadena;
    private String token;
    private int temporal = 0;
    private JTextArea areaLista;

    public Proceso(JTextArea cadena, JTextArea areaLista) {
        this.cadena = cadena;
        this.areaLista = areaLista;
    }

    public void identificar() {
        try {
            do {
                this.token = token();
                if (esLetra(this.token.charAt(0))) {
                    verificadorID(this.token);
                }
                if (esNumero(this.token.charAt(0)) && !unicoPunto(this.token)) {
                    verificadorNumero(this.token);
                }
                if (esNumero(this.token.charAt(0)) && unicoPunto(this.token)) {
                    verificadorDecimal(this.token);
                }
                /*else {
                    enlistar(token, Identificador.ERROR);
                }*/
            } while (temporal != (cadena.getText().length() - 1));
        } catch (Exception e) {
        }

    }

    public String token() {
        String token = "";
        for (int i = temporal; i < cadena.getText().length(); i++) {
            if (Character.compare(cadena.getText().charAt(i), (Identificador.SALTO.getForma().charAt(0))) == 0) {
                this.temporal++;
                break;
            } else {
                if (Character.compare(cadena.getText().charAt(i), (Identificador.ESPACIO.getForma().charAt(0))) == 0) {
                    this.temporal++;
                    break;
                } else {
                    token = token + cadena.getText().charAt(i);
                    this.temporal++;
                }
            }

        }
        return token;
    }

    public void verificadorID(String token) {
        String aux = String.valueOf((token.charAt(0)));
        for (int i = 1; i < token.length(); i++) {
            if (esNumero(token.charAt(i))) {
                aux = aux + String.valueOf((token.charAt(i)));
            }
            if (esLetra(token.charAt(i))) {
                aux = aux + String.valueOf((token.charAt(i)));
            }
        }
        if (token.equals(aux)) {
            enlistar(token, Identificador.IDENTIFICADOR);
        } else {
            enlistar(token, Identificador.ERROR);
        }
    }

    public void verificadorNumero(String token) {
        String aux = String.valueOf((token.charAt(0)));
        for (int i = 1; i < token.length(); i++) {
            if (esNumero(token.charAt(i))) {
                aux = aux + String.valueOf((token.charAt(i)));
            }
            if (token.equals(aux)) {
                enlistar(token, Identificador.ENTERO);
            } else {
                enlistar(token, Identificador.ERROR);
            }

        }
    }

    public void verificadorDecimal(String token) {
        String aux = String.valueOf((token.charAt(0)));
        for (int i = 1; i < token.length(); i++) {
            if (Character.compare(cadena.getText().charAt(i), (Identificador.PUNTO.getForma().charAt(0))) == 0) {
                aux = aux + String.valueOf((token.charAt(i)));
            }
            if (esNumero(token.charAt(i))) {
                aux = aux + String.valueOf((token.charAt(i)));
            }
            if (token.equals(aux)) {
                enlistar(token, Identificador.DECIMAL);
            } else {
                enlistar(token, Identificador.ERROR);
            }

        }
    }

    public boolean unicoPunto(String token) {
        int contador = 0;
        for (int i = 1; i < token.length(); i++) {
            if (Character.compare(cadena.getText().charAt(i), (Identificador.PUNTO.getForma().charAt(0))) == 0) {
                contador++;
            }
        }
        if (contador == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void enlistar(String token, Identificador valor) {
        switch (valor) {
            case IDENTIFICADOR:
                this.areaLista.append("\n---" + Identificador.IDENTIFICADOR.getForma() + "   " + token);
                break;
            case ERROR:
                this.areaLista.append("\n---" + Identificador.ERROR.getForma() + "   " + token);
                break;
        }

    }

    public boolean esNumero(char caracter) {
        if (Character.isDigit(caracter)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esLetra(char caracter) {
        if (Character.isLetter(caracter)) {
            return true;
        } else {
            return false;
        }
    }
}
