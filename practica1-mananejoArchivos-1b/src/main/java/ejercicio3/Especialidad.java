package ejercicio3;

import java.io.Serializable;

public class Especialidad implements Serializable{
    static final long serialVersionUID=42L;
    
    private String nomEspecialidad;
    
    public void mostrar(){
        System.out.println("Especialidad: "+this.nomEspecialidad);
    }

    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }
    
}
