/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircularjugadores;

import Listaletras.NodoLetra;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author estre
 */
public class ListaJugadores {
    private NodoJugador inicio;
    private NodoJugador ultimo;
    private int tamanio;
    
    public ListaJugadores(){
        inicio = null;
        ultimo = null;
        tamanio = 0;
    }    
    public boolean esVacia(){
        return inicio == null;
    }
   
    public NodoJugador buscarJugador(String referencia){
          // Crea una copia de la lista.
        NodoJugador aux = inicio;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al primer nodo nuevamente.
        if(!esVacia()){
            do{
                // Consulta si el valor del nodo es igual al de referencia.
                if (referencia.equals(aux.nombre)){
                    // Canbia el valor de la bandera.
                    return aux;
                }
                else{
                    // Avansa al siguiente. nodo.
                    aux = aux.nodoDer;
                }
            }while(aux != inicio);
        }
        // Retorna el resultado de la bandera.
        return null;
    }
    public void agregarAlFinal(String nombre){
        // Define un nuevo nodo.
        NodoJugador nuevo = new NodoJugador(nombre); 
        
        // Consulta si la lista esta vacia.
        if(!buscar(nombre)){        
            if (esVacia()) {
                // Inicializa la lista agregando como inicio al nuevo nodo.
                inicio = nuevo;
                // De igual forma el ultimo nodo sera el nuevo.
                ultimo = nuevo;
                // Y el puntero del ultimo debe apuntar al primero.
                //ultimo.setSiguiente(inicio);
                ultimo.nodoDer = inicio;
            // Caso contrario el nodo se agrega al final de la lista.
            } else{
                // Apuntamos con el ultimo nodo de la lista al nuevo.
                ultimo.nodoDer= nuevo;
                //ultimo.setSiguiente(nuevo);
                // Apuntamos con el nuevo nodo al inicio de la lista.
                nuevo.nodoDer= inicio;
                //nuevo.setSiguiente(inicio);
                // Como ahora como el nuevo nodo es el ultimo se actualiza
                // la variable ultimo.
                ultimo = nuevo;
            }
            // Incrementa el contador de tamaño de la lista
            tamanio++;
        }else{
            JOptionPane.showMessageDialog(null, "El jugador ya existe, ingrese otro nombre");
        }
    }
    public boolean buscar(String referencia){
        // Crea una copia de la lista.
        NodoJugador aux = inicio;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al primer nodo nuevamente.
        if(!esVacia()){
            do{
                // Consulta si el valor del nodo es igual al de referencia.
                if (referencia.equals(aux.nombre)){
                    // Canbia el valor de la bandera.
                    encontrado = true;
                }
                else{
                    // Avansa al siguiente. nodo.
                    aux = aux.nodoDer;
                }
            }while(aux != inicio && encontrado != true);
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }
    public void listarJugadores(){
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            NodoJugador aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            System.out.print("-> ");
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.nombre + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.nodoDer;
                // Incrementa el contador de la posión.
                i++;
            }while(aux != inicio);
        }
    }
    public void grafoMano(String nombre){
        // Verifica si la lista contiene elementoa.
        NodoJugador nodoAux = buscarJugador(nombre);
        if (!esVacia()&& nodoAux!=null) {
            // Crea una copia de la lista.            
            NodoLetra aux = nodoAux.manoJuego;
            // Posicion de los elementos de la lista.
            String grafoTxt = "";
            int i = 0;
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                grafoTxt = grafoTxt + i +"[label=\""+aux.letra +"\"];\n";                 
                // Avanza al siguiente nodo.
                aux = aux.nodoDer;
                // Incrementa el contador de la posión.
                i++;
            }while(aux != null);
            i=0;
            aux = nodoAux.manoJuego;
            grafoTxt = grafoTxt + nodoAux.nombre+ " -> " ;
            do{
                if(aux.nodoDer != null){
                   //nodo = nodo + (idNodo++) +"[label=\""+letra +"\"];\n"; 
                   grafoTxt = grafoTxt + i + " -> "; 
                }else{
                    grafoTxt = grafoTxt + i +"\n";
                }  
                // Avanza al siguiente nodo.
                aux = aux.nodoDer;
                // Incrementa el contador de la posión.
                i++;
            }while(aux != null);
            System.out.println(grafoTxt);
            GenerarImagen(grafoTxt, "grafoMano");
        }
    }
    public void grafoJugador(){
           if (!esVacia()) {
            // Crea una copia de la lista.
            NodoJugador aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            String str ="\n";
           
            // Recorre la lista hasta llegar nuevamente al incio de la lista.
            do{
                // Imprime en pantalla el valor del nodo.
                str = str  + aux.nombre +  " ->  ";
                // Avanza al siguiente nodo.
                aux = aux.nodoDer;
                // Incrementa el contador de la posión.
                i++;
            }while(aux != inicio);
            if(aux==inicio){
                str = str  + aux.nombre ;
            }
            GenerarImagen(str,"grafoJugadores");
        }
        
    }
     public void GenerarImagen(String nodos, String nombreImagen){
         String rutaArchivo;
         String rutaImagen;
         String texto= "digraph G{ \n " +nodos+"  \n }  " ;
            rutaArchivo = nombreImagen +".dot";
            rutaImagen = nombreImagen +".png";
         
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
