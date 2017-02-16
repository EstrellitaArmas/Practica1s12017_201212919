/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacircularjugadores;

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
     public int getTamanio(){
        return tamanio;
    }
     
    public void agregarAlFinal(String nombre){
        // Define un nuevo nodo.
        NodoJugador nuevo = new NodoJugador(nombre);
        // Agrega al valor al nodo.
        //nuevo.setValor(valor);
        // Consulta si la lista esta vacia.
        if(!buscar(nombre)){        
            if (esVacia()) {
                // Inicializa la lista agregando como inicio al nuevo nodo.
                inicio = nuevo;
                // De igual forma el ultimo nodo sera el nuevo.
                ultimo = nuevo;
                // Y el puntero del ultimo debe apuntar al primero.
                //ultimo.setSiguiente(inicio);
                ultimo.siguiente = inicio;
            // Caso contrario el nodo se agrega al final de la lista.
            } else{
                // Apuntamos con el ultimo nodo de la lista al nuevo.
                ultimo.siguiente= nuevo;
                //ultimo.setSiguiente(nuevo);
                // Apuntamos con el nuevo nodo al inicio de la lista.
                nuevo.siguiente= inicio;
                //nuevo.setSiguiente(inicio);
                // Como ahora como el nuevo nodo es el ultimo se actualiza
                // la variable ultimo.
                ultimo = nuevo;
            }
            // Incrementa el contador de tamaño de la lista
            tamanio++;
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
                    aux = aux.siguiente;
                }
            }while(aux != inicio && encontrado != true);
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }
    public void listar(){
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
                aux = aux.siguiente;
                // Incrementa el contador de la posión.
                i++;
            }while(aux != inicio);
        }
    }
    
    
    
    
     
     
}
