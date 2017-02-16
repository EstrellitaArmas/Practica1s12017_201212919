/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaletras;

/**
 *
 * @author estre
 */
public class NodoLetra {
    NodoLetra nodoDer;
    String letra;

    public NodoLetra(String letra) {
        this.letra = letra;
        this.nodoDer = null;
    }
}
