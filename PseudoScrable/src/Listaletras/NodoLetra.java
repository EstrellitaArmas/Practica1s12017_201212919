/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listaletras;

/**
 *
 * @author estre
 */
public class NodoLetra {
    public NodoLetra nodoDer;
    public String letra = "";
    public int puntos = 0 ;

    public NodoLetra(String letra, int puntos) {
        this.letra = letra;
        this.puntos= puntos;
        this.nodoDer = null;
    }
}
