package unlp.oo1.cinefilos.dominio;

public interface Perfilable {

    PerfilDeGenero getPerfil();

    Boolean sosParecidoA(Perfilable otro, double ubral);

}
