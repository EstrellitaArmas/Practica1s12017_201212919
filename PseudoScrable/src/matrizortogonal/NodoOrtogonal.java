/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizortogonal;

import javax.swing.JLabel;

/**
 *
 * @author estre
 */
public class NodoOrtogonal {
    
    NodoOrtogonal nodoDer, nodoIzq, nodoArriba, nodoAbajo;
    NodoCabeceras primeroX, primeroY;
    
    int x,y;
    String letra;
    JLabel lblLetra;

    public NodoOrtogonal(int x , int y, String letra , int dimension) {
        this.x = x;
        this.y = y;
        this.letra = letra;
        this.lblLetra = new JLabel(letra);
        lblLetra.setLocation(((648/dimension)*x),((485/dimension)*y));
        lblLetra.setVisible(true);        
        this.nodoAbajo= null;
        this.nodoArriba= null;
        this.nodoIzq = null;
        this.nodoDer = null;
    }

}
    

