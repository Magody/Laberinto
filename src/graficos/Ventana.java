/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Ventana extends JFrame{
    
    
    public Ventana(Lienzo lienzo){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(800,620));
        this.add(lienzo);
        this.pack();
    }
    
}
