package ejercicio4;

import java.io.Serializable;

public class Archivo implements Serializable{
    static final long serialVersionUID=44L;
    private String nombreArchivo;
    private double tamañoArchivo;
    
    public void mostrar(){
        System.out.println("Nombre Archivo: "+this.nombreArchivo);
        System.out.println("Tamaño Archivo: "+this.tamañoArchivo);
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public double getTamañoArchivo() {
        return tamañoArchivo;
    }

    public void setTamañoArchivo(double tamañoArchivo) {
        this.tamañoArchivo = tamañoArchivo;
    }
    
    
}
