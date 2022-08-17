package dominio;

import java.time.LocalDate;

public class Reserva {
	
	private DateLapse periodoOcupado;
	private Usuario inquilino; 

	public Reserva(DateLapse periodo, Usuario inquilino) {
		this.inquilino = inquilino; 
		this.periodoOcupado = periodo;
	} 
	
	public boolean mismoInquilino(Usuario inquilino) {
		return this.inquilino.equals(inquilino);
	}
	
	public boolean noEstaLibre(DateLapse periodo) { 
		return this.periodoOcupado.overlaps(periodo); // si solapan, se retorna true del overlapse entonces no esta libre 
	}
	
	public double calcularPrecio(double precioXNoche) {
		return precioXNoche * this.periodoOcupado.sizeInDays();
		
	}
	
	public double obtenerPrecioEntreFechas(LocalDate fechaInicio, LocalDate fechaFin, double precioXNoche) {
		if(this.periodoOcupado.includesDate(fechaInicio) && (this.periodoOcupado.includesDate(fechaFin))) {
			DateLapse periodo = new DateLapse(fechaInicio, fechaFin);
			return periodo.sizeInDays() * precioXNoche; 
		}
		return 0d;
	}
	
	
	public Usuario getInquilino() {
		return this.inquilino;
	}
	
	public DateLapse getPeriodo() {
		return this.periodoOcupado;
	}
	
	
	public boolean evaluarFecha() {
		return this.periodoOcupado.esPosterior();
	}
	
	
	


}
