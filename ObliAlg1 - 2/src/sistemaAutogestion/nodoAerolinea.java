package sistemaAutogestion;

import Dominio.Aerolinea;
import Dominio.Vuelo;
import java.util.ArrayList;
import java.util.List;

public class nodoAerolinea<T> {
    private Aerolinea<T> aerolinea;
    private ListaAvion lAv;
    private ListaVuelo lVuelos; // Agregar atributo para la lista de vuelos
    nodoAerolinea siguiente;
    private int identificador; // Nuevo atributo

    // Constructor que acepta cuatro parámetros
    public nodoAerolinea(int identificador, String nombre, String pais, int cantMaxAviones) {
        this.identificador = identificador; // Asignar el identificador
        this.aerolinea = new Aerolinea<>(nombre, pais, cantMaxAviones);
        this.lAv = new ListaAvion(5);
        this.lVuelos = new ListaVuelo(); // Inicializar la lista de vuelos
        this.siguiente = null;
    }

    // Constructor que acepta tres parámetros
    public nodoAerolinea(int identificador, String nombre, int capacidad) {
        this.identificador = identificador; // Asignar el identificador
        this.aerolinea = new Aerolinea<>(nombre, "", capacidad); // No se proporciona el país
        this.lAv = new ListaAvion(5);
        this.lVuelos = new ListaVuelo(); // Inicializar la lista de vuelos
        this.siguiente = null;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return aerolinea.getNombre();
    }

    public void setNombre(String nombre) {
        aerolinea.setNombre(nombre);
    }

    public String getPais() {
        return aerolinea.getPais();
    }

    public int getCantMaxAviones() {
        return aerolinea.getCantMaxAviones();
    }

    public ListaAvion getlAv() {
        return lAv;
    }

    public void setlAv(ListaAvion lAv) {
        this.lAv = lAv;
    }

    public nodoAerolinea getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoAerolinea siguiente) {
        this.siguiente = siguiente;
    }

    public Aerolinea<T> getAerolinea() {
        return aerolinea;
    }

    public ListaVuelo getlVuelos() {
        return lVuelos;
    }

    public void setlVuelos(ListaVuelo lVuelos) {
        this.lVuelos = lVuelos;
    }

    public Vuelo getVuelo() {
        List<Vuelo> vuelos = new ArrayList<>();
        nodoAerolinea aux = this;
        while (aux != null) {
            ListaVuelo listaVuelos = aux.getlAv().getVuelos();
            nodoVuelo nodoVuelo = listaVuelos.getPrimero();
            while (nodoVuelo != null) {
                vuelos.add(nodoVuelo.getVuelo());
                nodoVuelo = nodoVuelo.getSiguiente();
            }
            aux = aux.getSiguiente();
        }
        return vuelos.isEmpty() ? null : vuelos.get(0); // Devuelve el primer vuelo encontrado o null si no hay vuelos
    }
}