package dominio;

import java.time.LocalDate;

public interface PoliticaDeCancelacion {
	
	double getMontoAReembolsar(Reserva reserva, LocalDate fecha, double precioPorNoche);

}
