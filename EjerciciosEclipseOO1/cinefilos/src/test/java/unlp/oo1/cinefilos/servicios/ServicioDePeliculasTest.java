package unlp.oo1.cinefilos.servicios;

import org.junit.Before;
import org.junit.Test;
import unlp.oo1.cinefilos.dominio.Cinefilo;
import unlp.oo1.cinefilos.dominio.Pelicula;
import unlp.oo1.cinefilos.dominio.PerfilDeGenero;

import static org.junit.Assert.*;

public class ServicioDePeliculasTest {

    ServicioDePeliculas servicioDePeliculas;
    ServicioDeCinefilos servicioDeCinefilos;
    Pelicula unaPeli, unaParecida, unaDistinta;
    Cinefilo juan;

    @Before
    public void setUp() throws Exception {
        servicioDeCinefilos = new ServicioDeCinefilos();
        servicioDePeliculas = new ServicioDePeliculas();
        unaPeli = servicioDePeliculas.cargarPelicula("Una Peli",
                "http://imdb.com/una-peli",
                "http://imdb.com/una-peli.png",
                PerfilDeGenero.todoCero());
        unaParecida = servicioDePeliculas.cargarPelicula("Una Parecida",
                "http://imdb.com/una-peli-parecida",
                "http://imdb.com/una-peli-parecida.png",
                new PerfilDeGenero(ServicioDePeliculas.UMBRAL_DE_SIMILITUD_ENTRE_PELICULAS, 0, 0, 0, 0, 0));
        unaDistinta = servicioDePeliculas.cargarPelicula("Una Distinta",
                "http://imdb.com/una-peli-distinta",
                "http://imdb.com/una-peli-distinta.png",
                new PerfilDeGenero(ServicioDePeliculas.UMBRAL_DE_SIMILITUD_ENTRE_PELICULAS, 1, 0, 0, 0, 0));
        juan = servicioDeCinefilos.registrarCinefilo("Juan Carlos Batman", "juan@batman.com");
    }

    @Test
    public void testGetPeliculasSimilares() {
        assertTrue(servicioDePeliculas.getPeliculasSimilares(unaPeli).contains(unaPeli));
        assertTrue(servicioDePeliculas.getPeliculasSimilares(unaPeli).contains(unaParecida));
        assertEquals(2, servicioDePeliculas.getPeliculasSimilares(unaPeli).size());
    }

    @Test
    public void testGetPeliculasParaVer() {
        // No vió nada, no encuentro nada (las que tengo no son parecidas)
        assertTrue(servicioDePeliculas.getPeliculasParaVer(juan).isEmpty());
        // Vio una, le doy una parecida
        juan.marcarComoVista(unaPeli);
        // Juan queda en 2.25, 2.25, 2.25, 2.25, 2.25, 2.25
        Pelicula unaParaJuan = servicioDePeliculas.cargarPelicula("Otra para Juan","http://imdb.com/para-juan",
                "http://imdb.com/para-juana.png",
                new PerfilDeGenero(3.25, 3.25, 3.25, 3.25, 3.25, 3.25));
        assertEquals(1, servicioDePeliculas.getPeliculasParaVer(juan).size());
        assertTrue(servicioDePeliculas.getPeliculasParaVer(juan).contains(unaParaJuan));
    }
}
