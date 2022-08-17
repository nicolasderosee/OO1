package dominio;

import java.time.LocalDate;

public class Flexible implements PoliticaDeCancelacion {

	@Override
	public double getMontoAReembolsar(Reserva reserva, LocalDate fecha, double precioPorNoche) {
		if(reserva.evaluarFechaAnterior(fecha)) {
			return reserva.calcularPrecio(precioPorNoche);
		}
		return 0d;
	}



}
