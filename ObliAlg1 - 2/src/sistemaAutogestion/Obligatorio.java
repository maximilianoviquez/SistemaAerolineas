package sistemaAutogestion;

import Dominio.*;
import tads.Lista;
import tads.Nodo;

public class Obligatorio implements IObligatorio {
    ListaAerolinea la;
    ListaCliente lc;

    @Override
    public Retorno crearSistemaDeGestion() {
        try {
            la = new ListaAerolinea(10);
            lc = new ListaCliente();
            la.agregarFinal(1, "American Airlines");
            la.agregarFinal(2, "Pluna");
            la.agregarFinal(3, "Alas Uruguay");
            System.out.println("Sistema de Gestión creado correctamente.");
            la.mostrar();
            return Retorno.ok();
        } catch (Exception e) {
            return Retorno.error5();
        }
    }

    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        nodoAerolinea aux = la.getPrimero();
        boolean encontrado = false;
        while (aux != null && !encontrado) {
            if (nombre.equals(aux.getNombre())) {
                encontrado = true;
            }
            aux = aux.getSiguiente();
        }
        if (encontrado) {
            return Retorno.error1();
        }
        if (cantMaxAviones <= 0) {
            return Retorno.error2();
        }
        la.agregarFinal(la.cantidadElementos() + 1, nombre);
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
        nodoAerolinea aerolinea = la.obtenerElemento(nombre);
        if (aerolinea == null) {
            return Retorno.error1();
        }
        if (!aerolinea.getlAv().esVacia()) {
            return Retorno.error2();
        }
        la.eliminarElemento(nombre);
        return Retorno.ok();
    }

    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        nodoAerolinea aerolinea = la.obtenerElemento(nomAerolinea);
        if (aerolinea == null) {
            return Retorno.error3();
        }
        if (aerolinea.getlAv().existeElemento(codigo)) {
            return Retorno.error1();
        }
        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            return Retorno.error2();
        }
        int limiteAvionesSistema = 100;
        if (la.cantidadElementos() >= limiteAvionesSistema) {
            return Retorno.error4();
        }
        int identificadorAvion = la.cantidadElementos() + 1;
        aerolinea.getlAv().agregarFinal(identificadorAvion, codigo, capacidadMax);
        return Retorno.ok();
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        nodoAerolinea aerolinea = la.obtenerElemento(nomAerolinea);
        if (aerolinea == null) {
            return Retorno.error1();
        }
        nodoAerolinea avion = aerolinea.getlAv().obtenerElemento(Integer.parseInt(codAvion));
        if (avion == null) {
            return Retorno.error2();
        }
        aerolinea.getlAv().eliminarElemento(Integer.parseInt(codAvion));
        return Retorno.ok();
    }

    @Override
    public Retorno listarAerolineas() {
        if (la == null) {
            return Retorno.error1();
        }
        String resultado = "";
        nodoAerolinea aerolinea = la.getPrimero();
        while (aerolinea != null) {
            String avionesStr = "";
            ListaAvion aviones = aerolinea.getlAv();
            nodoAerolinea currentAvion = aviones.getPrimero();
            while (currentAvion != null) {
                avionesStr += currentAvion.getIdentificador() + "-" + currentAvion.getNombre() + "-";
                currentAvion = currentAvion.getSiguiente();
            }
            resultado += aerolinea.getIdentificador() + "-" + aerolinea.getNombre() + "-" + avionesStr + "|";
            aerolinea = aerolinea.getSiguiente();
        }
        if (!resultado.isEmpty()) {
            resultado = resultado.substring(0, resultado.length() - 1);
        }
        return Retorno.ok(resultado);
    }

    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
    nodoAerolinea aerolinea = la.obtenerElemento(nombre);
    if (aerolinea == null) {
        return Retorno.error1();
    }
    ListaAvion aviones = aerolinea.getlAv();
    if (aviones.esVacia()) {
        return Retorno.ok("No hay aviones registrados para esta aerolínea.");
    }
    String resultado = "";
    nodoAerolinea nodaerolinea = aviones.getPrimero();
    while (nodaerolinea != null) {
        resultado += nodaerolinea.getIdentificador() + "-" + nodaerolinea.getNombre() + "-";
        nodaerolinea = nodaerolinea.getSiguiente();
    }
    return Retorno.ok(resultado);
}

@Override
public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
    if (pasaporte.length() != 7) {
        return Retorno.error2();
    }
    if (existeClienteConPasaporte(pasaporte)) {
        return Retorno.error3();
    }
    Cliente nuevoCliente = new Cliente(pasaporte, nombre, edad);
    lc.agregar(nuevoCliente);
    return Retorno.ok();
}

private boolean existeClienteConPasaporte(String pasaporte) {
    for (int i = 0; i < lc.tamaño(); i++) {
        if (lc.obtener(i).getPasaporte().equals(pasaporte)) {
            return true;
        }
    }
    return false;
}

@Override
public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino,
                          int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
    if (existeVueloConCodigo(codigoVuelo)) {
        return Retorno.error1();
    }
    nodoAerolinea aerolineaNodo = la.obtenerElemento(aerolinea);
    if (aerolineaNodo == null) {
        return Retorno.error2();
    }
    try {
        int codigoAvion = Integer.parseInt(codAvion);
        if (!aerolineaNodo.getlAv().existeElemento(codigoAvion)) {
            return Retorno.error3();
        }
    } catch (NumberFormatException e) {
        return Retorno.error5();
    }
    if (existeVueloParaAvionEnFecha(codAvion, dia, mes, año)) {
        return Retorno.error4();
    }
    if (cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0) {
        return Retorno.error5();
    }
    int capacidadAvion = aerolineaNodo.getlAv().obtenerElemento(Integer.parseInt(codAvion)).getCantMaxAviones();
    if (cantPasajesEcon + cantPasajesPClase > capacidadAvion) {
        return Retorno.error5();
    }
    Vuelo nuevoVuelo = new Vuelo(codigoVuelo, aerolinea, codAvion, paisDestino, dia, mes, año, cantPasajesEcon, cantPasajesPClase);
    aerolineaNodo.getlAv().obtenerElemento(Integer.parseInt(codAvion)).getlVuelos().agregarFinal(nuevoVuelo);
    return Retorno.ok();
}

@Override
public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoriaPasaje) {
    Cliente cliente = lc.obtenerElemento(pasaporteCliente);
    if (cliente == null) {
        return Retorno.error1();
    }
    if (!existeVueloConCodigo(codigoVuelo)) {
        return Retorno.error2();
    }
    if (!hayDisponibilidadParaCategoria(codigoVuelo, categoriaPasaje)) {
        return Retorno.noImplementada();
    }
    Pasaje pasaje = new Pasaje(pasaporteCliente, codigoVuelo, categoriaPasaje);
    cliente.getPasajes().agregar(pasaje);
    return Retorno.ok();
}

private boolean hayDisponibilidadParaCategoria(String codigoVuelo, int categoriaPasaje) {
    // Implementar la lógica para verificar la disponibilidad de pasajes
    return true;
}

@Override
public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
    Cliente cliente = lc.obtenerElemento(pasaporteCliente);
    if (cliente == null) {
        return Retorno.error1();
    }
    if (!existeVueloConCodigo(codigoVuelo)) {
        return Retorno.error2();
    }
    if (!cliente.tieneCompraParaVuelo(codigoVuelo)) {
        return Retorno.error3();
    }
    Vuelo vuelo = obtenerVueloPorCodigo(codigoVuelo); // Método para obtener el vuelo por código
    if (vuelo != null) {
        vuelo.getPasajes().eliminar(new Pasaje(pasaporteCliente, codigoVuelo, 1)); // Asumiendo categoría 1 por simplicidad
    }
    return Retorno.ok();
}
// Método para obtener el vuelo por su código



@Override
public Retorno listarClientes() {
    if (lc == null) {
        return Retorno.error1();
    }
    StringBuilder resultado = new StringBuilder();
    nodoCliente cliente = lc.getPrimero();
    while (cliente != null) {
        String infoCliente = cliente.getNombre() + "-" + cliente.getPasaporte() + "-" + cliente.getEdad();
        resultado.append(infoCliente).append("|");
        cliente = cliente.getSiguiente();
    }
    if (resultado.length() > 0) {
        resultado.deleteCharAt(resultado.length() - 1);
    }
    return Retorno.ok(resultado.toString());
}

@Override
public Retorno listarVuelos() {
    if (la == null) {
        return Retorno.error1();
    }
    StringBuilder resultado = new StringBuilder();
    nodoAerolinea aerolineaActual = la.getPrimero();
    while (aerolineaActual != null) {
        ListaVuelo vuelosAerolinea = aerolineaActual.getlAv().getPrimero().getlVuelos();
        nodoVuelo vueloActual = vuelosAerolinea.getPrimero();
        while (vueloActual != null) {
            String infoVuelo = vueloActual.getVuelo().getCodigoVuelo() + "-" +
                               vueloActual.getVuelo().getAerolinea() + "-" +
                               vueloActual.getVuelo().getCodAvion() + "-" +
                               vueloActual.getVuelo().getCantPasajesEcon() + "-" +
                               vueloActual.getVuelo().getCantPasajesPClase() + "-" +
                               vueloActual.getVuelo().getCantPasajesEconDisponibles() + "-" +
                               vueloActual.getVuelo().getCantPasajesPClaseDisponibles();
            resultado.append(infoVuelo).append("|");
            vueloActual = vueloActual.getSiguiente();
        }
        aerolineaActual = aerolineaActual.getSiguiente();
    }
    if (resultado.length() > 0) {
        resultado.deleteCharAt(resultado.length() - 1);
    }
    return Retorno.ok(resultado.toString());
}

@Override
public Retorno vuelosDeCliente(String pasaporte) {
    if (lc == null) {
        return Retorno.error1();
    }
    Cliente cliente = lc.buscarCliente(pasaporte);
    if (cliente == null) {
        return Retorno.error1();
    }
    StringBuilder resultado = new StringBuilder();
        Nodo<CompraPasaje> actual = cliente.getComprasPasajes().getPrimero();
    while (actual != null) {
        CompraPasaje compra = actual.getCompra();
        String infoCompra = compra.getCodigoVuelo();
        if (compra.isDevolucion()) {
            infoCompra += "-DEV";
        } else {
            infoCompra += "-CPR";
        }
        resultado.append(infoCompra).append("|\n");
        actual = actual.getSiguiente();
    }
    if (resultado.length() > 0) {
        resultado.deleteCharAt(resultado.length() - 1);
    }
    return Retorno.ok(resultado.toString());
}

@Override
public Retorno pasajesDevueltos(String nombreAerolinea) {
    if (la == null) {
        return Retorno.error1();
    }
    nodoAerolinea aerolineaActual = la.getPrimero();
    while (aerolineaActual != null) {
        if (aerolineaActual.getAerolinea().getNombre().equals(nombreAerolinea)) {
            StringBuilder resultado = new StringBuilder();
            ListaCliente clientes = lc;
            nodoCliente clienteActual = clientes.getPrimero();
            while (clienteActual != null) {
                Cliente cliente = clienteActual.getCliente();
                Lista<CompraPasaje> compras = cliente.getComprasPasajes();
                Nodo<CompraPasaje> compraActual = compras.getPrimero();
                while (compraActual != null) {
                    CompraPasaje compra = compraActual.getDato();
                    if (compra.isDevolucion() && compra.getCodigoVuelo().startsWith(nombreAerolinea.substring(0, 2))) {
                        String infoPasaje = cliente.getPasaporte() + "-" + compra.getCodigoVuelo();
                        resultado.append(infoPasaje).append("|\n");
                    }
                    compraActual = compraActual.getSiguiente();
                }
                clienteActual = clienteActual.getSiguiente();
            }
            if (resultado.length() > 0) {
                resultado.delete(resultado.length() - 2, resultado.length());
            }
            return Retorno.ok(resultado.toString());
        }
        aerolineaActual = aerolineaActual.getSiguiente();
    }
    return Retorno.error1();
}

    private boolean existeVueloConCodigo(String codigoVuelo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean existeVueloParaAvionEnFecha(String codAvion, int dia, int mes, int año) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        Vuelo vuelo = obtenerVueloPorCodigo(codigoVuelo);
        if (vuelo == null) {
            return Retorno.error1(); // ERROR_1: No existe un vuelo con ese código
        }

        int asientosPrimera = vuelo.getCantPasajesPClase();
        int asientosEconomica = vuelo.getCantPasajesEcon();
        int totalAsientos = asientosPrimera + asientosEconomica;

        String[][] distribucion = new String[totalAsientos / 3][3];
        for (int i = 0; i < totalAsientos / 3; i++) {
            for (int j = 0; j < 3; j++) {
                distribucion[i][j] = "XXXXXXXX";
            }
        }

        Lista<Pasaje> pasajes = vuelo.getPasajes(); // Asegúrate de que este método esté implementado en la clase Vuelo
        int fila = 0;
        int columna = 0;

        for (int i = 0; i < pasajes.tamaño(); i++) {
            Pasaje pasaje = pasajes.obtener(i);
            distribucion[fila][columna] = pasaje.getPasaporteCliente();
            columna++;
            if (columna == 3) {
                columna = 0;
                fila++;
            }
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("**********************************\n");
        resultado.append("* PRIMERA *\n");
        resultado.append("**********************************\n");

        for (int i = 0; i < asientosPrimera / 3; i++) {
            resultado.append("* ");
            for (int j = 0; j < 3; j++) {
                resultado.append(distribucion[i][j]).append(" * ");
            }
            resultado.append("\n**********************************\n");
        }

        resultado.append("* ECONÓMICA *\n");
        resultado.append("**********************************\n");

        for (int i = asientosPrimera / 3; i < totalAsientos / 3; i++) {
            resultado.append("* ");
            for (int j = 0; j < 3; j++) {
                resultado.append(distribucion[i][j]).append(" * ");
            }
            resultado.append("\n**********************************\n");
        }

        return Retorno.ok(resultado.toString());
    }

    // Método de apoyo para obtener un vuelo por su código
    private Vuelo obtenerVueloPorCodigo(String codigoVuelo) {
        for (int i = 0; i < la.cantidadElementos(); i++) {
            ListaAvion aviones = la.obtenerElemento(i).getlAv();
            for (int j = 0; j < aviones.cantidadElementos(); j++) {
                ListaVuelo vuelos = aviones.obtenerElemento(j).getlVuelos();
                for (int k = 0; k < vuelos.cantidadElementos(); k++) {
                    Vuelo vuelo = vuelos.obtenerElemento(k);
                    if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                        return vuelo;
                    }
                }
            }
        }
        return null;
    }
        
}