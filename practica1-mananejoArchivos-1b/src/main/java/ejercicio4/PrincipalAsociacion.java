package ejercicio4;
import java.util.Scanner;
public class PrincipalAsociacion {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        OperacionesDiscoDuro operaciones=new OperacionesDiscoDuro();
        boolean continuar=true;
        int op;
        do {
            System.out.println("------MENU------");
            System.out.println("1. Creamos archivo");
            System.out.println("2. Añadir disco duro");
            System.out.println("3. Mostrar disco duro");
            System.out.println("4. Añadir archivos al disco duro");
            System.out.println("5. Eliminar archivos del disco duro");
            System.out.println("6. Salir");
            System.out.println("Digite su opcion: ");
            op=leer.nextInt();
            switch (op) {
                case 1:operaciones.crearArchivo();break;
                case 2:operaciones.crearDiscoDuro();break;
                case 3:operaciones.mostrarDiscoDuro();break;
                case 4:operaciones.crearArchivoDisco();break;
                case 5:operaciones.eliminarArchivo();break;
                default:continuar=false;
            }
        } while (continuar);
        
    }
}
