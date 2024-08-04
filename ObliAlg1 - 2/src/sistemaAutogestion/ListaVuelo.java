package sistemaAutogestion;

import Dominio.Vuelo;

public class ListaVuelo {
    private nodoVuelo primero;

    // Constructor
    public ListaVuelo() {
        this.primero = null;
    }

    // Método para obtener el primer nodo
    public nodoVuelo getPrimero() {
        return primero;
    }

    // Método para agregar un vuelo al final de la lista
    public void agregarFinal(Vuelo vuelo) {
        nodoVuelo nuevoNodo = new nodoVuelo(vuelo);
        if (this.primero == null) {
            this.primero = nuevoNodo;
        } else {
            nodoVuelo aux = this.primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }
    }

    // Método para contar el número de elementos en la lista
    public int cantidadElementos() {
        int contador = 0;
        nodoVuelo aux = primero;
        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }

    // Método para obtener un elemento por índice
    public Vuelo obtenerElemento(int indice) {
        if (indice < 0 || indice >= cantidadElementos()) {
            return null; // Índice fuera de rango
        }
        nodoVuelo aux = primero;
        for (int i = 0; i < indice; i++) {
            aux = aux.getSiguiente();
        }
        return aux.getVuelo();
    }
}