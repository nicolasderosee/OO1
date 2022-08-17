package servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dominio.Propiedad;
import dominio.Reserva;
import dominio.Usuario;
import dominio.DateLapse; 

public class servicioDePropiedades {
	
	private final List <Propiedad> propiedades; 
	
	public servicioDePropiedades() { 
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	public List<Propiedad> getPropiedades(){
		return this.propiedades; 
	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, double precioPorNoche, String direccion, Usuario propietario) {
		Propiedad propiedad = new Propiedad (nombre,descripcion,precioPorNoche,direccion,propietario);
		propiedades.add(propiedad);
		return propiedad; 
	}
	
	public List<Propiedad> buscarPropiedadesDisponibles(DateLapse periodo){
		return this.getPropiedades()
				.stream()
				.filter(p -> !p.noEstaDisponible(periodo))
				.collect(Collectors.toList());
	}                              
	
	public Reserva hacerReserva(Propiedad p, Usuario inquilino, DateLapse periodo) {
		if (this.propiedades.contains(p)) {
			return p.hacerReserva(periodo, inquilino);
		}
		return null;
	}
	
	public List<Reserva> obtenerReservasDeUsuarios(Usuario inquilino){
		List<Reserva> reservasUsuario = new ArrayList<>();
		this.getPropiedades().stream().forEach(p -> reservasUsuario.addAll(p.reservasDeUsuario(inquilino)));
		return reservasUsuario; 
	}
	
	
	public List<Propiedad> obtenerPropiedadesDeUsuario(Usuario propietario){
		return this.getPropiedades()
				.stream()
				.filter(p -> p.propiedadDeUsuario(propietario))
				.collect(Collectors.toList());
	}
	
	public double calcularIngresosPropietario(Usuario propietario, LocalDate fechaInicio, LocalDate fechaFin) {
		List<Propiedad> propiedadesUsuario = this.obtenerPropiedadesDeUsuario(propietario);
		return
				propiedadesUsuario
				.stream()
				.mapToDouble(p -> p.obtenerTotalPorReserva(fechaInicio, fechaFin))
				.sum();
	}
	 
	
	/*public List<Reserva> obtenerReservasDeUsuarios(Usuario inquilino){
	  return this.propiedades
			.stream()
			.flatMap(p -> p.reservasDeUsuario(inquilino).stream()).collect(Collectors.toList());		
	  }
    */
	
	
	
	
	
}

