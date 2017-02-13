/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimplediccionario;

/**
 *
 * @author estre
 */
public class NodoPalabra {
     NodoPalabra nodoDer;
    String palabra;

    public NodoPalabra(String palabra) {
        this.palabra = palabra;
        this.nodoDer = null;
    }

}
