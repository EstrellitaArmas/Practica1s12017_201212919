/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizortogonal;


public class listaColumnas {

    protected NodoCabeceras cabeza;
    protected NodoCabeceras ultimo;

    public listaColumnas() {
        this.cabeza = null;
        this.ultimo = null;

    }

    public boolean estavacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarX(int valor) {
        NodoCabeceras nuevo = new NodoCabeceras();
        NodoCabeceras actual ;
        
        if (estavacia()) {
            this.cabeza = nuevo;
            nuevo.valor= valor;
        } else {
            if (cabeza.siguiente == null && cabeza.valor > valor) {
                cabeza.anterior= nuevo;
                nuevo.siguiente = cabeza;
                nuevo.valor = valor ;
                this.cabeza = nuevo;

            } else if (cabeza.siguiente == null && cabeza.valor < valor) { //crea cabecera en x
                cabeza.siguiente = nuevo ;
                nuevo.anterior= cabeza;
                nuevo.valor = valor;
            } else {
                actual = cabeza;
                if (valor < actual.valor) {
                    cabeza.anterior= nuevo;
                    nuevo.siguiente= cabeza;
                    nuevo.valor= valor;
                    this.cabeza = nuevo;
                }

                while (actual.valor < valor && actual.siguiente != null) {
                    actual = actual.siguiente;

                }
                if (actual.siguiente == null && actual.valor < valor) {
                    actual.siguiente= nuevo ;
                    nuevo.anterior= actual;
                    nuevo.valor= valor;

                } else {
                    actual.anterior.siguiente= nuevo;
                    nuevo.anterior= actual.anterior;
                    actual.anterior = nuevo;
                    nuevo.siguiente= actual;
                    nuevo.valor= valor;

                }
            }

        }

    }

    public void recorrer() {
        NodoCabeceras actual = new NodoCabeceras();
        actual = this.cabeza;
        while (actual != null) {
            System.out.print("lista");
            System.out.print("--->" + actual.valor);
            actual = actual.siguiente;
        }
        System.out.println("");
    }

    public boolean buscarX(int valor) {
        int a = 0;
        NodoCabeceras actual;
        actual = cabeza;
        while (actual != null) {
            if (actual.valor == valor) {
                a = 1;
                break;
            } else {
                actual = actual.siguiente;
            }
        }
        if (a == 1) {
            return true;
        } else {
            return false;
        }

    }

    public NodoCabeceras returnNodoX(int valor) {
        NodoCabeceras actual = new NodoCabeceras();
        actual = this.cabeza;
        while (actual != null) {
            if (actual.valor == valor) {
                break;

            } else {
                actual = actual.siguiente;
            }
        }
        return (actual);
    }


}
