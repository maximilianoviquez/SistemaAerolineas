package sistemaAutogestion;
public class nodo {
    int dato;
    nodo siguiente;
    public nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    public int getDato() {
        return dato;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }
    public nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }
}
