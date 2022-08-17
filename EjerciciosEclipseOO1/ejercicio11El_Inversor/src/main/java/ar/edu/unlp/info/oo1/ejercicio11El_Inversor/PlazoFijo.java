package ar.edu.unlp.info.oo1.ejercicio11El_Inversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion {
	
	LocalDate fechaDeConstitucion;
	double montoDepositado;
	double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fechaDeConstitucion, double montoDepositado, double porcentajeDeInteresDiario) {
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}

	public LocalDate getFechaDeConstitucion() {
		return this.fechaDeConstitucion;
	}
	
	public double getMontoDepositado() {
		return this.montoDepositado;
	}
	
	public double getPorcentajeDeInteresDiario() {
		return this.porcentajeDeInteresDiario;
	}

	@Override
	public double valorActual() {
		long diferencia = ChronoUnit.DAYS.between(LocalDate.now(), this.fechaDeConstitucion);
		return this.montoDepositado + (this.montoDepositado * diferencia * (this.porcentajeDeInteresDiario/100));
	}
	
	


}
