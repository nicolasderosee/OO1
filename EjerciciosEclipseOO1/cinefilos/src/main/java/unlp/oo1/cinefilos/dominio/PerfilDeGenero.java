package unlp.oo1.cinefilos.dominio;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class PerfilDeGenero {

    double accion;
    double suspenso;
    double romance;
    double sciFi;
    double horror;
    double comedia;

    public PerfilDeGenero(double accion, double suspenso, double romance, double sciFi, double horror, double comedia) {
        this.accion = accion;
        this.suspenso = suspenso;
        this.romance = romance;
        this.sciFi = sciFi;
        this.horror = horror;
        this.comedia = comedia;
    }

    public static PerfilDeGenero neutral() {
        return new PerfilDeGenero(4.5,4.5, 4.5, 4.5, 4.5, 4.5);
    }

    public static PerfilDeGenero todoCero() {
        return new PerfilDeGenero(0d,0d,0d,0d,0d,0d);
    }

    public static PerfilDeGenero promediando(List<PerfilDeGenero> perfilesAPromediar) {
        double accion = perfilesAPromediar.stream().mapToDouble(perfil -> perfil.getAccion()).average().getAsDouble();
        double suspenso = perfilesAPromediar.stream().mapToDouble(perfil -> perfil.getSuspenso()).average().getAsDouble();
        double romance = perfilesAPromediar.stream().mapToDouble(perfil -> perfil.getRomance()).average().getAsDouble();
        double sciFi = perfilesAPromediar.stream().mapToDouble(perfil -> perfil.getSciFi()).average().getAsDouble();
        double horror = perfilesAPromediar.stream().mapToDouble(perfil -> perfil.getHorror()).average().getAsDouble();
        double comedia = perfilesAPromediar.stream().mapToDouble(perfil -> perfil.getComedia()).average().getAsDouble();
        return new PerfilDeGenero(accion, suspenso, romance, sciFi, horror, comedia);
    }

    public static PerfilDeGenero todoAlMaximo() {
        return new PerfilDeGenero(9,9, 9, 9, 9, 9);
    }

    public double getAccion() {
        return accion;
    }

    public double getSuspenso() {
        return suspenso;
    }

    public double getRomance() {
        return romance;
    }

    public double getSciFi() {
        return sciFi;
    }

    public double getHorror() {
        return horror;
    }

    public double getComedia() {
        return comedia;
    }

    public boolean sosParecidoA(PerfilDeGenero otro, double umbral) {
        double diferencia = abs(accion - otro.getAccion()) + abs(suspenso - otro.getSuspenso()) + abs(romance - otro.getRomance()) +
                abs(sciFi - otro.getSciFi()) + abs(horror - otro.getHorror()) + abs(comedia - otro.getComedia());
        return (diferencia <= umbral);
    }

    @Override
    public boolean equals(Object otroObjeto) {
        if ( otroObjeto == null) {
            return false;
        }
        if ( otroObjeto.getClass() != this.getClass()) {
            return false;
        }
        final PerfilDeGenero otroPerfil = (PerfilDeGenero)  otroObjeto;
        return (accion == otroPerfil.getAccion()) & (suspenso == otroPerfil.getSuspenso()) & (romance == otroPerfil.getRomance())
                & (sciFi == otroPerfil.getSciFi()) & (horror == otroPerfil.getHorror()) & (comedia == otroPerfil.getComedia());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accion, suspenso, romance, sciFi, horror, comedia);
    }
}
