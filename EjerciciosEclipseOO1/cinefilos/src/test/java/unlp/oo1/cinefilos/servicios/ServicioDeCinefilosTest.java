package unlp.oo1.cinefilos.servicios;

import org.junit.Before;
import org.junit.Test;
import unlp.oo1.cinefilos.dominio.Cinefilo;
import unlp.oo1.cinefilos.dominio.Pelicula;
import unlp.oo1.cinefilos.dominio.PerfilDeGenero;

import static org.junit.Assert.*;

public class ServicioDeCinefilosTest {

    private ServicioDeCinefilos servicioDeCinefilos, servicioDeCinefilosSinCinefilos;
    private ServicioDePeliculas servicioDePeliculas;
    private Cinefilo unCinefilo, otroCinefilo;
    private Pelicula harryPotter;

    @Before
    public void setUp() {
        servicioDeCinefilosSinCinefilos = new ServicioDeCinefilos();
        servicioDeCinefilos = new ServicioDeCinefilos();
        servicioDePeliculas = new ServicioDePeliculas();
        unCinefilo = servicioDeCinefilos.registrarCinefilo("Cinefilo Uno", "uno@gmail.com");
        otroCinefilo = servicioDeCinefilos.registrarCinefilo("Cinefilo Dos", "dos@gmail.com");
        harryPotter = servicioDePeliculas.cargarPelicula("Harry Postre", "http://harry/",
                "http://harry/imagen.png", PerfilDeGenero.todoCero());
    }

    @Test
    public void testCinefilosQueVieron() {
        // no hay cinefilos
        assertTrue(servicioDeCinefilosSinCinefilos.cinefilosQueVieron(harryPotter).isEmpty());
        // hay cinefilos y ninguno la vió
        assertTrue(servicioDeCinefilos.cinefilosQueVieron(harryPotter).isEmpty());
        // hay dos, pero solo uno la vió
        unCinefilo.marcarComoVista(harryPotter);
        assertEquals(1, servicioDeCinefilos.cinefilosQueVieron(harryPotter).size());
        assertTrue(servicioDeCinefilos.cinefilosQueVieron(harryPotter).contains(unCinefilo));
    }

    @Test
    public void testCinefilosParecidos() {
        assertEquals(1, servicioDeCinefilos.cinefilosParecidos(unCinefilo).size());
        assertTrue(servicioDeCinefilos.cinefilosParecidos(unCinefilo).contains(otroCinefilo));
        unCinefilo.marcarComoVista(harryPotter);
        assertTrue(servicioDeCinefilos.cinefilosParecidos(unCinefilo).isEmpty());
    }
}
