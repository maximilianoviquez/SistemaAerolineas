package sistemaAutogestion;

import Dominio.Cliente;

public class nodoCliente {
    private Cliente cliente;
    private nodoCliente siguiente;

    public nodoCliente(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public nodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return cliente.getNombre();
    }

    public String getPasaporte() {
        return cliente.getPasaporte();
    }
    
    public int getEdad() {
        return cliente.getEdad();
    }
}
