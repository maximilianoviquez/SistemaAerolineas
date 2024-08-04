package tads;

import Dominio.Pasaje;

public class Lista<T> implements ILista<T> {
    private Nodo<T> inicio;
    private Nodo<T> cabeza;    

    public Lista() {
        this.inicio = null;
        this.cabeza = null;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    } 

    @Override
    public boolean esVacia() {
        return cabeza == null;
    }

    @Override
    public void agregarInicio(T n) {
        Nodo<T> nuevoNodo = new Nodo<>(n);
        nuevoNodo.setSiguiente(inicio);
        inicio = nuevoNodo;
        if (cabeza == null) {
            cabeza = nuevoNodo;
        }
    }

    @Override
    public void agregarFinal(T n) {
        Nodo<T> nuevoNodo = new Nodo<>(n);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public void agregarInicio() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void borrarInicio() {
        if (!esVacia()) {
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                cabeza = null;
            }
        }
    }

    @Override
    public void borrarFin() {
        if (!esVacia()) {
            if (inicio == cabeza) {
                inicio = null;
                cabeza = null;
            } else {
                Nodo<T> actual = inicio;
                while (actual.getSiguiente() != cabeza) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
                cabeza = actual;
            }
        }
    }

    @Override
    public void vaciar() {
        inicio = null;
        cabeza = null;
    }

    @Override
    public void mostrar() {
        Nodo<T> actual = inicio;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    @Override
    public void borrarElemento(T n) {
        if (!esVacia()) {
            if (inicio.getDato().equals(n)) {
                borrarInicio();
            } else {
                Nodo<T> actual = inicio;
                while (actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(n)) {
                    actual = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    if (actual.getSiguiente() == null) {
                        cabeza = actual;
                    }
                }
            }
        }
    }

    @Override
    public int cantElemento() {
        int contador = 0;
        Nodo<T> actual = inicio;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public Nodo<T> obtenerElemento(T n) {
        Nodo<T> actual = inicio;
        while (actual != null) {
            if (actual.getDato().equals(n)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public void agregarOrdenado(T n) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void agregar(T dato) {
        agregarFinal(dato);
    }

    @Override
    public int tamaño() {
        return cantElemento();
    }

    @Override
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño()) {
            return null;
        }
        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    
    public void eliminar(T n) {
        if (!esVacia()) {
            if (inicio.getDato().equals(n)) {
                borrarInicio();
            } else {
                Nodo<T> actual = inicio;
                while (actual.getSiguiente() != null && !actual.getSiguiente().getDato().equals(n)) {
                    actual = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    if (actual.getSiguiente() == null) {
                        cabeza = actual;
                    }
                }
            }
        }
    }

    public Nodo<T> getPrimero() {
        return inicio;
    }
}