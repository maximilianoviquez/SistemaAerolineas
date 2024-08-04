package sistemaAutogestion;

import Dominio.Vuelo;

public class nodoVuelo {
    private Vuelo vuelo;
    private nodoVuelo siguiente;

    // Constructor
    public nodoVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
        this.siguiente = null;
    }

    // Getters y setters
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public nodoVuelo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoVuelo siguiente) {
        this.siguiente = siguiente;
    }
}