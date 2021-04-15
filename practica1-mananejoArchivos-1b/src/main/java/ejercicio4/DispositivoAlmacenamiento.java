package ejercicio4;
import java.io.Serializable;
public class DispositivoAlmacenamiento implements Serializable{
    static final long serialVersionUID=42L;
    private String marca;
    private double capacidad;
    private double espacioDisponible;
    //metodos
    
    public void llenar(String marca,Double capacidad,String aaa){
        this.marca=marca;
        this.capacidad=capacidad;
    }
    
    public void mostrar(){
        System.out.println("Marca: "+this.marca);
        System.out.println("Capacidad: "+this.capacidad+" Mb");
        System.out.println("Espacio Disponible: "+this.espacioDisponible+" Mb");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(double espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }
    
    
}
