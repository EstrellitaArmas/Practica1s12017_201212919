/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudoscrable;

/**
 *
 * @author estre
 */
public class Hilo extends Thread {
     private Thread hilo;
  private String nombreHilo;
  Reportes reporte;

  Hilo(String nombre, Reportes reporte){
    nombreHilo = nombre;
    this.reporte= reporte;
    System.out.println("Creando " + nombreHilo);
  }
    @Override
    public void run(){
        System.out.println("Ejecutando " + nombreHilo );
    try {
      for(int i = 4; i > 0; i--) {
        System.out.println("Hilo: " + nombreHilo + ", " + i);
        reporte.repaint();
        // vamos a dormir el hilo unos 50s
        Thread.sleep(50);
      }
    } catch (InterruptedException e) {
      System.out.println("Hilo " + nombreHilo + " interrumpido.");
    }
    System.out.println("Hilo " + nombreHilo + " termino.");
  }

  public void start () {
    System.out.println("Iniciando " + nombreHilo );
    if (hilo == null) {
      hilo = new Thread (this, nombreHilo);
      hilo.start ();
    }
  }
}
    

