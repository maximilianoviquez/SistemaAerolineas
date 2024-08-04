package sistemaAutogestion;

import Dominio.Cliente;

public class ListaCliente {
    private nodoCliente primero;

    public ListaCliente() {
        this.primero = null;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public void agregarCliente(Cliente cliente) {
        nodoCliente nuevo = new nodoCliente(cliente);
        if (primero == null) {
            primero = nuevo;
        } else {
            nodoCliente aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public boolean existeCliente(String pasaporte) {
        nodoCliente aux = primero;
        while (aux != null) {
            if (aux.getCliente().getPasaporte().equals(pasaporte)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public Cliente obtenerElemento(String pasaporte) {
        nodoCliente actual = primero;
        while (actual != null) {
            if (actual.getCliente().getPasaporte().equals(pasaporte)) {
                return actual.getCliente();
            }
            actual = actual.getSiguiente();
        }
        return null; // Si no se encuentra el elemento, retornar null
    }

    public nodoCliente getPrimero() {
        return primero;
    }

    public Cliente buscarCliente(String pasaporte) {
        nodoCliente actual = primero;
        while (actual != null) {
            if (actual.getCliente().getPasaporte().equals(pasaporte)) {
                return actual.getCliente();
            }
            actual = actual.getSiguiente();
        }
        return null; // Retorna null si el cliente no se encuentra
    }

    public void agregar(Cliente nuevoCliente) {
        nodoCliente nuevo = new nodoCliente(nuevoCliente);
        if (primero == null) {
            primero = nuevo;
        } else {
            nodoCliente aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    public int tamaño() {
        int contador = 0;
        nodoCliente aux = primero;
        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }

    public Cliente obtener(int i) {
        int contador = 0;
        nodoCliente aux = primero;
        while (aux != null) {
            if (contador == i) {
                return aux.getCliente();
            }
            contador++;
            aux = aux.getSiguiente();
        }
        return null; // Retorna null si no se encuentra el cliente en la posición dada
    }
}