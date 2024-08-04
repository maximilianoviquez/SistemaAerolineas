package Dominio;
import tads.Lista;
public class Avion<T> {
    private String modelo;
    private Lista<T> vuelos_;
    //contructor
    public Avion(String modelo) {
        this.modelo = modelo;
        this.vuelos_ = new Lista<>();
    }
    //metodo para agregar un vuelo al avion
    public void agregarVuelo(T vuelo){
        vuelos_.agregar(vuelo);
    }
    public Lista<T> getVuelos(){
        return vuelos_;
    }
    @Override
    public String toString(){
        return "Avion modelo: "+modelo+"\nVuelos:\n"+vuelos_;
    }
     // Método para mostrar la información del avión y sus vuelos
    public void mostrar() {
        System.out.println("Avión modelo: " + modelo);
        System.out.println("Vuelos:");
        for (int i = 0; i < vuelos_.tamaño(); i++) {
            System.out.println(vuelos_.obtener(i));
        }
    }
    
    
    
}
