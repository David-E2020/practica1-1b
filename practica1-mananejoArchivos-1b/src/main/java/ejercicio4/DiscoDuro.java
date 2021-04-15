package ejercicio4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DiscoDuro extends DispositivoAlmacenamiento implements Serializable{
    static final long serialVersionUID=43L;
    private String tipoInterfaz;
    //definiendo la agragacion
    private List<Archivo> listaArchivo;

    public DiscoDuro() {
        listaArchivo=new ArrayList<>();
    }
    
    
    //metodos
    public void adicionarArchivo(Archivo archivo){
        listaArchivo.add(archivo);
        System.out.println("Archivo registrado con exito...");
    }
    
    
    @Override
    public void llenar(String marca,Double capacidad,String tipoInter){
        super.llenar(marca,capacidad,tipoInter);
        //System.out.print("Digite el tipo de interface: ");
        this.tipoInterfaz=tipoInter;
        super.setEspacioDisponible(super.getCapacidad());
    }
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Tipo de interfaz: "+this.tipoInterfaz);
        if (listaArchivo.size()>0) {
            System.out.println("----------ARCHIVOS--------");
            for(Archivo archivo:listaArchivo){
                archivo.mostrar();
                System.out.println("---------------------------");
            }
        }else{
            System.out.println("No tiene archivos agregados...");
        }
    }
    
    public int eliminarArchivo(String nombreArch){
        int sw=0;
        if (listaArchivo.size()>0) {
            //System.out.print("Digite el nombre del archivo a eliminar: ");
            String eliminar=nombreArch;
            for(Archivo archivo:listaArchivo){
                if (archivo.getNombreArchivo().equalsIgnoreCase(eliminar)) {
                    super.setEspacioDisponible(super.getEspacioDisponible()+archivo.getTamañoArchivo());
                    listaArchivo.remove(archivo);
                    System.out.println("Archivo encontrado...");
                    sw=1;
                    break;
                }
            }
            if (sw==0) System.out.println("Archivo no encontrado o no existe...");
            else System.out.println("Archivo eliminado...");
        }else{
            System.out.println("No tiene archivos agregados...");
        }
        return sw;
    }

    public String getTipoInterfaz() {
        return tipoInterfaz;
    }

    public void setTipoInterfaz(String tipoInterfaz) {
        this.tipoInterfaz = tipoInterfaz;
    }

    public List<Archivo> getListaArchivo() {
        return listaArchivo;
    }

    public void setListaArchivo(List<Archivo> listaArchivo) {
        this.listaArchivo = listaArchivo;
    }
    
    
}
