package tads;

import Dominio.CompraPasaje;

public class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public CompraPasaje getCompra() {
        if (dato instanceof CompraPasaje) {
            return (CompraPasaje) dato;
        } else {
            return null;
        }
    }
}