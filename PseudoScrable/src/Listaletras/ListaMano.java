/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listaletras;

import javax.swing.JOptionPane;


/**
 *
 * @author estre
 */
public class ListaMano {
    public NodoLetra primero;
    public NodoLetra ultimo;
    public int tamano;

    public ListaMano() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

//Metodo utilizado para denotar que la lista se encuentra vacia.
    public boolean siVacio() {
        return (this.primero == null);
    }

//Metodo para agregar al final de la lista.
    public void addLast(String letra, int puntos) {
        if(siVacio()) {
            NodoLetra nuevo = new NodoLetra(letra, puntos);
            primero = nuevo;
            ultimo = nuevo;
            nuevo.nodoDer = null;
        }
        else {
            NodoLetra nuevo = new NodoLetra(letra, puntos);
            nuevo.nodoDer = null;
            ultimo.nodoDer = nuevo;
            ultimo = nuevo; 
        }
        this.tamano++;
        
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
