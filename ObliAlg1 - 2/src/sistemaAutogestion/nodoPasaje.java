
package sistemaAutogestion;

import Dominio.Pasaje;

public class nodoPasaje {
    private Pasaje pasaje;
    private nodoPasaje siguiente;

    public nodoPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
        this.siguiente = null;
    }

    // Getters y setters

    public Pasaje getPasaje() {
        return pasaje;
    }

    public void setPasaje(Pasaje pasaje) {
        this.pasaje = pasaje;
    }

    public nodoPasaje getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoPasaje siguiente) {
        this.siguiente = siguiente;
    }
    
}