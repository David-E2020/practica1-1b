package ejercicio3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hospital implements Serializable{
    static final long serialVersionUID=43L;
    private String nombre;
    private String direccion;
    private int nivel;
    //definiendo la agregacion
    private List<Especialidad> listaEspecialidad;

    public Hospital() {
        listaEspecialidad=new ArrayList<>();
    }
    
    public void adicionarEspecialidad(Especialidad especialidad){
        listaEspecialidad.add(especialidad);
        System.out.println("Especialidad Registrada");
    }
    
    public void mostrar(){
        System.out.println("Nombre del hospital: "+this.nombre);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Nivel: "+this.nivel);
        if (listaEspecialidad.size()>0) {
            System.out.println("*** especialidades ***");
            for(Especialidad list:listaEspecialidad){
                System.out.println("***********************");
                list.mostrar();
                System.out.println("***********************");
            }
        }else{
            System.out.println("No tiene especialidades registradas");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Especialidad> getListaEspecialidad() {
        return listaEspecialidad;
    }

    public void setListaEspecialidad(List<Especialidad> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }
    
    
}
