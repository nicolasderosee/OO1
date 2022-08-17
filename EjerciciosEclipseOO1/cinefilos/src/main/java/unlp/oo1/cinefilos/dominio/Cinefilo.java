package unlp.oo1.cinefilos.dominio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cinefilo implements Perfilable {

    private String nombreCompleto;
    private String email;
    private Set<Pelicula> peliculasVistas;

    public Cinefilo(String nombreCompleto, String email) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.peliculasVistas = new HashSet<Pelicula>();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Pelicula> getPeliculasVistas() {
        return peliculasVistas;
    }

    public boolean vio(Pelicula pelicula) {
        return peliculasVistas.contains(pelicula);
    }

    public void marcarComoVista(Pelicula pelicula) {
        peliculasVistas.add(pelicula);
    }

    public PerfilDeGenero getPerfil() {
        if (peliculasVistas.isEmpty()) {
            return PerfilDeGenero.neutral();
        } else {
            List<PerfilDeGenero> perfilesDeLasPeliculasVistas = peliculasVistas.stream()
                    .map(pelicula -> pelicula.getPerfil())
                    .collect(Collectors.toList());
            perfilesDeLasPeliculasVistas.add(PerfilDeGenero.neutral());
            return PerfilDeGenero.promediando(perfilesDeLasPeliculasVistas);
        }
    }

    @Override
    public Boolean sosParecidoA(Perfilable otro, double umbral) {
        return this.getPerfil().sosParecidoA(otro.getPerfil(), umbral);
    }


}
