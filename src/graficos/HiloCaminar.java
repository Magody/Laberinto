/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.util.logging.Level;
import java.util.logging.Logger;
import pathfinding.App;
import pathfinding.Lista;
import pathfinding.Nodo;

public class HiloCaminar implements Runnable{
    
    
    Lista pasos;
    int delay;
    Lienzo lienzo;
    
    @Override
    public void run(){
        
        Nodo p = pasos.inicio;
        
       
        while(p!=null){
            
            try {
                Thread.sleep(delay);
                if(p.direccion.compareToIgnoreCase("↑") == 0){
                    App.laberinto[App.pjfila][App.pjcol] = 1;
                    App.laberinto[--App.pjfila][App.pjcol] = 2;
                }
                else if(p.direccion.compareToIgnoreCase("↓") == 0){
                    App.laberinto[App.pjfila][App.pjcol] = 1;
                    App.laberinto[++App.pjfila][App.pjcol] = 2;
                }
                else if(p.direccion.compareToIgnoreCase("→") == 0){
                    App.laberinto[App.pjfila][App.pjcol] = 1;
                    App.laberinto[App.pjfila][++App.pjcol] = 2;
                }
                else if(p.direccion.compareToIgnoreCase("←") == 0){
                    App.laberinto[App.pjfila][App.pjcol] = 1;
                    App.laberinto[App.pjfila][--App.pjcol] = 2;
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloCaminar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            p = p.siguiente;
        }
        
    }

    public HiloCaminar(Lista pasos,int delay,Lienzo lienzo) {
        this.pasos = pasos;
        this.delay = delay/2;
        this.lienzo = lienzo;
        
    }
    
    
    
}
