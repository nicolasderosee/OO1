package unlp.oo1.cinefilos.servicios;

import unlp.oo1.cinefilos.dominio.Cinefilo;
import unlp.oo1.cinefilos.dominio.Pelicula;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioDeCinefilos {


    private final List<Cinefilo> cinefilos;

    public ServicioDeCinefilos() {
        cinefilos = new ArrayList<>();
    }

    public List<Cinefilo> getCinefilos() {
        return cinefilos;
    }

    public Cinefilo registrarCinefilo(String nombreCompleto, String email) {
        Cinefilo cinefilo = new Cinefilo(nombreCompleto, email);
        cinefilos.add(cinefilo);
        return cinefilo;
    }

    public List<Cinefilo> cinefilosQueVieron(final Pelicula pelicula) {
        return cinefilos.stream()
        		.filter(cinefilo -> cinefilo.vio(pelicula))
        		.collect(Collectors.toList());
    }

    public List<Cinefilo> cinefilosParecidos(Cinefilo cinefilo) {
        return cinefilos.stream()
                .filter(otro -> otro.sosParecidoA(cinefilo,ServicioDePeliculas.UMBRAL_DE_SIMILITUD_ENTRE_PELICULAS) 
                		& otro != cinefilo)
                .collect(Collectors.toList());
    }
}
