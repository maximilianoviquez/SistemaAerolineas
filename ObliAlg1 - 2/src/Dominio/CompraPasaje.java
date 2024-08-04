package Dominio;

public class CompraPasaje {
    private String codigoVuelo;
    private boolean devolucion;
    private Pasaje pasaje;

    // Otros campos y métodos

    public CompraPasaje(String codigoVuelo, boolean devolucion, Pasaje pasaje) {
        this.codigoVuelo = codigoVuelo;
        this.devolucion = devolucion;
        this.pasaje = pasaje;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public boolean isDevolucion() {
        return devolucion;
    }

    public Pasaje getPasaje() {
        return pasaje;
    }
}