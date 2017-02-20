/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listaletras;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

//Metodo para borrar al inicio de la lista.
    public NodoLetra deleteFirst() {
        NodoLetra eliminar = null;
        if(siVacio()) {
            JOptionPane.showMessageDialog(null, "Se acabaron las letras!!!");
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
 
 public int buscar(String referencia){      
        int encontrado=0;              
            NodoLetra aux=primero; 
            while(aux!=null){

                if(aux.letra.equals(referencia)){
                    encontrado++;
                }
                //Actualizamos
                aux=aux.nodoDer;
            }        
        // Retorna el resultado de la bandera.
        return encontrado;
    }
//Metodo que imprime el tamaño de la lista.
    public int tamano() {
       return tamano;
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
            System.out.println(str);
            //JOptionPane.showMessageDialog(null, str);
        }
    }
    
    public void generarGrafoTxt(){
        int contador=0;
        if(tamano != 0) {
            NodoLetra temp = primero;
            String str = "";
            for(int i = 0; i < this.tamano; i++) { 
                str = str + + (contador++) +"[label=\""+temp.letra +"\"];\n"; 
                temp = temp.nodoDer;
            }
            contador = 0;
            temp = primero;
            for(int i = 0; i < this.tamano; i++) {
                //node1 -> node2
                if(temp.nodoDer != null){
                   
                   str = str + (contador++) + "-> "; 
                }else{
                    str = str +(contador++)+ ";\n"; 
                }
                
                temp = temp.nodoDer;
            }
            System.out.println(str); 
            GenerarImagen(str);
        }
        
    }
    public void GenerarImagen(String nodos){
         String rutaArchivo;
         String rutaImagen;
         String texto= "digraph G{ \n " +nodos+"  \n }  " ;
            rutaArchivo = "grafoColaLetras.dot";
            rutaImagen = "grafoColaLetras.png";
         
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

