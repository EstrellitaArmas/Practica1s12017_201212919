/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircularjugadores;

import listasimplemano.NodoMano;


/**
 *
 * @author estre
 */
public class NodoJugador {
    NodoJugador nodoDer;
    String nombre;
    NodoMano manoJuego;
    
    public NodoJugador(String nombre){
        this.nombre= nombre;
        this.nodoDer= null;
        this.manoJuego= null;
    }
    
    
}
