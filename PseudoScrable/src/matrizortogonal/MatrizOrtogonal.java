/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizortogonal;

/**
 *
 * @author estre
 */
public class MatrizOrtogonal {
     listaFilas fila = new listaFilas();   // nodo de las filas en y
    listaColumnas columna = new listaColumnas(); // nodo de las columnas en x

    public MatrizOrtogonal() {
    }

    public void insertar_nodo(int x, int y, String letra, int dimension) {
        NodoOrtogonal nuevo = new NodoOrtogonal(x,y,letra,dimension);
        //nodo de la matriz
        NodoOrtogonal aux ;
        NodoOrtogonal aux_2; 

        NodoCabeceras nodoCabeceraY ;
        NodoCabeceras nodoCabeceraX ;

        // condicion que me dice que no existe ni la fila ni la columna
        if (fila.buscarY(y) == false && columna.buscarX(x) == false) {
            fila.insertarY(y);
            columna.insertarX(x);

            nodoCabeceraY = fila.returnNodoY(y);
            nodoCabeceraX = columna.returnNodoX(x);
            //Inserta el nuevo nodo a columna y fila inicial 0,0    1,1   ........
            if (nodoCabeceraY.derecha_primero == null && nodoCabeceraX.abajo_primero == null) {
                nuevo.primeroX= nodoCabeceraX;
                nuevo.primeroY=nodoCabeceraY;
                nodoCabeceraX.abajo_primero= nuevo;
                nodoCabeceraY.derecha_primero=nuevo;
                nuevo.y=y;//fila y
                nuevo.x=x;//columna x

            }
            System.out.println("Insertadas cabeceras"+nuevo.letra + nuevo.x+ nuevo.y);
        } //si existe ya la fila pero la columna no
        else if (fila.buscarY(y) == true && columna.buscarX(x) == false) {
            columna.insertarX(x);

            nodoCabeceraX = columna.returnNodoX(x);
            nodoCabeceraY = fila.returnNodoY(y);

            aux = nodoCabeceraY.derecha_primero;
            if (aux.nodoDer == null && aux.x < x) {
                aux.nodoDer= nuevo;
                nuevo.nodoIzq= aux;
                nuevo.primeroX= nodoCabeceraX;
                nodoCabeceraX.abajo_primero = nuevo;
                nuevo.x = x;
                nuevo.y= y;

            } else if (aux.nodoIzq == null && aux.x > x) {
                nodoCabeceraX.abajo_primero= nuevo;
                nodoCabeceraY.derecha_primero= nuevo;

                aux.nodoIzq= nuevo;
                nuevo.nodoDer= aux;
                nuevo.primeroX=nodoCabeceraX;
                nuevo.primeroY= nodoCabeceraY;

                nuevo.x= x;
                nuevo.y= y;
            } else {
                if (x < aux.x) {
                    aux.nodoIzq= nuevo;
                    nuevo.nodoDer= aux;

                    nodoCabeceraX.abajo_primero=nuevo;
                    nuevo.primeroX=nodoCabeceraX;

                    nodoCabeceraY.derecha_primero= nuevo;
                    nuevo.primeroY = nodoCabeceraY;

                    nuevo.y= y;
                    nuevo.x= x;

                }

                while (aux.nodoDer!= null && aux.x < x) {
                    aux = aux.nodoDer;
                }

                if (aux.nodoDer == null && aux.x < x) {
                    aux.nodoDer= nuevo;
                    nuevo.nodoIzq= aux;
                    
                    nuevo.primeroX= nodoCabeceraX;
                    nodoCabeceraX.abajo_primero= nuevo;

                    nuevo.y = y;
                    nuevo.x = x;

                } else {
                    aux.nodoIzq.nodoDer= nuevo;
                    nuevo.nodoIzq= aux.nodoIzq;
                    nuevo.nodoDer= aux;
                    aux.nodoIzq= nuevo;

                    nuevo.primeroX= nodoCabeceraX;
                    nodoCabeceraX.abajo_primero= nuevo;
                    
                    nuevo.y = y;
                    nuevo.x = x;

                }
            }
            System.out.println("Insertado"+nuevo.letra + nuevo.x+"--"+ nuevo.y);
        } /*// si existe la columna pero no la fila
        else if (fila.buscarY(y) == false && columna.buscarX(x)) {
            fila.insertarY(y);

            nodoX = columna.returnNodoX(x);
            nodoY = fila.returnNodoY(y);

            aux = nodoX.getAbajo_primero();

            if (aux.getAbajo() == null && aux.getFila() < y) {
                aux.setAbajo(nuevo);
                nuevo.setArriba(aux);

                nuevo.setPrimero_Y(nodoY);
                nodoY.setDerecha_primero(nuevo);
                nuevo.setFila(y);
                nuevo.setColumna(x);
            } else if (aux.getArriba() == null && aux.getFila() > y) {
                nodoX.setAbajo_primero(nuevo);
                nodoY.setDerecha_primero(nuevo);

                nuevo.setPrimero_X(nodoX);
                nuevo.setPrimero_Y(nodoY);

                aux.setArriba(nuevo);
                nuevo.setAbajo(aux);
                nuevo.setFila(y);
                nuevo.setColumna(x);

            } else {
                if (y < aux.getFila()) {
                    aux.setArriba(nuevo);
                    nuevo.setAbajo(aux);

                    nodoY.setDerecha_primero(nuevo);
                    nuevo.setPrimero_Y(nodoY);

                    nodoX.setAbajo_primero(nuevo);
                    nuevo.setPrimero_X(nodoX);

                    nuevo.setFila(y);
                    nuevo.setColumna(x);

                }
                while (aux.getAbajo() != null && aux.getFila() < y) {
                    aux = aux.getAbajo();

                }
                if (aux.getAbajo() == null && aux.getFila() < y) {
                    aux.setAbajo(nuevo);
                    nuevo.setArriba(aux);

                    nuevo.setPrimero_Y(nodoY);
                    nodoY.setDerecha_primero(nuevo);

                    nuevo.setFila(y);
                    nuevo.setColumna(x);
                } else {
                    aux.getArriba().setAbajo(nuevo);
                    nuevo.setArriba(aux.getArriba());
                    nuevo.setAbajo(aux);
                    aux.setArriba(nuevo);

                    nuevo.setPrimero_Y(nodoY);
                    nodoY.setDerecha_primero(nuevo);

                    nuevo.setFila(y);
                    nuevo.setColumna(x);
                }

            }

        } //si existe la columna y la fila*/
        else if (fila.buscarY(y) == true && columna.buscarX(x) == true) {

            nodoCabeceraX = columna.returnNodoX(x);
            nodoCabeceraY = fila.returnNodoY(y);

            aux = nodoCabeceraX.abajo_primero;
            aux_2 = nodoCabeceraY.derecha_primero;

            if (aux.nodoAbajo == null && aux.y < y) {
                aux.nodoAbajo= nuevo;
                nuevo.nodoArriba= aux;
                nuevo.y= y;
                nuevo.x= x;

            } else if (aux.nodoArriba == null && aux.y > y) {
                nodoCabeceraX.abajo_primero= nuevo;
                nuevo.primeroX= nodoCabeceraX;

                aux.nodoArriba= nuevo;
                nuevo.nodoAbajo = aux; 
                nuevo.y= y;
                nuevo.x= x;
            } else {
                if (y < aux.y) {
                    aux.nodoArriba= nuevo;
                    nuevo.nodoAbajo = aux;

                    nodoCabeceraX.abajo_primero= nuevo;
                    nuevo.primeroX= nodoCabeceraX;

                    nuevo.y = y;
                    nuevo.x = x;

                }
                while (aux.nodoAbajo != null && aux.y < y) {
                    aux = aux.nodoAbajo;

                }
                if (aux.nodoAbajo == null && aux.y < y) {
                    aux.nodoAbajo= nuevo;
                    nuevo.nodoArriba= aux;

                    nuevo.y= y;
                    nuevo.x= x;
                } else {
                    aux.nodoArriba.nodoAbajo= nuevo;
                    nuevo.nodoArriba= aux.nodoArriba;
                    nuevo.nodoAbajo= aux;
                    aux.nodoArriba= nuevo;

                    nuevo.y= y;
                    nuevo.x=x;
                }
            }

            if (aux_2.nodoDer == null && aux_2.x < x) {
                aux_2.nodoDer= nuevo;
                nuevo.nodoIzq= aux_2;

                nuevo.y= y;
                nuevo.x=x;

            } else if (aux_2.nodoIzq == null && aux_2.x > x) {
                aux_2.nodoIzq= nuevo;
                nuevo.nodoDer= aux_2;

                nuevo.primeroY= nodoCabeceraY;
                nodoCabeceraY.derecha_primero=  nuevo;

                nuevo.y= y;
                nuevo.x=x;
            } else {
                if (x < aux_2.x) {
                    aux_2.nodoIzq= nuevo;
                    nuevo.nodoDer = aux_2;

                    nuevo.primeroY= nodoCabeceraY;
                    nodoCabeceraY.derecha_primero= nuevo;                   

                }

                while (aux_2.nodoDer != null && aux_2.x < x) {
                    aux_2 = aux_2.nodoDer;
                }

                if (aux_2.nodoDer == null && aux_2.x < x) {
                    aux_2.nodoDer= nuevo;
                    nuevo.nodoIzq= aux_2;                   

                } else {
                    aux_2.nodoIzq.nodoDer= nuevo;
                    nuevo.nodoIzq= aux_2.nodoIzq; 
                    nuevo.nodoDer= aux_2;
                    aux_2.nodoIzq= nuevo;                   

                }
            }
            System.out.println("Insertado"+nuevo.letra +" "+ nuevo.x+"--" + nuevo.y);
        }
        
    }
     public void recorrer_matriz() {
        NodoCabeceras actual_y;
        NodoOrtogonal actual;
        
        actual_y = fila.cabeza;
                
        actual = actual_y.derecha_primero;
        System.out.print("nodosmatriz_X-->");
        while (actual != null) {
            System.out.print("-->" + actual.x);

            actual = actual.nodoDer;
        }

    }
}
