package dominio;

import java.time.LocalDate;

public class Moderada implements PoliticaDeCancelacion {

	@Override
	public double getMontoAReembolsar(Reserva reserva, LocalDate fecha, double precioPorNoche) {
		if(reserva.evaluarFecha(fecha, 7)) {
			return reserva.calcularPrecio(precioPorNoche);
		}
		if(reserva.evaluarFecha(fecha, 2)) {
			return reserva.calcularPrecio(precioPorNoche) * 0.50d;
		}
		return 0d;
	}



}
