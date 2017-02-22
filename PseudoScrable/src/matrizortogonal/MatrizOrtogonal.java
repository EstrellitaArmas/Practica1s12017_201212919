/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizortogonal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author estre
 */
public class MatrizOrtogonal {
     listaFilas fila = new listaFilas();   // nodo de las filas en y
    listaColumnas columna = new listaColumnas(); // nodo de las columnas en x
    String grafoMatriz="";
    int i=0;
            
    public MatrizOrtogonal() {
    }

    public void insertar_nodo(int x, int y, String letra, int dimension) {
        NodoOrtogonal nuevo = new NodoOrtogonal(x,y,letra,dimension);
        //nodo de la matriz
        NodoOrtogonal aux ;
        NodoOrtogonal aux_2; 

        NodoCabeceras nodoCabeceraY ;
        NodoCabeceras nodoCabeceraX ;
        int i=0;
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
            //node1 [label = "{<n> n14 | 719 |<p> }"]
            grafoMatriz+= "node"+ (i++) + "[label = \"{<izq> |<a>"+ nuevo.letra + nuevo.x+ nuevo.y + "|<der> }\"];\n";
            System.out.println("Insertadas cabeceras"+nuevo.letra + nuevo.x+ nuevo.y);
        } //si existe ya la fila pero la columna no
        else if (fila.buscarY(y) == true && columna.buscarX(x) == false) {
            columna.insertarX(x);

            nodoCabeceraX = columna.returnNodoX(x);
            nodoCabeceraY = fila.returnNodoY(y);

            aux = nodoCabeceraY.derecha_primero;
            if (aux.nodoDer == null && aux.x < x) { //inserta primer nodo de la fila existente 
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
            grafoMatriz+= "node"+ (i++) + "[label = \"{<izq> |<a>"+ nuevo.letra + nuevo.x+ nuevo.y + "|<der> }\"];\n";
            System.out.println("Insertado"+nuevo.letra + nuevo.x+"--"+ nuevo.y);
        } //si existe la columna pero no la fila
        else if (fila.buscarY(y) == false && columna.buscarX(x)) {
            fila.insertarY(y);

            nodoCabeceraX = columna.returnNodoX(x);
            nodoCabeceraY = fila.returnNodoY(y);

            aux = nodoCabeceraX.abajo_primero;

            if (aux.nodoAbajo == null && aux.y < y) {
                aux.nodoAbajo= nuevo;
                nuevo.nodoArriba= aux;

                nuevo.primeroY= (nodoCabeceraY);
                nodoCabeceraY.derecha_primero= nuevo;
                nuevo.y = y;
                nuevo.x = x;
                
            } else if (aux.nodoArriba == null && aux.y > y) {
                nodoCabeceraX.abajo_primero= nuevo;
                nodoCabeceraY.derecha_primero= nuevo;

                nuevo.primeroX= nodoCabeceraX;
                nuevo.primeroY= nodoCabeceraY;

                aux.nodoArriba= nuevo;
                nuevo.nodoAbajo= aux;
                nuevo.y = y;
                nuevo.x = x;
            } else {
                if (y < aux.y) {
                    aux.nodoArriba= nuevo;
                    nuevo.nodoAbajo= aux;

                    nodoCabeceraY.derecha_primero= nuevo;
                    nuevo.primeroY= nodoCabeceraY;

                    nodoCabeceraX.abajo_primero= nuevo;
                    nuevo.primeroX= nodoCabeceraX;

                    nuevo.y = y;
                    nuevo.x = x;

                }
                while (aux.nodoAbajo != null && aux.y < y) {
                    aux = aux.nodoAbajo;

                }
                if (aux.nodoAbajo == null && aux.y < y) {
                    aux.nodoAbajo=(nuevo);
                    nuevo.nodoArriba= aux;

                    nuevo.primeroY=nodoCabeceraY;
                    nodoCabeceraY.derecha_primero= nuevo;

                    nuevo.y = y;
                    nuevo.x = x;
                } else {
                    aux.nodoArriba.nodoAbajo= nuevo;
                    nuevo.nodoArriba= aux.nodoArriba;
                    nuevo.nodoAbajo= aux;
                    aux.nodoArriba= nuevo;

                    nuevo.primeroY= nodoCabeceraY;
                    nodoCabeceraY.derecha_primero= nuevo;

                    nuevo.y = y;
                    nuevo.x = x;
                }

            }
            grafoMatriz+= "node"+ (i++) + "[label = \"{<izq> |<a>"+ nuevo.letra + nuevo.x+ nuevo.y + "|<der> }\"];\n";
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
            grafoMatriz+= "node"+ (i++) + "[label = \"{<izq> |<a>"+ nuevo.letra + nuevo.x+ nuevo.y + "|<der> }\"];\n";
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
     
     public String crear_grafo() {
        
        NodoCabeceras fila_Y ;
        NodoOrtogonal actual;
        int i=0;        
        String apuntador = "";
        try {               
                // recorre mi matriz  
                int contador = 0;
                fila_Y = fila.cabeza;   
                
                while (fila_Y != null) {
                    if (contador == 0) {                        
                        actual = fila_Y.derecha_primero;
                          
                        while (actual.nodoDer != null) {                       

                            actual = actual.nodoDer;                       
                           
                            apuntador += "\" X: " + actual.nodoIzq.x + " Y: " + actual.nodoIzq.y + "\"";
                            apuntador +=  "-> \" X: " + actual.x + " Y: " + actual.y + "\";\n";
                            
                            apuntador += "\" X: " + actual.x + " Y: " + actual.y + "\"";
                            apuntador += "-> \" X: " + actual.nodoIzq.x + " Y: " + actual.nodoIzq.y + "\";\n\n";
                            
                        }  
                        
                        fila_Y = fila_Y.siguiente;
                        contador++;
                    } // contador = 1
                    else {
                        actual = fila_Y.derecha_primero;
                       
                        while (actual.nodoDer != null) {
                            actual = actual.nodoDer;
                            if (actual.nodoIzq != null) {
                                apuntador = apuntador + "\" X: " + actual.nodoIzq.x + " Y: " + actual.nodoIzq.y + "\"";
                                apuntador = apuntador + "->  \" X: " + actual.x + " Y: " + actual.y + "\";\n";
                                apuntador = apuntador + "\" X: " + actual.x + " Y: " + actual.y + "\"";
                                apuntador = apuntador + "-> \" X: " + actual.nodoIzq.x + " Y: " + actual.nodoIzq.y + "\";\n\n";
                            }

                            if (actual.nodoArriba != null) {
                                apuntador = apuntador + "\" X: " + actual.x + " Y: " + actual.y + "\"";
                                apuntador = apuntador + "-> \" X: " + actual.nodoArriba.x + " Y: " + actual.nodoArriba.y + "\";\n";
                                apuntador = apuntador + "\" X: " + actual.nodoArriba.x + " Y: " + actual.nodoArriba.y + "\"";
                                apuntador = apuntador + "-> \" X: " + actual.x + " Y: " + actual.y + "\";\n\n";
                            }
                        }
                        
                      /* if (actual.nodoArriba != null) {
                                apuntador = apuntador + "\" X: " + actual.x + " Y: " + actual.y + "\"";
                                apuntador = apuntador + "-> \" X: " + actual.nodoArriba.x + " Y: " + actual.nodoArriba.y + "\";\n";
                                apuntador = apuntador + "\" X: " + actual.nodoArriba.x + " Y: " + actual.nodoArriba.y + "\"";
                                apuntador = apuntador + "-> \" X: " + actual.x + " Y: " + actual.y + "\";\n\n";
                        }*/
                        fila_Y = fila_Y.siguiente;

                    }

                }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        return apuntador;
    }
     public void GenerarImagen(String nodos){
         
         String rutaArchivo;
         String rutaImagen;
         String texto= "digraph G{ \n node [shape=box, fontsize=16]; \n" +nodos+"  \n }  " ;
            rutaArchivo = "grafoMatriz.dot";
            rutaImagen = "grafoMatriz.png";
         
         try {
        File archivo = new File(rutaArchivo);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write(texto); 
        bw.close();
            dibujar(rutaArchivo, rutaImagen,1);
         
        } catch (IOException ex) {
                 System.out.println("Error>> "+ex.getMessage());
             }
        
        
    }
    
    public void dibujar( String direccionDot, String direccionPng ,int opcion){
            try
            {       
                File archivo = new File(direccionPng);
                ProcessBuilder pbuilder;
                
                if (opcion==1){
                    pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", direccionPng, direccionDot );
                
                }else{
                     pbuilder = new ProcessBuilder( "dot","-Kfdp","-n","-Tpng", "-o", direccionPng, direccionDot );             
                }
                
                pbuilder.redirectErrorStream( true );
                //Ejecuta el proceso
                pbuilder.start();
                System.out.println("\nGrafica  creada con exito");
                //String[] command = {"cmd","/c","start","Visualizador de fotos de Windows",  archivo.getAbsolutePath() };
                //Process process = Runtime.getRuntime().exec(command);
               
            } catch (Exception e) {
                e.printStackTrace(); 
            }
	}
}
