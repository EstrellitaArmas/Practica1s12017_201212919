/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimplediccionario;

import javax.swing.JOptionPane;

/**
 *
 * @author estre
 */
public class ListaPalabras {
    private NodoPalabra primero;
    private NodoPalabra ultimo;
    private int tamano;

    public ListaPalabras() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

//Metodo utilizado para denotar que la lista se encuentra vacia.
    public boolean siVacio() {
        return (this.primero == null);
    }

//Metodo para agregar al final de la lista.
    public ListaPalabras addLast(String palabra) {
        if(siVacio()) {
            NodoPalabra nuevo = new NodoPalabra(palabra);
            primero = nuevo;
            ultimo = nuevo;
            nuevo.nodoDer = nuevo;
        }
        else {
            NodoPalabra nuevo = new NodoPalabra(palabra);
            nuevo.nodoDer = null;
            ultimo.nodoDer = nuevo;
            ultimo = nuevo;
        }
        this.tamano++;
        return this;
    }

//Metodo para borrar al final de la lista.
    public NodoPalabra deleteLast() {
        NodoPalabra eliminar = null;
        if(siVacio()) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
            return null;
        }
        if(primero == ultimo) {
            primero = null;
            ultimo = null;
        }
        else {
            NodoPalabra actual = primero;
            while(actual.nodoDer != ultimo) {
                actual = actual.nodoDer;
            }
            eliminar = actual.nodoDer;
            actual.nodoDer = null;

            ultimo = actual;
        }
        this.tamano--;
        return eliminar;
    }

//Metodo que imprime el tamaño de la lista.
    public void tamano() {
        JOptionPane.showMessageDialog(null, "El tamaño es:\n " + this.tamano);
    }

//Metodo que imprime la lista y los valores ingresados.
    public void imprimir() {
        if(tamano != 0) {
            NodoPalabra temp = primero;
            String str = "";
            for(int i = 0; i < this.tamano; i++) {
                str = str + temp.palabra + "\n";
                temp = temp.nodoDer;
            }
            JOptionPane.showMessageDialog(null, str);
        }
    }
}
