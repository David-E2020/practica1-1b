/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class principalAlbumCancion {
    public static void main(String[] args) {
        int opc = 0;
        boolean continuar = true;
        Scanner leer=new Scanner(System.in);
        operacionesAlbumCancion obj = new operacionesAlbumCancion();
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear archivo");
            System.out.println("2. Crear Album y agregar canciones");
            System.out.println("3. Buscar una cancion");
            System.out.println("4. Mostrar las canciones de un album");
            System.out.println("5. Eliminar Album");
            System.out.println("6. Mostrar Datos"); 
            System.out.println("7. salir");
            System.out.println("Digite una opcion");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearAlbum();
                    break;
                case 3:
                    obj.buscarCancion();
                    break;
                case 4:
                    obj.albumCanciones();
                    break;
                case 5:
                    obj.eliminarAlbum();
                    obj.guardarObjetos();
                    break;
                case 6:
                    obj.leerAlbum();
                    obj.mostrarListaAlbum();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
}
