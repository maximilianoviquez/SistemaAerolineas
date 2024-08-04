package Dominio;

import tads.Lista;

public class Cliente {
    private String pasaporte;
    private String nombre;
    private int edad;
    private Lista<CompraPasaje> comprasPasajes;

    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
        this.comprasPasajes = new Lista<>();
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean tieneCompraParaVuelo(String codigoVuelo) {
        for (int i = 0; i < comprasPasajes.tamaño(); i++) {
            if (comprasPasajes.obtener(i).getCodigoVuelo().equals(codigoVuelo)) {
                return true;
            }
        }
        return false;
    }

    public Lista<CompraPasaje> getComprasPasajes() {
        return comprasPasajes;
    }

    public void agregarCompra(CompraPasaje compra) {
        comprasPasajes.agregar(compra);
    }

    public Lista<Pasaje> getPasajes() {
        Lista<Pasaje> pasajes = new Lista<>();
        for (int i = 0; i < comprasPasajes.tamaño(); i++) {
            pasajes.agregar(comprasPasajes.obtener(i).getPasaje());
        }
        return pasajes;
    }
}