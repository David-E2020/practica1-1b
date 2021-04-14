package ejercicio1;

import java.io.Serializable;

/**
 *
 * @author david
 */
public class Materia implements Serializable{
    static final long serialVersionUID=42L;
    private String nombreMateria;
    private int añoMateria;
    private int horaMateria;

    public void mostrar() {
        System.out.println("Nombre materia: " + this.nombreMateria);
        System.out.println("Año de la materia: " + this.añoMateria);
        System.out.println("Horas materia: " + this.horaMateria);
    }

    //geter and seter
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAñoMateria() {
        return añoMateria;
    }

    public void setAñoMateria(int añoMateria) {
        this.añoMateria = añoMateria;
    }

    public int getHoraMateria() {
        return horaMateria;
    }

    public void setHoraMateria(int horaMateria) {
        this.horaMateria = horaMateria;
    }
}