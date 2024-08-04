package sistemaAutogestion;

import Dominio.CompraPasaje;

public class nodoCompraPasajes {
    private CompraPasaje compra;
    private nodoCompraPasajes siguiente;

    public nodoCompraPasajes(CompraPasaje compra) {
        this.compra = compra;
        this.siguiente = null;
    }

    public CompraPasaje getCompra() {
        return compra;
    }

    public void setCompra(CompraPasaje compra) {
        this.compra = compra;
    }

    public nodoCompraPasajes getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCompraPasajes siguiente) {
        this.siguiente = siguiente;
    }
}
