package ejercicio2;

import ejercicio1.OperacionesDocenteMateria;
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

/**
 *
 * @author david
 */
public class operacionesAlbumCancion {
    List<Album> listaAlbum;
    
    public operacionesAlbumCancion() {
        listaAlbum=new ArrayList<>();
    }
    private Cancion cancion;
    private Album album;
    Scanner leer=new Scanner(System.in);
    
    public void crearAlbum(){
        album=new Album();
        System.out.println("Digite el nombre del album: ");
        album.setNombre(leer.nextLine());
        System.out.println("Digite el artista del album: ");
        album.setArtista(leer.nextLine());
        System.out.println("Digite el formato del album: ");
        album.setFormato(leer.nextLine());
        System.out.println("Digite el numero de canciones que tendra el album: ");
        int nc=leer.nextInt();
        leer.nextLine();
        for(int i=1; i<=nc; i++){
            cancion=new Cancion();
            System.out.println("Nombre de la cancion: ");
            cancion.setNombreCancion(leer.nextLine());
            System.out.println("Genero de la cancion: ");
            cancion.setGenero(leer.nextLine());
            System.out.println("Duracion de la cancion: ");
            cancion.setDuracion(leer.nextFloat());
            album.adicionarCancion(cancion);
            leer.nextLine();
        }
        //agregamos el album a la lista de album
        listaAlbum.add(album);
        guardarObjetos();
        
    }
    
    public void mostrarListaAlbum(){
        if(listaAlbum!=null){
            System.out.println("*** Lista de albums ***");
            for(Album alb:listaAlbum){
                System.out.println("--------------------------------");
                alb.mostrarAlbum();
                System.out.println("--------------------------------");
            }
        }else{
            System.out.println("Album vacio");
        }
    }
    
    public void buscarCancion(){
        int sw=0;
        if(listaAlbum!=null){
            System.out.println("Digite el nombre de la cancion: ");
            String nom=leer.nextLine();
            for(Album alb:listaAlbum){
                for(Cancion can: alb.getListaCanciones()){
                    if(can.getNombreCancion().equalsIgnoreCase(nom)){
                        System.out.println("---------------------------------\n");
                        System.out.println("El nombre del album es: "+alb.getNombre());
                        System.out.println("El nombre del artista es: "+alb.getArtista());
                        System.out.println("\n---------------------------------");
                        sw=1;
                    }
                }
                
            }
            if(sw==0){
                System.out.println("Cancion no registrada!...");
            }
        }else{
            System.out.println("*** No se registro ningun album ***");
        }
        
        
    }
    //Mostrar las canciones de un determinado álbum.
    public void albumCanciones (){
        int sw=0;
        
        if(listaAlbum!=null){
            System.out.println("Digite el nombre del album: ");
            String nombreAlb=leer.nextLine();
            for(Album alb:listaAlbum){
                if(alb.getNombre().equalsIgnoreCase(nombreAlb)){
                    sw=1;
                    System.out.println("-----------------------------------\n");
                    alb.mostrarAlbum();
                    System.out.println("\n-----------------------------------");
                }
            }
            if(sw==0){
                System.out.println("Album no encontrado!...");
            }
        }else{
            System.out.println("*** No se registro ningun album ***");
        }
    }
    
    public void eliminarAlbum (){
        int sw=0;
        if(listaAlbum!=null){
            System.out.println("Digite el nombre del album a eliminar: ");
            String nombreAlb=leer.nextLine();
            for(Album albAux:listaAlbum){
                if(nombreAlb.equalsIgnoreCase(albAux.getNombre())){
                    sw=1;
                    System.out.println("-------- Album encontrado-------\n");
                    albAux.mostrarAlbum();
                    System.out.println("\n-----------------------------------");
                    listaAlbum.remove(albAux);
                    System.out.println("Album eliminado");
                    System.out.println("-----------------------------------");
                }
            }
            if(sw==0){
                System.out.println("Album no encontrado!...");
            }
        }else{
            System.out.println("*** No se registro ningun album ***");
        }
    }
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-1b\\practica1-mananejoArchivos-1b\\album.txt");
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
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-1b\\practica1-mananejoArchivos-1b\\album.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaAlbum);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(operacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    //cargamos los datos del archivo a un list<Cliente>
    public void leerAlbum(){
        String ruta="D:\\SISTEMAS_INFORMATICOS_3_AÑO\\PROGRAMACION_III\\1-bimestre\\practica1-1b\\practica1-mananejoArchivos-1b\\album.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaAlbum=(List<Album>)ois.readObject();
            }else{
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(operacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, e);
        }catch(IOException ex){
             Logger.getLogger(operacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex){
             Logger.getLogger(operacionesAlbumCancion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
