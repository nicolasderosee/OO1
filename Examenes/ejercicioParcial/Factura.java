package ar.edu.unlp.info.oo1.ejercicioParcial;

import java.time.LocalDate;
import java.util.List;

public class Factura {
	
	private LocalDate fechaEmision;
	private LocalDate fechaExp;
	private List<Item> items;
	
	
	public Factura(LocalDate fechaExp, List<Item> items) {
		this.fechaEmision = LocalDate.now();
		this.fechaExp = fechaExp;
		this.items = items;
	}
	
	public double costoBasico() {
		if (this.items.isEmpty()) {
			return 0;
		}
		return this.items.stream()
				.mapToDouble(i -> i.getMontoTotal())
				.sum();
	}
	
	public double costoExportacion() {
		return this.costoBasico() * 0.05;
	}
	
	public double costoFinal() {
		return this.costoBasico() + this.costoExportacion();
	}
	
	public boolean periodoFactura (LocalDate inicio, LocalDate fin) {
		DateLapse dl = new DateLapse(inicio,fin);
		return dl.includesDate(this.fechaEmision);
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public LocalDate getFechaExp() {
		return fechaExp;
	}

	public List<Item> getItems() {
		return items;
	}
}
