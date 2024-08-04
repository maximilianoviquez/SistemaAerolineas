package sistemaAutogestion;

import Dominio.*;
import tads.Lista;
import tads.Nodo;

public class Sistema {
    public static void main(String[] args) {
        Obligatorio O = new Obligatorio();
        juegodeprueba(O);
    }

    public static void juegodeprueba(Obligatorio o) {
        o.crearSistemaDeGestion();

        // Crear aviones
        Avion<Vuelo> avion1 = new Avion<>("Boeing 747");
        Avion<Vuelo> avion2 = new Avion<>("Airbus 380");

        // Crear vuelos
        Vuelo vuelo1 = new Vuelo("COD11101", "American Airlines", "AVA01", "USA", 2, 5, 2020, 50, 30);
        Vuelo vuelo2 = new Vuelo("COD11102", "Copa Airlines", "AVA02", "Uruguay", 4, 5, 2021, 54, 36);
        Vuelo vuelo3 = new Vuelo("COD12101", "Iberia", "AVA03", "España", 7, 6, 2023, 50, 80);

        // Agregar vuelos a aviones
        avion1.agregarVuelo(vuelo1);
        avion2.agregarVuelo(vuelo2);
        avion2.agregarVuelo(vuelo3);

        // Mostrar información de los aviones y sus vuelos
        System.out.println("Avión 1:");
        avion1.mostrar();
        System.out.println("----------------------------");
        System.out.println("Avión 2:");
        avion2.mostrar();

        // Crear algunas aerolíneas y agregar aviones
        o.crearAerolinea("American Airlines", "Estados Unidos", 5);
        o.crearAerolinea("Pluna", "Uruguay", 3);
        o.crearAerolinea("Alas Uruguay", "Uruguay", 2);

        // Mostrar las aerolíneas antes de eliminar
        o.listarAerolineas();

        // Intentar eliminar una aerolínea que existe y no tiene aviones registrados
        Retorno resultado1 = o.eliminarAerolinea("Pluna");
        System.out.println("Resultado de eliminar Pluna: " + resultado1.resultado);

        // Intentar eliminar una aerolínea que no existe
        Retorno resultado2 = o.eliminarAerolinea("Iberia");
        System.out.println("Resultado de eliminar Iberia: " + resultado2.resultado);

        // Mostrar las aerolíneas después de eliminar
        o.listarAerolineas();

        // Registrar aviones
        System.out.println("\nRegistrando aviones...");
        Retorno resultadoRegistro1 = o.registrarAvion("AA001", 150, "American Airlines");
        Retorno resultadoRegistro2 = o.registrarAvion("PL001", 200, "Pluna");

        // Mostrar resultados del registro
        System.out.println("\nResultados del registro:");
        System.out.println("American Airlines: " + resultadoRegistro1.resultado);
        System.out.println("Pluna: " + resultadoRegistro2.resultado);

        // Mostrar información de los aviones después del registro
        System.out.println("\nAviones después de registrar en American Airlines:");
        o.listarAvionesDeAerolinea("American Airlines");
        System.out.println("\nAviones después de registrar en Pluna:");
        o.listarAvionesDeAerolinea("Pluna");

        // Eliminar avión de la aerolínea "Pluna"
        Retorno resultadoEliminarAvion = o.eliminarAvion("Pluna", "PL001");
        System.out.println("\nResultado de eliminar avión de Pluna: " + resultadoEliminarAvion.resultado);

        // Mostrar información de los aviones después de eliminar
        System.out.println("\nAviones de Pluna después de eliminar:");
        o.listarAvionesDeAerolinea("Pluna");

        // Mostrar aerolíneas
        o.listarAerolineas();

        // Registrar clientes
        System.out.println("\nRegistrando clientes...");
        Retorno resultadoRegistroCliente1 = o.registrarCliente("A123456", "Juan Perez", 30);
        Retorno resultadoRegistroCliente2 = o.registrarCliente("B234567", "Ana Gomez", -1);
        Retorno resultadoRegistroCliente3 = o.registrarCliente("C3456789", "Carlos Ruiz", 25);
        Retorno resultadoRegistroCliente4 = o.registrarCliente("D456789", "Lucia Fernandez", 45);
        Retorno resultadoRegistroCliente5 = o.registrarCliente("A123456", "Marta Silva", 35);

        // Mostrar resultados del registro de clientes
        System.out.println("\nResultados del registro de clientes:");
        System.out.println("Juan Perez: " + resultadoRegistroCliente1.resultado);
        System.out.println("Ana Gomez: " + resultadoRegistroCliente2.resultado);
        System.out.println("Carlos Ruiz: " + resultadoRegistroCliente3.resultado);
        System.out.println("Lucia Fernandez: " + resultadoRegistroCliente4.resultado);
        System.out.println("Marta Silva: " + resultadoRegistroCliente5.resultado);

        // Llamar al método crearVuelo con parámetros válidos
        Retorno resultadoCrearVuelo = o.crearVuelo("COD11101", "American Airlines", "AA001", "USA", 2, 5, 2020, 50, 30);

        // Mostrar el resultado del método crearVuelo
        System.out.println("Resultado de crear vuelo: " + resultadoCrearVuelo.resultado);

        // Crear un vuelo exitosamente
        Retorno resultadoCreacionVuelo = o.crearVuelo("COD404", "American Airlines", "AA001", "Argentina", 15, 7, 2024, 30, 15);
        System.out.println("\nResultado de crear vuelo: " + resultadoCreacionVuelo.resultado);

        // Mostrar las aerolíneas después de crear el vuelo
        o.listarAerolineas();
    }
}