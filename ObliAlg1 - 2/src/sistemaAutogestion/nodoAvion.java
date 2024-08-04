package sistemaAutogestion;
public class nodoAvion {
    int identificador;
    String nombre;
    int capacidad;
    ListaAvion lAv ;
    nodoAvion siguiente;
    public nodoAvion(int identificador, String nombre, int capacidad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.siguiente = null;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public nodoAvion getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(nodoAvion siguiente) {
        this.siguiente = siguiente;
    }    
}
