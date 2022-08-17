package dominio;

import java.time.LocalDate;

public class Estricta implements PoliticaDeCancelacion{

	@Override
	public double getMontoAReembolsar(Reserva reserva, LocalDate fecha, double precioPorNoche) {
		return 0;
	}

	
}
