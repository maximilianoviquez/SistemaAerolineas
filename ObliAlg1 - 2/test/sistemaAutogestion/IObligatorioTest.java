package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IObligatorioTest {

    private Obligatorio miSistema;

    public IObligatorioTest() {
    }

    @Before
    public void setUp() {
        miSistema = new Obligatorio();
        miSistema.crearSistemaDeGestion();
    }

    @Test
    public void testCrearAerolineaOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", -3);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("TAP Portugal");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA700", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 18, "Aerolineas Argentinas");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 3, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 14, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR3() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Porter Airlines");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
        assertEquals(Retorno.ok().resultado, r.resultado);
}
    @Test
public void testEliminarAvionERROR1() {
    Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Iberia", "España", 20);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
    assertEquals(Retorno.ok().resultado, r.resultado);

    r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.registrarAvion("IB800", 21, "Iberia");
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.eliminarAvion("Gol Brasil", "AA345");
    assertEquals(Retorno.error1().resultado, r.resultado);
}

@Test
public void testEliminarAvionERROR2() {
    Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Iberia", "España", 20);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
    assertEquals(Retorno.ok().resultado, r.resultado);

    r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.registrarAvion("IB800", 21, "Iberia");
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.eliminarAvion("Aerolineas Argentinas", "YY111");
    assertEquals(Retorno.error2().resultado, r.resultado);
}

@Test
public void testListarAerolineas() {
    Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Iberia", "España", 20);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.listarAerolineas();
    assertEquals("1-Aerolineas Argentinas-10-|\n2-Iberia-20-|\n3-Delta Air Lines-30-|\n4-Copa Airlines-30-|", r.valorString);
}

@Test
public void testListarAvionesDeAerolinea() {
    Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Iberia", "España", 20);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
    assertEquals(Retorno.ok().resultado, r.resultado);

    r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.registrarAvion("IB563", 21, "Iberia");
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
    assertEquals(Retorno.ok().resultado, r.resultado);

    r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
    assertEquals("AA345-12-|\nAA311-21-|", r.valorString);
}

@Test
public void testRegistrarCliente() {
    Retorno r = miSistema.registrarCliente("1234567", "Juan Perez", 25);
    assertEquals(Retorno.ok().resultado, r.resultado);
}

@Test
public void testCrearVuelo() {
    Retorno r = miSistema.crearVuelo("AA123", "Aerolineas Argentinas", "AA345", "Estados Unidos", 10, 6, 2024, 6, 6);
    assertEquals(Retorno.ok().resultado, r.resultado);
}

@Test
public void testComprarPasaje() {
    Retorno r = miSistema.comprarPasaje("1234567", "AA123", 1);
    assertEquals(Retorno.ok().resultado, r.resultado);
}

@Test
public void testDevolverPasaje() {
    Retorno r = miSistema.devolverPasaje("1234567", "AA123");
    assertEquals(Retorno.ok().resultado, r.resultado);
}

@Test
public void testListarClientes() {
    Retorno r = miSistema.registrarCliente("1234567", "Juan Perez", 25);
    assertEquals(Retorno.ok().resultado, r.resultado);
    r = miSistema.listarClientes();
    assertEquals("Juan Perez-1234567-25|", r.valorString);
}

@Test
public void testListarVuelos() {
    miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
    miSistema.crearVuelo("AA123", "Aerolineas Argentinas", "AA345", "Estados Unidos", 10, 6, 2024, 6, 6);

    Retorno r = miSistema.listarVuelos();
    assertEquals("AA123-Aerolineas Argentinas-AA345-Estados Unidos-10-6-2024-6-6-|", r.valorString);
}

@Test
public void testVuelosDeCliente() {
    miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
    miSistema.crearVuelo("AA123", "Aerolineas Argentinas", "AA345", "Estados Unidos", 10, 6, 2024, 6, 6);
    miSistema.registrarCliente("1234567", "Juan Perez", 25);
    miSistema.comprarPasaje("1234567", "AA123", 1);

    Retorno r = miSistema.vuelosDeCliente("1234567");
    assertEquals("AA123-CPR|", r.valorString);
}

@Test
public void testPasajesDevueltos() {
    miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
    miSistema.crearVuelo("AA123", "Aerolineas Argentinas", "AA345", "Estados Unidos", 10, 6, 2024, 6, 6);
    miSistema.registrarCliente("1234567", "Juan Perez", 25);
    miSistema.comprarPasaje("1234567", "AA123", 1);
    miSistema.devolverPasaje("1234567", "AA123");

    Retorno r = miSistema.pasajesDevueltos("Aerolineas Argentinas");
    assertEquals("1234567-AA123|", r.valorString);
}

@Test
public void testVistaDeVuelo() {
    miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
    miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
    miSistema.crearVuelo("AA123", "Aerolineas Argentinas", "AA345", "Estados Unidos", 10, 6, 2024, 6, 6);
    miSistema.registrarCliente("1234567", "Juan Perez", 25);
    miSistema.comprarPasaje("1234567", "AA123", 1);

    Retorno r = miSistema.vistaDeVuelo("AA123");
    assertEquals("**********************************\n* PRIMERA *\n**********************************\n* 1234567 * XXXXXXXX * XXXXXXXX *\n**********************************\n* XXXXXXXX * XXXXXXXX * XXXXXXXX *\n**********************************\n* ECONÓMICA *\n**********************************\n* XXXXXXXX * XXXXXXXX * XXXXXXXX *\n**********************************", r.valorString);
}

}