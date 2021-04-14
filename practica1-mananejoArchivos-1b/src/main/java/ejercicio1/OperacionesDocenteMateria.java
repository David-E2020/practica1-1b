package ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class OperacionesDocenteMateria {
    
    //List<Docente> listaDocentes;
    Scanner leer=new Scanner(System.in);
    //public OperacionesDocenteMateria() {
    //    listaDocentes=new ArrayList<>();
    
    //}
    
    
    Docente docente=new Docente();
    //private Docente docente;
    private Materia materia;
    
    public void crearDocente(){
        docente=new Docente();
        System.out.println("Digite nombre: ");
        docente.setNombre(leer.nextLine());
        System.out.println("Digite apellido paterno: ");
        docente.setPaterno(leer.nextLine());
        System.out.println("Digite apellido materno: ");
        docente.setMaterno(leer.nextLine());
        System.out.println("Digite titulo: ");
        docente.setTitulo(leer.nextLine());
        System.out.println("Digite la carga horaria: ");
        docente.setCargaHoraria(leer.nextInt());
        leer.nextLine();
        System.out.println("Docente registrado!....");
    }
    
    public void mostrarDocente(){
        if (docente!=null) {
            docente.mostrar();
        }
    }
    
    public void crearMateria(){
        materia=new Materia();
        System.out.println("Digite el nombre de la materia: ");
        materia.setNombreMateria(leer.nextLine());
        System.out.println("Digite el año de la materia: ");
        materia.setAñoMateria(leer.nextInt());
        System.out.println("Digite horas de la materia: ");
        materia.setHoraMateria(leer.nextInt());
        leer.nextLine();
        System.out.println("Materia registrada!...");
    }
    
    public void mostrarMateria(){
        if (materia!=null) {
            materia.mostrar();
        }
    }
    
    public void asignarMateriaDocente(){
        
        if (docente!=null && materia!=null) {
            docente.setListaMaterias(materia);
            System.out.println("Asignacion realizada!...");
            docente.mostrar();
            guardarObjetos();
        }
    }
    
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-mananejoArchivos-1b\\archivoDocente.txt");
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
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-mananejoArchivos-1b\\archivoDocente.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(docente);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerClientes(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-mananejoArchivos-1b\\archivoDocente.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                docente=(Docente)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

