package unlp.oo1.cinefilos.dominio;

public class Pelicula implements Perfilable {

    private String titulo;
    private String urlDeImdb;
    private String getUrlDeImagen;
    private PerfilDeGenero perfil;

    public Pelicula(String titulo, String urlDeImdb, String urlDeImagen, PerfilDeGenero perfil) {
        this.titulo = titulo;
        this.urlDeImdb = urlDeImdb;
        this.getUrlDeImagen = urlDeImagen;
        this.perfil = perfil;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlDeImdb() {
        return urlDeImdb;
    }

    public String getGetUrlDeImagen() {
        return getUrlDeImagen;
    }

    @Override
    public PerfilDeGenero getPerfil() {
        return perfil;
    }

    @Override
    public Boolean sosParecidoA(Perfilable otro, double umbral) {
        return this.perfil.sosParecidoA(otro.getPerfil(), umbral);
    }
}
