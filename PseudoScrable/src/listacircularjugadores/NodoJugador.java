/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircularjugadores;

import Listaletras.NodoLetra;


/**
 *
 * @author estre
 */
public class NodoJugador {
    NodoJugador nodoDer;
    String nombre;
    int puntos;
    public NodoLetra manoJuego;
    
    public NodoJugador(String nombre){
        this.nombre= nombre;
        this.puntos = 0;
        this.nodoDer= null;
        this.manoJuego= null;
    }
    
    
}
