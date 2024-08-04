package sistemaAutogestion;

import Dominio.Vuelo;

public class ListaAvion implements IListaAvion {
    nodoAerolinea primero;
    nodoAerolinea ultimo;
    int contadornodos;
    int limite;

    public ListaAvion(int limite) {
        this.primero = null;
        this.ultimo = null;
        this.contadornodos = 0;
        this.limite = limite;
    }

    public nodoAerolinea getPrimero() {
        return primero;
    }

    public void setPrimero(nodoAerolinea primero) {
        this.primero = primero;
    }

    public nodoAerolinea getUltimo() {
        return ultimo;
    }

    public void setUltimo(nodoAerolinea ultimo) {
        this.ultimo = ultimo;
    }

    public int getContadornodos() {
        return contadornodos;
    }

    public void setContadornodos(int contadornodos) {
        this.contadornodos = contadornodos;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    @Override
    public void agregarInicio(int identificador, String nombre, int capacidad) {
        if (this.esLLena()) {
            System.out.println("Lista completa, no puede agregar elementos");
        } else {
            nodoAerolinea nuevo = new nodoAerolinea(identificador, nombre, capacidad);
            if (this.esVacia()) {
                this.primero = nuevo;
                this.ultimo = nuevo;
            } else {
                nuevo.siguiente = this.primero;
                this.primero = nuevo;
            }
            this.contadornodos++;
        }
    }

    @Override
    public void mostrar() {
        nodoAerolinea aux = this.getPrimero();
        while (aux != null) {
            System.out.print(aux.getIdentificador() + " - " + aux.getNombre() + "\n");
            aux = aux.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public int cantidadElementos() {
        nodoAerolinea aux = this.getPrimero();
        int contador = 0;
        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }

    public int cantidadElementosv2() {
        return this.contadornodos;
    }

    @Override
    public boolean existeElemento(int elemento) {
        nodoAerolinea aux = this.getPrimero();
        boolean encontrado = false;
        while (aux != null && !encontrado) {
            if (elemento == aux.getIdentificador()) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }

        return encontrado;
    }

    public boolean existeElemento(String nombre) {
        nodoAerolinea aux = this.getPrimero();
        boolean encontrado = false;
        while (aux != null && !encontrado) {
            if (nombre.equals(aux.getNombre())) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        return encontrado;
    }

    @Override
    public nodoAerolinea obtenerElemento(int elemento) {
        nodoAerolinea aux = this.getPrimero();
        nodoAerolinea encontrado = null;
        while (aux != null && encontrado == null) {
            if (elemento == aux.getIdentificador()) {
                encontrado = aux;
            }
            aux = aux.getSiguiente();
        }

        return encontrado;
    }

    @Override
    public void eliminarElemento(int elemento) {
        nodoAerolinea aux = this.getPrimero();
        boolean borrado = false;
        if (this.getPrimero().getIdentificador() == elemento) {
            this.eliminarInicio();
        } else {
            while (aux != null && aux.getSiguiente() != null && !borrado) {
                if (aux.siguiente.getIdentificador() == elemento) {
                    aux.siguiente = aux.siguiente.siguiente;
                    borrado = true;
                }
                aux = aux.siguiente;
            }
        }
    }

    public void eliminarElemento(String nombre) {
        nodoAerolinea aux = this.getPrimero();
        nodoAerolinea anterior = null;
        boolean encontrado = false;

        if (aux != null && aux.getNombre().equals(nombre)) {
            this.setPrimero(aux.getSiguiente());
            encontrado = true;
        } else {
            while (aux != null && !encontrado) {
                if (aux.getNombre().equals(nombre)) {
                    encontrado = true;
                } else {
                    anterior = aux;
                    aux = aux.getSiguiente();
                }
            }

            if (encontrado) {
                anterior.setSiguiente(aux.getSiguiente());
            }
        }
    }

    public void agregarFinal(int identificador, String nombre) {
        if (this.esLLena()) {
            System.out.println("Lista llena, no puede agregar");
        } else {
            nodoAerolinea nuevo = new nodoAerolinea(identificador, nombre, 5);
            if (this.esVacia()) {
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            } else {
                this.ultimo.setSiguiente(nuevo);
                this.setUltimo(nuevo);
            }
            this.contadornodos++;
        }
    }

    @Override
    public boolean esVacia() {
        return this.getPrimero() == null;
    }

    @Override
    public boolean esLLena() {
        return this.contadornodos == this.limite;
    }

    @Override
    public void vaciar() {
        this.setPrimero(null);
        this.contadornodos = 0;
    }

    @Override
    public void eliminarInicio() {
        if (!this.esVacia()) {
            if (this.contadornodos == 1) {
                this.primero = null;
                this.ultimo = null;
                this.contadornodos = 0;
            } else {
                this.setPrimero(this.primero.getSiguiente());
                this.contadornodos--;
            }
        } else {
            System.out.println("No hay nada para eliminar, la lista está vacía");
        }
    }

    @Override
    public void eliminarFinal() {
        if (!this.esVacia()) {
            if (this.cantidadElementos() == 1) {
                this.eliminarInicio();
            } else {
                nodoAerolinea aux = this.getPrimero();
                while (aux.siguiente.siguiente != null) {
                    aux = aux.siguiente;
                }
                aux.setSiguiente(null);
                this.contadornodos--;
            }
        }
    }

    @Override
    public void agregarFinal(int identificador, String nombre, int capacidad) {
        nodoAerolinea nuevo = new nodoAerolinea(identificador, nombre, capacidad);
        if (this.esLLena()) {
            System.out.println("Lista llena, no puede agregar");
        } else {
            if (this.esVacia()) {
                this.setPrimero(nuevo);
                this.setUltimo(nuevo);
            } else {
                this.ultimo.setSiguiente(nuevo);
                this.setUltimo(nuevo);
            }
            this.contadornodos++;
        }
    }

    public ListaVuelo getVuelos() {
        ListaVuelo vuelos = new ListaVuelo();
        nodoAerolinea aux = this.getPrimero();
        while (aux != null) {
            vuelos.agregarFinal(aux.getVuelo());
            aux = aux.getSiguiente();
        }
        return vuelos;
    }
}