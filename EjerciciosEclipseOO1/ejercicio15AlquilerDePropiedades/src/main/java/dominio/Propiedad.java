package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Propiedad {
	
	private String nombre;
	private String descripcion;
	private double precioPorNoche;
	private String direccion;
	private Usuario propietario;
	private List <Reserva> reservas; 
	
	
	public Propiedad(String nombre, String descripcion, double precioPorNoche, String direccion, Usuario propietario) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioPorNoche = precioPorNoche;
		this.direccion = direccion;
		this.propietario = propietario;
		this.reservas = new ArrayList<Reserva>();
	}
	
	
	private void agregarReservas(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	
	public Reserva hacerReserva(DateLapse periodo, Usuario inquilino) {
		if(this.noEstaDisponible(periodo)) {
			return null; 
		}
		Reserva reserva = new Reserva(periodo, inquilino); 
		this.agregarReservas(reserva);
		return reserva;	
	}
	
	
	//busco si alguna no esta disponible
	public boolean noEstaDisponible(DateLapse periodo) { 
		return reservas
				.stream()
				.filter(r -> r.noEstaLibre(periodo)).findFirst().isPresent(); //devuelve primera reserva para la cual no esta libre. Si existe la reserva quiere decir que no esta disponible  
	}
	
	
	public void eliminarReserva (Reserva reserva) { 
		if(reserva.evaluarFecha()) {
				this.reservas.remove(reserva);
		}
	}
	
	
	public List<Reserva> reservasDeUsuario (Usuario user){
		return this.reservas
				.stream()
				.filter(r -> r.mismoInquilino(user)) 
				.collect(Collectors.toList());
	}
	
	
	public double obtenerTotalPorReserva(LocalDate fecha1, LocalDate fecha2) {
		return reservas
				.stream()
				.mapToDouble(r -> r.obtenerPrecioEntreFechas(fecha1,fecha2,this.getPrecioPorNoche()))
				.sum(); 
	}
	
	
	public boolean propiedadDeUsuario(Usuario propietario){
		return this.propietario.equals(propietario);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public Usuario getPropietario() {
		return this.propietario;
	}
	
	public List<Reserva> getReservas(){
		return this.reservas;
	}
	
	
	

}
