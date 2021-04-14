package ejercicio1;

import java.util.Scanner;
/**
 *
 * @author david
 */
public class principalDocenteMateria {
    public static void main(String[] args) {
        int opc = 0;
        boolean continuar = true;
        OperacionesDocenteMateria obj = new OperacionesDocenteMateria();
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear archivo");
            System.out.println("2. Registrar docente");
            System.out.println("3. Registrar materia");
            System.out.println("4. Asignar materia a docente");
            System.out.println("5. Mostrar Datos"); 
            System.out.println("6. salir");
            System.out.println("Digite una opcion");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearDocente(); 
                    break;
                case 3:
                    obj.crearMateria();
                    break;
                case 4:
                    obj.asignarMateriaDocente();
                    break;
                case 5:
                    obj.leerClientes();
                    obj.mostrarDocente();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
}
