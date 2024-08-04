package Dominio;
import tads.Lista;
public class Aerolinea<T> {
    
    private String nombre;
    public String pais;
    private int cantMaxAviones;
    private Lista<T> aviones;
    //contructor
    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
        this.aviones = new Lista<>();
    }
    //metodo para agregar un vuelo al avion
    public void agregarAvion(T avion){
        aviones.agregar(avion);
    }
    public Lista<T> getAviones(){
        return aviones;
    }
    @Override
    public String toString(){
        return "Avion modelo: "+nombre+" Pais: "+pais+" cantidad maxima aviones: "+cantMaxAviones;
    }
    
    public String getPais(){
        return pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantMaxAviones() {
        return cantMaxAviones;
    }

    public void setCantMaxAviones(int cantMaxAviones) {
        this.cantMaxAviones = cantMaxAviones;
    }
    
    
    
}

