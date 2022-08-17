package ar.edu.unlp.info.oo1.ejercicio14IntervaloDeTiempo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataLapse {
	
	private LocalDate from;
    private LocalDate to;
    
   
	public DataLapse(LocalDate from, LocalDate to) {
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

}
