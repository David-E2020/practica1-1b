package ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class Album implements Serializable{
    static final long serialVersionUID=42L;
    private String nombre;
    private String artista;
    private String formato;
    
    private List<Cancion> listaCanciones;

    public Album() {
        listaCanciones=new ArrayList<>();
    }
    
    public void mostrarAlbum(){
        System.out.println("Nombre album: "+this.nombre);
        System.out.println("Artista: "+this.artista);
        System.out.println("Formato: "+this.formato);
        if(listaCanciones.size()>0){
            System.out.println("***Lista de canciones***\n");
            for(Cancion cancion:listaCanciones){
                cancion.mostrarCancion();
            }
        }
    }
    
    public void adicionarCancion(Cancion cancion){
        listaCanciones.add(cancion);
        System.out.println("Adicionando cancion a Album");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
    
    
}
