package dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
	
	private LocalDate from;
    private LocalDate to;
    
   
	public DateLapse(LocalDate from, LocalDate to) {
		this.asignarLapso(from, to);
	}
	
	private void asignarLapso(LocalDate fecha1, LocalDate fecha2) {
		if(fecha1.isBefore(fecha2)) {
			this.from = fecha1;
			this.to = fecha2;
		}
		else {
			this.from = fecha2;
			this.to = fecha1;
		}
	}

	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}

	public int sizeInDays() {
		return  (int) ChronoUnit.DAYS.between(this.from, this.to);
	}
	
    
	public boolean includesDate(LocalDate other) {
		return (other.isAfter(this.getFrom()) && other.isBefore(this.getTo())) || (other.isEqual(this.getFrom()) || other.isEqual(this.getTo()));
	}

	//si se cumple, retorna false (no solapan) 
	//si no se cumple, retorna true (solapan en algun lado) 
	public boolean overlaps(DateLapse periodo) {
		return !(periodo.getTo().isBefore(this.getFrom()) || periodo.getFrom().isAfter(this.getTo())); //devuelve true cuando solapan y false caso contrario 
	}
	
	public boolean esPosterior() {
		return this.getFrom().isAfter(LocalDate.now());
	}
	
	public boolean esAnterior(LocalDate fecha) {
		return fecha.isBefore(this.getFrom());
	}
	
	public boolean diasAntes(LocalDate fecha, int num) {
		int cantDias = (int) ChronoUnit.DAYS.between(fecha, this.getFrom());
		return cantDias <= num; 
	}
	

}

