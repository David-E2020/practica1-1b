package ejercicio4;

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

public class OperacionesDiscoDuro {
    private DiscoDuro discoDuro;
    private Archivo archivo;
    Scanner leer=new Scanner(System.in);
    
    
    public void crearDiscoDuro(){
        discoDuro=new DiscoDuro();
        System.out.println("Digite la marca: ");
        String marca=leer.next();
        System.out.println("Digite la capacidad: ");
        Double capacidad=leer.nextDouble();
        System.out.println("Digite el tipo de interface: ");
        String interfa=leer.next();
        discoDuro.llenar(marca,capacidad,interfa);
        System.out.println("Disco Duro creado con exito...");
        guardarObjetos();
        
    }
    
    public void mostrarDiscoDuro(){
        leerListaDiscoDuro();
        if (discoDuro!=null) {
            discoDuro.mostrar();
        }else{
            System.out.println("No tiene ningun disco duro registrado...");
        }
    }
    //adicionar el metodo que creara el archivo y lo mandara a registrar en el discoDuro
    public void crearArchivoDisco(){
        if (discoDuro!=null) {
            leer.nextLine();
            archivo=new Archivo();
            System.out.println("Digite el nombre del archivo: ");
            archivo.setNombreArchivo(leer.nextLine());
            System.out.println("Digite el tamaño del archivo (Mb): ");
            Double tam=leer.nextDouble();
            if(tam<=discoDuro.getEspacioDisponible()){
                archivo.setTamañoArchivo(tam);
                leer.nextLine();
                discoDuro.setEspacioDisponible(discoDuro.getEspacioDisponible()-archivo.getTamañoArchivo());
                //registrando el archivo en la lista de archivos del disco duro
                discoDuro.adicionarArchivo(archivo);
                guardarObjetos();
            }else{
                System.out.println("No hay suficiente espacio para agregar mas archivos!...");
            }
            
        }else{
            System.out.println("No tiene un disco duro registrado...");
        }
    }
    
    public void eliminarArchivo(){
        if (discoDuro!=null) {
            System.out.println("Digite el nombre del archivo a elimunar: ");
            String nombre=leer.nextLine();
            int a=discoDuro.eliminarArchivo(nombre);
            if(a==1){
                guardarObjetos();
            }
        }else{
            System.out.println("No tiene ningun disco duro creado...");
        }
    }
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-1b\\practica1-mananejoArchivos-1b\\archivosDiscoDuro.txt");
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
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-1b\\practica1-mananejoArchivos-1b\\archivosDiscoDuro.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(discoDuro);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerListaDiscoDuro(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-1b\\practica1-mananejoArchivos-1b\\archivosDiscoDuro.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                discoDuro=(DiscoDuro)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(OperacionesDiscoDuro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
