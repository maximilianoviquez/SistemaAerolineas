package Dominio;

import sistemaAutogestion.ListaCompraPasajes;
import sistemaAutogestion.nodoCompraPasajes;
import tads.Lista;

public class Vuelo {
    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int año;
    private int cantPasajesEcon;
    private int cantPasajesPClase;
    private Lista<Pasaje> pasajes;

    // Constructor
    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino,
                 int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
        this.pasajes = new Lista<>();
    }

    // Getters y setters

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }
    
    public int getCantPasajesEconDisponibles(ListaCompraPasajes comprasPasajes) {
        int cantPasajesEconVendidos = 0;
        nodoCompraPasajes actual = comprasPasajes.getPrimero();
        while (actual != null) {
            if (actual.getCompra().getCodigoVuelo().equals(this.codigoVuelo)) {
                cantPasajesEconVendidos++;
            }
            actual = actual.getSiguiente();
        }
        return this.cantPasajesEcon - cantPasajesEconVendidos;
    }

    public int getCantPasajesPClaseDisponibles(ListaCompraPasajes comprasPasajes) {
        int cantPasajesPClaseVendidos = 0;
        nodoCompraPasajes actual = comprasPasajes.getPrimero();
        while (actual != null) {
            if (actual.getCompra().getCodigoVuelo().equals(this.codigoVuelo)) {
                cantPasajesPClaseVendidos++;
            }
            actual = actual.getSiguiente();
        }
        return this.cantPasajesPClase - cantPasajesPClaseVendidos;
    }

    public String getCantPasajesEconDisponibles() {
        return String.valueOf(this.cantPasajesEcon);
    }

    public String getCantPasajesPClaseDisponibles() {
        return String.valueOf(this.cantPasajesPClase);
    }

    public Lista<Pasaje> getPasajes() {
        return pasajes;
    }

    public void agregarPasaje(Pasaje pasaje) {
        pasajes.agregar(pasaje);
    }
}