/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

/**
 *
 * @author User
 */
public class Nodo {

    public int paso;
    public Nodo siguiente;
    public String direccion;

    public Nodo(int paso, String direccion) {
        this.direccion = direccion;
        this.paso = paso;
        siguiente = null;
    }

}
