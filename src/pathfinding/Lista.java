/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import java.util.ArrayList;
import java.util.Collections;


public class Lista {
    
    public static Lista camino_corto;
    
    public Nodo inicio,fin;
    public int paso = 0;
    
    public ArrayList<Integer> posicionx_visitada = new ArrayList<>();
    public ArrayList<Integer> posiciony_visitada = new ArrayList<>();

    public Lista() {
        inicio = null;fin = null;
        
    }
    public Lista(Lista lista) {
        Nodo p = lista.inicio;
        while(p!=null){
            this.insertar(p.direccion);
            p = p.siguiente;
        }
        for(Integer i: lista.posicionx_visitada){
            this.posicionx_visitada.add(i);
        }
        for(Integer i: lista.posiciony_visitada){
            this.posiciony_visitada.add(i);
        }
        
        
    }
    
    
    
    
    public static int pasos_minimos = 1000;
    
    public void insertar(String direccion){
        
        if(inicio == null){
            inicio = new Nodo(paso++, direccion);
            fin = inicio;
        }
        else{
            fin.siguiente = new Nodo(paso++, direccion);
            fin = fin.siguiente;
        }
    }

    @Override
    public String toString() {
        String salida = "";
        Nodo p = inicio;
        while(p!= null){
            salida += p.direccion + " ";
            p = p.siguiente;
        }
        
        return salida;
    }
    
    
    
    
}
