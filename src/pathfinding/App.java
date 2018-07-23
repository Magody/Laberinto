/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathfinding;

import graficos.HiloCaminar;
import graficos.Lienzo;
import graficos.Teclado;
import graficos.Ventana;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class App {

   
    public static int[][] laberinto
                = {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 3, 0},
                    {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                    {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
                    {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0},
                    {0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                    {0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                    {0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                    {0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                    {0, 2, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
    
    public static int pjfila = 13, pjcol = 1;
    
    public static void main(String[] args) throws InterruptedException {

        //0 = pared, 1 = traspasable, 2 = jugador, 3 = bandera
        

        

        pathFinding(new Lista(), laberinto, pjfila, pjcol);

        if (listas.size() < 10) {
            for (int i = 0; i < listas.size(); i++) {
                System.out.println(listas.get(i));
            }
        }

        System.out.println(Lista.pasos_minimos);

        Teclado teclado = new Teclado();
        Lienzo lienzo = new Lienzo(teclado);
        Ventana ventana = new Ventana(lienzo);
        ventana.setVisible(true);

        int delay = 230;
        
        new Thread(new HiloCaminar(Lista.camino_corto,delay,lienzo)).start();
        
        while (true) {
            lienzo.dibujar(laberinto);
            teclado.actualizar();
/*
            if (teclado.arriba) {
                if (pjfila - 1 >= 0) {
                    if (laberinto[pjfila - 1][pjcol] != 0) {
                        laberinto[pjfila][pjcol] = 1;
                        laberinto[--pjfila][pjcol] = 2;
                        Thread.sleep(delay);
                    }

                }

            } else if (teclado.abajo) {
                if (pjfila + 1 < laberinto.length) {
                    if (laberinto[pjfila + 1][pjcol] != 0) {
                        laberinto[pjfila][pjcol] = 1;
                        laberinto[++pjfila][pjcol] = 2;
                        Thread.sleep(delay);
                    }

                }

            } else if (teclado.izquierda) {
                if (pjcol - 1 >= 0) {
                    if (laberinto[pjfila][pjcol - 1] != 0) {
                        laberinto[pjfila][pjcol] = 1;
                        laberinto[pjfila][--pjcol] = 2;
                        Thread.sleep(delay);
                    }

                }

            } else if (teclado.derecha) {
                if (pjcol + 1 < laberinto[0].length) {
                    if (laberinto[pjfila][pjcol + 1] != 0) {
                        laberinto[pjfila][pjcol] = 1;
                        laberinto[pjfila][++pjcol] = 2;
                        Thread.sleep(delay);
                    }

                }

            }*/
            
            
            
        }

    }

    static ArrayList<Lista> listas = new ArrayList<>();

    public static void pathFinding(Lista lista, int[][] laberinto, int fila, int col) {

        if (laberinto[fila][col] == 3) {
            listas.add(lista);
            if (lista.paso < Lista.pasos_minimos) {
                Lista.pasos_minimos = lista.paso;
                Lista.camino_corto = lista;
            }
        } else if (lista.paso < Lista.pasos_minimos) {
            if (fila - 1 >= 0) {
                if ((laberinto[fila - 1][col] == 1 || laberinto[fila - 1][col] == 3) && !estaVisitado(lista, fila - 1, col)) {
                    //arriba

                    lista.posicionx_visitada.add(fila);
                    lista.posiciony_visitada.add(col);
                    final Lista inicial = new Lista(lista);
                    lista.insertar("↑");
                    pathFinding(lista, laberinto, fila - 1, col);
                    lista = inicial;
                }
            }
            if (fila + 1 < laberinto.length) {
                if ((laberinto[fila + 1][col] == 1 || laberinto[fila + 1][col] == 3) && !estaVisitado(lista, fila + 1, col)) {
                    //abajo

                    lista.posicionx_visitada.add(fila);
                    lista.posiciony_visitada.add(col);
                    final Lista inicial = new Lista(lista);
                    lista.insertar("↓");
                    pathFinding(lista, laberinto, fila + 1, col);
                    lista = inicial;
                }
            }
            if (col - 1 >= 0) {
                if ((laberinto[fila][col - 1] == 1 || laberinto[fila][col - 1] == 3) && !estaVisitado(lista, fila, col - 1)) {
                    //izquierda

                    lista.posicionx_visitada.add(fila);
                    lista.posiciony_visitada.add(col);
                    final Lista inicial = new Lista(lista);
                    lista.insertar("←");
                    pathFinding(lista, laberinto, fila, col - 1);
                    lista = inicial;
                }
            }
            if (col + 1 < laberinto[0].length) {
                if ((laberinto[fila][col + 1] == 1 || laberinto[fila][col + 1] == 3) && !estaVisitado(lista, fila, col + 1)) {
                    //derecha

                    lista.posicionx_visitada.add(fila);
                    lista.posiciony_visitada.add(col);
                    lista.insertar("→");
                    pathFinding(lista, laberinto, fila, col + 1);
                }
            }
        }

    }

    public static boolean estaVisitado(Lista lista, int fila, int columna) {

        boolean condicion = false;

        for (int i = 0; i < lista.posicionx_visitada.size(); i++) {
            if (fila == lista.posicionx_visitada.get(i) && columna == lista.posiciony_visitada.get(i)) {
                condicion = true;
                break;
            }

        }

        return condicion;

    }

}
