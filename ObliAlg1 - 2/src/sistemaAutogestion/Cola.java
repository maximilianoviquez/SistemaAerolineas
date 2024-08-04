package sistemaAutogestion;
public class Cola implements ICola {
    nodo frente;
    nodo fondo;
    int maximoaceptado;
    int contadornodos;
    public Cola( int maximoaceptado) {
        this.frente = null;
        this.fondo = null;
        this.contadornodos=0;
        this.maximoaceptado = maximoaceptado;
    }
    public nodo getFrente() {
        return frente;
    }
    public void setFrente(nodo frente) {
        this.frente = frente;
    }
    public nodo getFondo() {
        return fondo;
    }
    public void setFondo(nodo fondo) {
        this.fondo = fondo;
    }
    public int getMaximoaceptado() {
        return maximoaceptado;
    }
    public void setMaximoaceptado(int maximoaceptado) {
        this.maximoaceptado = maximoaceptado;
    }
    public int getContadornodos() {
        return contadornodos;
    }
    public void setContadornodos(int contadornodos) {
        this.contadornodos = contadornodos;
    }
    @Override
    public boolean esVacia() {
        return this.frente==null;
    }
    @Override
    public boolean esLLena() {
        return this.contadornodos==this.maximoaceptado;
    }
    @Override
    public void encolar(int dato) {
   if (this.esLLena()) {
            System.out.println("Cola completa");
        } else {
            nodo nuevo = new nodo(dato);
            if (this.esVacia()) {
                this.fondo = nuevo;
                this.frente = nuevo;

            } else {
                nuevo.siguiente = this.fondo;
                this.fondo = nuevo;
            }
            this.contadornodos++;
        }
    }
    @Override
    public void Desencolar() {
        if (!this.esVacia()) {
            if (this.contadornodos == 1) {
                this.frente=null;
                this.fondo=null;
                this.contadornodos=0;
            } else {
                nodo aux = this.fondo;
                while (aux.siguiente.siguiente != null) {
                    aux = aux.siguiente;
                }
                aux.setSiguiente(null);
                this.frente=aux;
                this.contadornodos--;
            }
        }
    }
    @Override
    public nodo frente() {
        return this.frente;
    }
    @Override
    public nodo fondo() {
        return this.fondo;
    }
}
