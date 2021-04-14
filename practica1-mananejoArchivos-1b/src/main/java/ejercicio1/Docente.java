package ejercicio1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class Docente implements Serializable{
    static final long serialVersionUID=43L;
    private String nombre;
    private String paterno;
    private String materno;
    private String titulo;
    private int cargaHoraria;
    //asignacion de las materias a docentes
    private List<Materia> ListaMaterias;
    
    public Docente() {
        ListaMaterias=new ArrayList<>();
    }
    //Scanner leer=new Scanner(System.in);
    
    public void mostrar(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Paterno: "+this.paterno);
        System.out.println("Materno: "+this.materno);
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Carga horaria: "+this.cargaHoraria);
        if (ListaMaterias!=null) {
            for(Materia mat:ListaMaterias){
                System.out.println("------------------------------");
                mat.mostrar();
                System.out.println("------------------------------");
            }
        }
    }
    
    
    
    //geter and seter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Materia> getListaMaterias() {
        return ListaMaterias;
    }

    public void setListaMaterias(Materia materia) {
        this.ListaMaterias.add(materia);
    }
}