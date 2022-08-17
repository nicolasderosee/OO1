package ar.edu.unlp.info.oo1.ejercicioParcial;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {

	private LocalDate from;
	private LocalDate to;
	
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.asignarLapso(from, to);
	}
	
	private void asignarLapso (LocalDate fecha1, LocalDate fecha2) {
		if (fecha1.isBefore(fecha2)) {
			this.from = fecha1;
			this.to = fecha2;
		}
		else {
			this.from = fecha2;
			this.to = fecha1;
		}
	}
	
	public int sizeInDays () {
		return (int) ChronoUnit.DAYS.between(this.from, this.to) + 1;
	}
	
	public boolean includesDate (LocalDate other) {
		return (other.isAfter(this.from) && other.isBefore(to)) || (other.isEqual(this.from) || other.isEqual(this.to));
	}
	
	
	public boolean overlapse (DateLapse other) {
		return ( (this.includesDate(other.getFrom()) || this.includesDate(other.getTo())) || (other.includesDate(this.getFrom()) || other.includesDate(this.getTo())));
	}
	
	
	public LocalDate getFrom() {
		return from;
	}
	public void setFrom(LocalDate from) {
		this.from = from;
	}
	public LocalDate getTo() {
		return to;
	}
	public void setTo(LocalDate to) {
		this.to = to;
	}
	
	
	
}
