package ejercicio3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesHospitalEspecialidad {
    private Especialidad especialidad;
    private Hospital hospital;
    private List<Hospital> listaHospital;

    public OperacionesHospitalEspecialidad() {
        listaHospital=new ArrayList<>();
    }
    Scanner leer=new Scanner(System.in);
    
    public void crearHospital(){
        hospital=new Hospital();
        System.out.println("Digite nombre del Hospital: ");
        hospital.setNombre(leer.nextLine());
        System.out.println("Digite direccion del hospital: ");
        hospital.setDireccion(leer.nextLine());
        System.out.println("Digite nivel del hospital(1°,2°,3°,4°): ");
        hospital.setNivel(leer.nextInt());
        listaHospital.add(hospital);
        guardarObjetos();
        System.out.println("*** Hospital creado ***");
    }
    
    public void mostrarHospital(){
        if (listaHospital.size()>0) {
            for(Hospital hosp:listaHospital){
                System.out.println("------------lista Hospirales-----------");
                hosp.mostrar();
                System.out.println("---------------------------------------");
            }
        }else{
            System.out.println("No tiene registrado ningun hospital");
        }
    }
    
    public void crearEspecialidad(){
        int sw=0;
        if (listaHospital.size()>0) {
            System.out.println("Digite nombre del hospital: ");
            String nom=leer.nextLine();
            for(Hospital hosp:listaHospital){
                if (nom.equalsIgnoreCase(hosp.getNombre())) {
                    sw=1;
                    System.out.println("Hospital encontrado!...");
                    especialidad=new Especialidad();
                    System.out.println("Digite nombre de la especialidad: ");
                    especialidad.setNomEspecialidad(leer.next());
                    //registrando la especialidad en la lista de especialidades del hospital
                    hosp.adicionarEspecialidad(especialidad);
                    guardarObjetos();
                    leer.nextLine();
                }
            }
            if(sw==0){
                System.out.println("No tiene ningun hospital registrado con nombre "+nom);
            }
        }else{
            System.out.println("no tiene agregado ningun hospital");
        }
    }
    
    public void hospitalesEspecialidad(){
        int sw=0;
        if (listaHospital.size()>0) {
            System.out.println("Digite la especialidad: ");
            String esp=leer.nextLine();
            for(Hospital hosp:listaHospital){
                for(int i=0;i<hosp.getListaEspecialidad().size();i++){
                    //System.out.println("    "+hosp.getListaEspecialidad().get(i).getNomEspecialidad());
                    if (esp.equalsIgnoreCase(hosp.getListaEspecialidad().get(i).getNomEspecialidad())){
                        System.out.println("---------------------------------------");
                        System.out.println("encontrado");
                        System.out.println("Hospital: "+hosp.getNombre());
                        System.out.println(hosp.getListaEspecialidad().get(i).getNomEspecialidad());
                        System.out.println("---------------------------------------");
                        sw=1;
                    }
                }
            }
            if(sw==0){
                System.out.println("Especialidad no encontrada");
            }
        }else{
            System.out.println("Lista de hospitales vacia!...");
        }
    }
    
    public void especialidadesHospital(){
        int sw=0;
        if (listaHospital.size()>0) {
            System.out.println("Digite el nombre del hospital: ");
            String esp=leer.nextLine();
            for(Hospital hosp:listaHospital){
                if(hosp.getNombre().equalsIgnoreCase(esp)){
                    sw=1;
                    System.out.println("*** Hospital encontrado ***");
                    hosp.mostrar();
                }
            }
            if(sw==0){
                System.out.println("*** Hospital no encotrado ***");
            }
        }else{
            System.out.println("Lista de hospitales vacia");
        }
    }
    
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-mananejoArchivos-1b\\archivoHospital.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }else{
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
        }
    }
    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetos(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-mananejoArchivos-1b\\archivoHospital.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaHospital);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerListaHospital(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-mananejoArchivos-1b\\archivoHospital.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaHospital=(List<Hospital>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesHospitalEspecialidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
