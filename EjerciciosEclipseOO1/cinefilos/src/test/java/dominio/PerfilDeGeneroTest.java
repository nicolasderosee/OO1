package dominio;

import org.junit.Before;
import org.junit.Test;
import unlp.oo1.cinefilos.dominio.PerfilDeGenero;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PerfilDeGeneroTest {

    List<PerfilDeGenero> perfiles;

    @Before
    public void setUp() throws Exception {
        perfiles = new ArrayList<>();
    }

    @Test
    public void testEquals() {
        assertEquals(new PerfilDeGenero(1,2,3,4,5,6), new PerfilDeGenero(1,2,3,4,5,6));
        assertNotEquals(PerfilDeGenero.todoCero(), new PerfilDeGenero(1,2,3,4,5,6));
    }

    @Test
    public void testSosParecidoA() {
        PerfilDeGenero uno = PerfilDeGenero.todoCero();
        PerfilDeGenero otro = new PerfilDeGenero(1,1,1,1,1,1);
        assertTrue(uno.sosParecidoA(otro,6));
        assertFalse(uno.sosParecidoA(otro, 5));
    }

    @Test
    public void testPromediando_unoSolo() {
        perfiles.add(PerfilDeGenero.todoCero());
        assertEquals(PerfilDeGenero.todoCero(), PerfilDeGenero.promediando(perfiles));
    }

    @Test
    public void testPromediando_dosPerfiles() {
        perfiles.add(PerfilDeGenero.todoCero());
        perfiles.add(PerfilDeGenero.todoAlMaximo());
        assertEquals(PerfilDeGenero.neutral(), PerfilDeGenero.promediando(perfiles));
    }


}
