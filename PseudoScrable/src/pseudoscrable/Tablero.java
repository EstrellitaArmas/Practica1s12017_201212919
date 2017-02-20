/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pseudoscrable;

import Listaletras.ColaLetras;
import Listaletras.NodoLetra;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import listacircularjugadores.ListaJugadores;
import listasimplediccionario.ListaPalabras;
import Listaletras.ListaMano;
import java.awt.Image;
import javax.swing.Icon;
import matrizortogonal.MatrizOrtogonal;

/**
 *
 * @author estre
 */
public class Tablero extends javax.swing.JFrame {
    
    ListaPalabras listaPalabras;
    ListaJugadores listaJugadores;
    
    ColaLetras colaLetras = new ColaLetras();
    
    
    
    public Tablero() {   }

    public Tablero(ListaPalabras listaPalabras, ListaJugadores listaJugadores) {
      this.listaPalabras = listaPalabras;
      this.listaJugadores = listaJugadores;
      colaLetrasLlenado();      
      colaLetras.generarGrafoTxt();
      listaPalabras.generarGrafoTxt();
      listaJugadores.grafoJugador();   
      initComponents();
     imagenes();
     this.repaint();
      
    }  
    private void imagenes(){
        //Imagenes en el tablero
        
    JLabel grafoPalabrasPNG = new JLabel(" ");
    JLabel grafoJugadoresPNG = new JLabel(" ");
    JLabel grafoLetrasPNG = new JLabel(" ");
    JLabel grafoManoPNG = new JLabel(" ");
    JLabel grafoTableroPNG = new JLabel(" ");
    
        ImageIcon imageTablero = new ImageIcon("grafoTablero.png");
        panelTablero.add(grafoTableroPNG);
        grafoTableroPNG.setIcon(imageTablero);
        grafoTableroPNG.setSize(450,1000);
        grafoTableroPNG.setLocation(0,0);
        grafoTableroPNG.setVisible(true); 
        
        
        ImageIcon imageMano = new ImageIcon("grafoMano.png");
        panelMano.add(grafoManoPNG);
        grafoManoPNG.setIcon(imageMano);
        grafoManoPNG.setSize(450,1000);
        grafoManoPNG.setLocation(0,0);
        grafoManoPNG.setVisible(true); 
        
        
        //añade imagen de lista de palabras
        
        ImageIcon imagePalabras = new ImageIcon("grafoPalabras.png");
        grafoPalabrasPNG.setIcon(imagePalabras);
        grafoPalabrasPNG.setSize(450,1000);
        grafoPalabrasPNG.setLocation(0,0);
        grafoPalabrasPNG.setVisible(true); 
        panelPalabras.add(grafoPalabrasPNG);
        
        
        //añade imagen de lista de jugadores        
        ImageIcon imageJugador = new ImageIcon("grafoJugadores.png");
        grafoJugadoresPNG.setIcon(imageJugador);
        grafoJugadoresPNG.setSize(450,1000);
        grafoJugadoresPNG.setLocation(0,0);
        grafoJugadoresPNG.setVisible(true); 
        panelJugadores.add(grafoJugadoresPNG); 
         
        //añade imagen de lista de jugadores        
        ImageIcon imageLetras = new ImageIcon("grafoColaLetras.png");
        //ImageIcon fot = new ImageIcon(path_ala_imagen);        
        grafoLetrasPNG.setIcon(imageLetras);
        grafoLetrasPNG.setSize(450,500);
        grafoLetrasPNG.setLocation(0,0);
        grafoLetrasPNG.setVisible(true);
        panelLetras.add(grafoLetrasPNG); 
        
        
    }
    private void  colaLetrasLlenado(){      
            int contador =0; 
       while(contador<95){    
            int random = (int) (Math.random() * 25); 
            switch (random){
                case 0 : // A 
                        if(colaLetras.buscar("A")<12){
                            colaLetras.addLast("A",1 );
                            contador++;
                            //return true;
                        }break;
                case 1: // B 
                        if(colaLetras.buscar("B")<2){
                            colaLetras.addLast("B",3);
                            contador++;
                        }break;
                case 2: //C
                        if(colaLetras.buscar("C")<4){
                            colaLetras.addLast("C", 3);
                            contador++;
                        }break;
                case 3: //D
                        if(colaLetras.buscar("D")<5){
                            colaLetras.addLast("D",2);
                            contador++;
                        }break;
                case 4: //E
                        if(colaLetras.buscar("E")<12){
                            colaLetras.addLast("E",1);
                            contador++;
                        }break;
                case 5: //F
                        if(colaLetras.buscar("F")<1){
                            colaLetras.addLast("F",4);
                            contador++;
                        }break;
                case 6: //G
                        if(colaLetras.buscar("G")<2){
                            colaLetras.addLast("G",2);
                            contador++;
                        }break;
                case 7: //H
                        if(colaLetras.buscar("H")<2){
                            colaLetras.addLast("H",4);
                           contador++;
                        }break;
                case 8: //I
                       if(colaLetras.buscar("I")<6){
                            colaLetras.addLast("I",1);
                            contador++;
                        }break;
                case 9: //J
                        if(colaLetras.buscar("J")< 1){
                            colaLetras.addLast("J",8);
                            contador++;
                        }break;
                case 10: //L
                        if(colaLetras.buscar("L")<4){
                            colaLetras.addLast("L",1);
                           contador++;
                        }break;
                case 11: //M
                        if(colaLetras.buscar("M")<2){
                            colaLetras.addLast("M",3);
                            contador++;
                        }
                        break;
                case 12: //N
                        if(colaLetras.buscar("N")<5){
                            colaLetras.addLast("N",1);
                            contador++;
                        }
                        break;
                case 13: //Ñ
                        if(colaLetras.buscar("Ñ")<1){
                            colaLetras.addLast("Ñ",8);
                           contador++;
                        }
                        break;
                case 14: //O
                        if(colaLetras.buscar("O")<9){
                            colaLetras.addLast("O",1);
                            contador++;
                        }
                        break;
                case 15: //P
                    if(colaLetras.buscar("P")<2){
                            colaLetras.addLast("P",3);
                           contador++;
                        }
                    break;
                case 16: //Q
                    if(colaLetras.buscar("Q")<1){
                            colaLetras.addLast("Q",5);
                            contador++;
                        }
                    break;
                case 17: //R
                    if(colaLetras.buscar("R")<5){
                            colaLetras.addLast("R",1);
                            contador++;
                        }
                    break;
                case 18: //S
                    if(colaLetras.buscar("S")<6){
                            colaLetras.addLast("S",1);
                            contador++;
                        }
                    break;
                case 19: //T
                    if(colaLetras.buscar("T")<4){
                            colaLetras.addLast("T",1);
                           contador++;
                        }
                    break;
                case 20: //U
                    if(colaLetras.buscar("U")<5){
                            colaLetras.addLast("U",1);
                            contador++;                      
                    }break;
                case 21: //V
                    if(colaLetras.buscar("V")<1){
                            colaLetras.addLast("V",4);
                            contador++;
                        }break;
                case 22: //X
                    if(colaLetras.buscar("X")<1){
                            colaLetras.addLast("X",8);
                           contador++;
                        }break;
                case 23: //Y
                    if(colaLetras.buscar("Y")<1){
                            colaLetras.addLast("Y",4);
                            contador++;
                    } 
                case 24: //Z
                    if(colaLetras.buscar("Z")<1){
                            colaLetras.addLast("Z",10);
                            contador++;
                        }
                    break;
                default: System.out.println("no se pudo agregar "+ random);
            }
        }
    }
    
    private void llenadoMano (String nombre){
       ListaMano manoJugador = new ListaMano();
       
        for(int i= 0; i<7;i++){
            NodoLetra nodoLetra = colaLetras.deleteFirst();
            manoJugador.addLast(nodoLetra.letra,nodoLetra.puntos);  
            listaJugadores.buscarJugador(nombre).manoJuego = manoJugador.primero ;
        } 
      manoJugador.imprimir();
      listaJugadores.grafoMano(nombre);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabPanels = new javax.swing.JTabbedPane();
        panelJugadores = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();
        panelMano = new javax.swing.JPanel();
        panelPalabras = new javax.swing.JPanel();
        panelLetras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        l_jugadores = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnAgregarPalabra = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        btnCambiarLetra = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnValidar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanels.setAutoscrolls(true);

        javax.swing.GroupLayout panelJugadoresLayout = new javax.swing.GroupLayout(panelJugadores);
        panelJugadores.setLayout(panelJugadoresLayout);
        panelJugadoresLayout.setHorizontalGroup(
            panelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panelJugadoresLayout.setVerticalGroup(
            panelJugadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        tabPanels.addTab("Jugadores", panelJugadores);

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        tabPanels.addTab("Tablero", panelTablero);

        javax.swing.GroupLayout panelManoLayout = new javax.swing.GroupLayout(panelMano);
        panelMano.setLayout(panelManoLayout);
        panelManoLayout.setHorizontalGroup(
            panelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panelManoLayout.setVerticalGroup(
            panelManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        tabPanels.addTab("Mano del jugador", panelMano);

        javax.swing.GroupLayout panelPalabrasLayout = new javax.swing.GroupLayout(panelPalabras);
        panelPalabras.setLayout(panelPalabrasLayout);
        panelPalabrasLayout.setHorizontalGroup(
            panelPalabrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panelPalabrasLayout.setVerticalGroup(
            panelPalabrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        tabPanels.addTab("Diccionario de Palabras", panelPalabras);

        javax.swing.GroupLayout panelLetrasLayout = new javax.swing.GroupLayout(panelLetras);
        panelLetras.setLayout(panelLetrasLayout);
        panelLetrasLayout.setHorizontalGroup(
            panelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panelLetrasLayout.setVerticalGroup(
            panelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );

        tabPanels.addTab("Letras", panelLetras);

        jLabel1.setText("TURNO DE:");

        jLabel2.setText("--------");

        jLabel3.setText("PUNTUACION");

        l_jugadores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(l_jugadores);

        jLabel4.setText("NUEVA PALABRA");

        btnAgregarPalabra.setText("Agregar");

        jLabel5.setText("CAMBIAR LETRAS");

        jCheckBox1.setText("jCheckBox1");

        jCheckBox2.setText("jCheckBox2");

        jCheckBox3.setText("jCheckBox3");

        jCheckBox4.setText("jCheckBox4");

        jCheckBox5.setText("jCheckBox5");

        jCheckBox6.setText("jCheckBox6");

        jCheckBox7.setText("jCheckBox7");

        btnCambiarLetra.setText("CAMBIAR");
        btnCambiarLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarLetraActionPerformed(evt);
            }
        });

        jLabel6.setText("LETRAS ACTIVAS");

        btnValidar.setText("VALIDAR TIRO");
        btnValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR TIRO");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 644, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(btnValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox7))
                            .addComponent(jCheckBox4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarPalabra)
                                    .addComponent(btnCambiarLetra))))
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarPalabra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCambiarLetra))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnValidar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(tabPanels)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarActionPerformed
        llenadoMano("luis");
      // HiloGraficas hilo= new HiloGraficas(this);
       listaPalabras.generarGrafoTxt();
       listaJugadores.grafoJugador();  
       
       imagenes();
       
       this.repaint();
       // hilo.start();
    }//GEN-LAST:event_btnValidarActionPerformed

    private void btnCambiarLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarLetraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarLetraActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MatrizOrtogonal tablero  = new MatrizOrtogonal();
        for(int i = 0 ; i<5 ; i++){
            for(int j= 0; j<5 ; i++){
             tablero.insertar_nodo(i, j , "letra", 5 );   
            }
        }
        tablero.recorrer_matriz();
       
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPalabra;
    private javax.swing.JButton btnCambiarLetra;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnValidar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> l_jugadores;
    public javax.swing.JPanel panelJugadores;
    private javax.swing.JPanel panelLetras;
    public javax.swing.JPanel panelMano;
    public javax.swing.JPanel panelPalabras;
    public javax.swing.JPanel panelTablero;
    public javax.swing.JTabbedPane tabPanels;
    // End of variables declaration//GEN-END:variables
}
