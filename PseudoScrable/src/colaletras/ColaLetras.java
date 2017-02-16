/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colaletras;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author estre
 */
public class ColaLetras extends ArrayList{
    private NodoLetra primero;
    private NodoLetra ultimo;
    private int tamano;

    public ColaLetras() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

//Metodo utilizado para denotar que la lista se encuentra vacia.
    public boolean siVacio() {
        return (this.primero == null);
    }

//Metodo para agregar al final de la lista.
    public ColaLetras addLast(String letra) {
        if(siVacio()) {
            NodoLetra nuevo = new NodoLetra(letra);
            primero = nuevo;
            ultimo = nuevo;
            nuevo.nodoDer = nuevo;
        }
        else {
            NodoLetra nuevo = new NodoLetra(letra);
            nuevo.nodoDer = null;
            ultimo.nodoDer = nuevo;
            ultimo = nuevo;
        }
        this.tamano++;
        return this;
    }

//Metodo para borrar al final de la lista.
    public NodoLetra deleteFirst() {
        NodoLetra eliminar = null;
        if(siVacio()) {
            JOptionPane.showMessageDialog(null, "La lista se encuentra vacia");
            return null;
        }
        if(primero == ultimo) {
            primero = null;
            ultimo = null;
        }
        else {
            NodoLetra actual = primero;                
            eliminar = actual;
            primero=actual.nodoDer;            
        }
        this.tamano--;
        return eliminar;
    }
    /* Quita el primer elemento de la lista     
    public void quitarPrimero(){
        Nodo<T> aux;
        if (!estaVacia()){
            aux=primero;
            primero = primero.getSiguiente();
            aux=null; //Lo marcamos para el recolector de basura
        }
    }*/
//Metodo que imprime el tamaño de la lista.
    public void tamano() {
        JOptionPane.showMessageDialog(null, "El tamaño es:\n " + this.tamano);
    }

//Metodo que imprime la lista y los valores ingresados.
    public void imprimir() {
        if(tamano != 0) {
            NodoLetra temp = primero;
            String str = "";
            for(int i = 0; i < this.tamano; i++) {
                str = str + temp.letra + "\n";
                temp = temp.nodoDer;
            }
            JOptionPane.showMessageDialog(null, str);
        }
    }
}

