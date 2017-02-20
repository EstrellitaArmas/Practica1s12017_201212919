/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudoscrable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author estre
 */
public class Reportes  extends JFrame{
 
    public Reportes(){
 
        //Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setTitle("Reportes");
 
        //Creamos el conjunto de pestañas
        JTabbedPane pestañas=new JTabbedPane();
        
       
        //Creamos el panel y lo añadimos a las pestañas
        JPanel panel1=new JPanel(); 
        //Componentes del panel1
        JLabel et_p1=new JLabel("");
        ImageIcon imageJugadores = new ImageIcon("grafoJugadores.png");
        et_p1.setIcon(imageJugadores);
        et_p1.setSize(450,1000);
        et_p1.setLocation(0,0);
        et_p1.setVisible(true); 
        panel1.add(et_p1); 
        //Añadimos un nombre de la pestaña y el panel
        pestañas.addTab("Jugadores", panel1);
 
        //Realizamos lo mismo con el resto
        JPanel panel2=new JPanel();                
        //Componentes del panel2
        JLabel et_p2=new JLabel("");        
        ImageIcon imageMano = new ImageIcon("grafoMano.png");
        et_p2.setIcon(imageMano);
        et_p2.setSize(450,1000);
        et_p2.setLocation(0,0);
        et_p2.setVisible(true); 
        panel2.add(et_p2);
        pestañas.addTab("Mano del Jugador", panel2); 
        
        JPanel panel3=new JPanel(); 
        //Componentes del panel3
        JLabel et_p3=new JLabel("");        
        ImageIcon imageLetras = new ImageIcon("grafoColaLetras.png");
        et_p3.setIcon(imageLetras);
        et_p3.setSize(450,1000);
        et_p3.setLocation(0,0);
        et_p3.setVisible(true); 
        panel3.add(et_p3); 
        pestañas.addTab("Cola de letras", panel3);
 
        JPanel panel4=new JPanel(); 
        //Componentes del panel4
        JLabel et_p4=new JLabel("");        
        ImageIcon imageTablero = new ImageIcon("grafoTablero.png");
        et_p4.setIcon(imageTablero);
        et_p4.setSize(450,1000);
        et_p4.setLocation(0,0);
        et_p4.setVisible(true); 
        panel4.add(et_p4); 
        pestañas.addTab("Tablero", panel4);
        
        JPanel panel5=new JPanel(); 
        //Componentes del panel4
        JLabel et_p5=new JLabel("");        
        ImageIcon imagePalabras = new ImageIcon("grafoPalabras.png");
        et_p5.setIcon(imagePalabras);
        et_p5.setSize(450,1000);
        et_p5.setLocation(0,0);
        et_p5.setVisible(true); 
        panel5.add(et_p5); 
        pestañas.addTab("Diccionario", panel5);
 
        getContentPane().add(pestañas);
    }
}
