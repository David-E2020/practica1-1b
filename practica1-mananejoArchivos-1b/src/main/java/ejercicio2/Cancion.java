/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class Cancion implements Serializable{
    static final long serialVersionUID=43L;
    private String nombreCancion;
    private float duracion;
    private String genero;
    
    public void mostrarCancion(){
        System.out.println("Nombre de la cancion: "+this.nombreCancion);
        System.out.println("Duracion: "+this.duracion);
        System.out.println("Genero : "+this.genero);
    }
    
    //heneramos los geter and setter

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
