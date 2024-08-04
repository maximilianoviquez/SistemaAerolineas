package sistemaAutogestion;

import Dominio.CompraPasaje;

public class ListaCompraPasajes {
    private nodoCompraPasajes primero;

    public ListaCompraPasajes() {
        this.primero = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void agregarCompra(CompraPasaje compra) {
        nodoCompraPasajes nuevoNodo = new nodoCompraPasajes(compra);
        if (estaVacia()) {
            primero = nuevoNodo;
        } else {
            nodoCompraPasajes actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public nodoCompraPasajes getPrimero() {
        return primero;
    }

    public boolean tieneCompraParaVuelo(String codigoVuelo) {
        nodoCompraPasajes actual = primero;
        while (actual != null) {
            if (actual.getCompra().getCodigoVuelo().equals(codigoVuelo)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void eliminar(CompraPasaje compra) {
        if (primero == null) return;

        if (primero.getCompra().equals(compra)) {
            primero = primero.getSiguiente();
            return;
        }

        nodoCompraPasajes actual = primero;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getCompra().equals(compra)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return;
            }
            actual = actual.getSiguiente();
        }
    }
}