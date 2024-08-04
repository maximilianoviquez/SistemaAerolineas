package sistemaAutogestion;
public class ListaAerolinea implements IListaAerolinea {
    nodoAerolinea primero;
    nodoAerolinea ultimo;
    int contadornodos;
    int limite;
    public ListaAerolinea(int limite) {
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
    // implementacion de los metodos de la interface
    //---------------------------------------------------
     @Override
    public void agregarInicio(int identificador, String nombre) {
        if (this.esLLena()) {
            System.out.println("Lista completa, no puede agregar elementos");
        } else {
            nodoAerolinea nuevo = new nodoAerolinea(identificador, nombre, 5); // Se utiliza el constructor que acepta tres parámetros
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
            System.out.print(aux.getIdentificador()+ " - " + aux.getNombre()+"\n");
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
    // LA IDEA ES NO RECORRER LA LISTA
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
    
    public nodoAerolinea obtenerElemento(String nombre) {
        nodoAerolinea aux = this.getPrimero();
        nodoAerolinea encontrado = null;

        // Buscar el nodo de la aerolínea con el nombre especificado
        while (aux != null && encontrado == null) {
            if (aux.getNombre().equals(nombre)) {
                encontrado = aux;
            } else {
                aux = aux.getSiguiente();
            }
        }

        // Si se encontró la aerolínea, retornarla
        // Si no se encuentra, encontrado será null
        return encontrado;
    }

    // pre: el elemento existe
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
    nodoAerolinea previo = null;
    boolean encontrado = false;
    
    // Buscar el nodo de la aerolínea con el nombre especificado
    while (aux != null && !encontrado) {
        if (aux.getNombre().equals(nombre)) {
            encontrado = true;
        } else {
            previo = aux;
            aux = aux.getSiguiente();
        }
    }
    
    // Si se encontró la aerolínea, eliminarla
    if (encontrado) {
        // Si es el primer elemento de la lista
        if (previo == null) {
            this.setPrimero(aux.getSiguiente());
            // Si es el último elemento de la lista
            if (aux.getSiguiente() == null) {
                this.setUltimo(null);
            }
        } else {
            previo.setSiguiente(aux.getSiguiente());
            // Si es el último elemento de la lista
            if (aux.getSiguiente() == null) {
                this.setUltimo(previo);
            }
        }
        this.contadornodos--;
    }
}

    
@Override
public void agregarFinal(int identificador, String nombre) {
    if (this.esLLena()) {
        System.out.println("Lista llena, no puede agregar");
    } else {
        nodoAerolinea nuevo = new nodoAerolinea(identificador, nombre, 5); // Utilizamos el constructor que acepta tres parámetros
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
        }else{
            System.out.println("No hay nada para eliminar , la lista esta vacia");
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
    

    
    public void eliminarAerolinea(String nombre) {
        nodoAerolinea aux = this.getPrimero();
        nodoAerolinea previo = null;
        boolean encontrado = false;

        // Buscar el nodo de la aerolínea con el nombre especificado
        while (aux != null && !encontrado) {
            if (aux.getNombre().equals(nombre)) {
                encontrado = true;
            } else {
                previo = aux;
                aux = aux.getSiguiente();
            }
        }

        // Si se encontró la aerolínea, eliminarla de la lista
        if (encontrado) {
            // Si el nodo a eliminar es el primero
            if (previo == null) {
                this.eliminarInicio();
            } else {
                previo.setSiguiente(aux.getSiguiente());
                // Si el nodo a eliminar es el último
                if (aux == this.getUltimo()) {
                    this.setUltimo(previo);
                }
                this.contadornodos--;
            }
            System.out.println("Aerolínea \"" + nombre + "\" eliminada exitosamente.");
        } else {
            System.out.println("La aerolínea \"" + nombre + "\" no se encuentra en la lista.");
        }
    }


 public void listarAerolineas() {
    if (this.esVacia()) {
        System.out.println("La lista de aerolíneas está vacía.");
    } else {
        nodoAerolinea aux = this.getPrimero();
        while (aux != null) {
            System.out.println("Identificador: " + aux.getIdentificador() + ", Nombre: " + aux.getNombre());
            aux = aux.getSiguiente();
        }
    }
}

    
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    



   

