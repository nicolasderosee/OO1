package unlp.oo1.cinefilos.servicios;

import unlp.oo1.cinefilos.dominio.Cinefilo;
import unlp.oo1.cinefilos.dominio.Pelicula;
import unlp.oo1.cinefilos.dominio.PerfilDeGenero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioDePeliculas {

    public static final double UMBRAL_DE_SIMILITUD_ENTRE_PELICULAS = 6;
    private final List<Pelicula> peliculas;

    public ServicioDePeliculas() {
        peliculas = new ArrayList<>();
    }

    Pelicula cargarPelicula(String titulo, String urlDeImdb, String urlDeImagen) {
        return this.cargarPelicula(titulo, urlDeImdb, urlDeImagen, PerfilDeGenero.todoCero());
    }

    Pelicula cargarPelicula(String titulo, String urlDeImdb, String urlDeImagen, PerfilDeGenero perfil) {
        final Pelicula pelicula = new Pelicula(titulo, urlDeImdb, urlDeImagen, perfil);
        peliculas.add(pelicula);
        return pelicula;
    }

    List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Pelicula> getPeliculasSimilares(Pelicula unaPeli) {
        return peliculas.stream()
                .filter(peli -> peli.sosParecidoA(unaPeli, UMBRAL_DE_SIMILITUD_ENTRE_PELICULAS))
                .collect(Collectors.toList());
    }

    public List<Pelicula> getPeliculasParaVer(Cinefilo cinefilo) {
        return peliculas.stream().filter(peli ->
                peli.sosParecidoA(cinefilo, UMBRAL_DE_SIMILITUD_ENTRE_PELICULAS) & !cinefilo.vio(peli)
        ).collect(Collectors.toList());
    }
}
