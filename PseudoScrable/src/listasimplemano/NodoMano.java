/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimplemano;

/**
 *
 * @author estre
 */
public class NodoMano {
   
    NodoMano nodoDer;
    String letra;

    public NodoMano(String letra) {
        this.letra = letra;
        this.nodoDer = null;
    }

}

