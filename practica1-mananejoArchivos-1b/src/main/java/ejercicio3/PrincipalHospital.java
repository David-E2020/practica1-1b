package ejercicio3;

import java.util.Scanner;

public class PrincipalHospital {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        OperacionesHospitalEspecialidad obj=new OperacionesHospitalEspecialidad();
        boolean continuar=true;
        int op;
        do {
            System.out.println("------MENU-----");
            System.out.println("1. Crear archivo");
            System.out.println("2. Crear hospital");
            System.out.println("3. Crear especialidad");
            System.out.println("4. Especialidades de de un hospital");
            System.out.println("5. listar hospitales de una determinada especialidad");
            System.out.println("6. Mostrar datos");
            System.out.println("7. Salir");
            System.out.println("Digite una opcion: ");
            op=leer.nextInt();
            switch (op) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearHospital();
                    break;
                case 3:
                    obj.crearEspecialidad();
                    break;
                case 4:
                    obj.especialidadesHospital();
                    break;
                case 5:
                    obj.hospitalesEspecialidad();
                    break;
                case 6:
                    obj.leerListaHospital();
                    obj.mostrarHospital();
                    break;
                default:
                    continuar=false;
            }
        } while (continuar);
        
    }
}
