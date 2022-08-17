package ar.edu.unlp.info.oo1.ejercicio14IntervaloDeTiempoTarea3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataLapse {
	
	private LocalDate from;
    private int sizeInDays;
    
   
	public DataLapse(LocalDate from, LocalDate to) {
		this.asignarLapso(from, to);
	}
	
	private void asignarLapso(LocalDate fecha1, LocalDate fecha2) {
		if(fecha2.isBefore(fecha1)) {
			this.asignarLapso(fecha2, fecha1);
	    }
		this.from = fecha1;
		this.sizeInDays = (int) ChronoUnit.DAYS.between(fecha1, fecha2);
	}

	public LocalDate getFrom() {
		return this.from;
	}
	
	
	public LocalDate getTo() {
		return this.from.plusDays(this.sizeInDays);
	}
	

	public int sizeInDays() {
		return this.sizeInDays;
	}
    
	public boolean includesDate(LocalDate other) {
		return (other.isAfter(this.getFrom()) && other.isBefore(this.getTo())) || (other.isEqual(this.from) || other.isEqual(this.getTo()));
	}

}

