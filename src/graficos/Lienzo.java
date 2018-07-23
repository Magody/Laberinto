/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

/**
 *
 * @author User
 */
public class Lienzo extends Canvas{
    
    
    public Lienzo(Teclado teclado){
        setIgnoreRepaint(true); //ignora repintado, mejora rendimiento
        this.setPreferredSize(new Dimension(800,400));
        this.addKeyListener(teclado);
        setFocusable(true);
        requestFocus(); //selecciona la ventana en primer plano
    }
    
    public void dibujar(int[][] laberinto){
        BufferStrategy buffer = getBufferStrategy();
        
        if(buffer == null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = buffer.getDrawGraphics();
                
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        
        int cuadrado = 40;
        for(int i=0; i<laberinto.length;i++){
            for(int j=0;j<laberinto[0].length;j++){
                
                if(laberinto[i][j] == 1){
                    
                    g.setColor(Color.black);
                    g.fillRect(j*cuadrado, i*cuadrado, cuadrado, cuadrado);
                    
                    g.setColor(Color.red);
                    g.drawRect(j*cuadrado, i*cuadrado, cuadrado, cuadrado);
                    
                    
                }
                else if(laberinto[i][j] == 2){
                    g.setColor(Color.green);
                    g.fillArc(j*cuadrado, i*cuadrado, cuadrado, cuadrado,0,320);
                }
                else if(laberinto[i][j] == 3){
                    g.setColor(Color.YELLOW);
                    g.fillOval(j*cuadrado, i*cuadrado, cuadrado, cuadrado);
                }
                else if(laberinto[i][j] == 0){
                    g.setColor(Color.GRAY);
                    g.fillRect(j*cuadrado, i*cuadrado, cuadrado, cuadrado);
                    
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(j*cuadrado+10, i*cuadrado+10, cuadrado-20, cuadrado-20);
                    
                    g.setColor(Color.white);
                    g.drawRect(j*cuadrado, i*cuadrado, cuadrado, cuadrado);
                }
                
                
            }
        }
        
        Toolkit.getDefaultToolkit().sync(); //lo hace un poco más fluido
        g.dispose();
        buffer.show();
    }
    
}
