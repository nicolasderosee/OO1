package dominio;

import org.junit.Before;
import org.junit.Test;
import unlp.oo1.cinefilos.dominio.Cinefilo;
import unlp.oo1.cinefilos.dominio.Pelicula;
import unlp.oo1.cinefilos.dominio.PerfilDeGenero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CinefiloTest {

    private Cinefilo cinefilo;
    private Pelicula pelicula;

    @Before
    public void setUp() {
        cinefilo = new Cinefilo("Juan Carlos Batman", "batman@gmail.com");
        pelicula = new Pelicula("Harry Postre", "http://testurl/", "http://testurl/imagen.png", PerfilDeGenero.todoCero());
    }

    @Test
    public void testMarcarComoVista() { //testo el marcarComoVista y el vio 
        cinefilo.marcarComoVista(pelicula);
        assertTrue(cinefilo.vio(pelicula));
        assertEquals(1, cinefilo.getPeliculasVistas().size());
        cinefilo.marcarComoVista(pelicula);
        assertEquals(1, cinefilo.getPeliculasVistas().size()); //sigue siendo 1 porque la pelicula es la misma y el set solo la agrega una vez 
    }

    @Test
    public void testGetPerfilDeGenero() {
        assertEquals(new PerfilDeGenero(4.5, 4.5, 4.5, 4.5, 4.5, 4.5), cinefilo.getPerfil());
        cinefilo.marcarComoVista(pelicula);
        assertEquals(new PerfilDeGenero(4.5 / 2, 4.5 / 2, 4.5 / 2, 4.5 / 2, 4.5 / 2, 4.5 / 2),
                cinefilo.getPerfil());
    }

}
