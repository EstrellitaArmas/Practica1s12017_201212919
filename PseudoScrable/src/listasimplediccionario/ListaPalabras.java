/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimplediccionario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.println(str);
            //JOptionPane.showMessageDialog(null, str);
        }
    }
    
    public void generarGrafoTxt(){
           if(tamano != 0) {
            NodoPalabra temp = primero;
            String str = "";
            for(int i = 0; i < this.tamano; i++) {
                //node1 -> node2
                if(temp.nodoDer != null){
                   
                   str = str + temp.palabra + "->"; 
                }else{
                    str = str + temp.palabra + ";\n"; 
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
            rutaArchivo = "grafoPalabras.dot";
            rutaImagen = "grafoPalabras.png";
         
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
