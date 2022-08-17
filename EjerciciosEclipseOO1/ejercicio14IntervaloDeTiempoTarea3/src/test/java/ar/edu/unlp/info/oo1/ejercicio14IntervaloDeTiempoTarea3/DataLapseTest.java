package ar.edu.unlp.info.oo1.ejercicio14IntervaloDeTiempoTarea3;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLapseTest {
	
	private DataLapse lapso;
	private LocalDate fechaInicio, fechaFin;
	
	@BeforeEach
	public void setUp() {
		this.fechaInicio = LocalDate.of(2020, 10, 1);
		this.fechaFin = LocalDate.of(2021, 10, 1);
		this.lapso = new DataLapse(fechaInicio, fechaFin);
		
	}

	@Test
	void testGetFrom() {
		assertEquals(fechaInicio, this.lapso.getFrom());
	}
	
	@Test 
	void testGetTo(){
		assertEquals(fechaFin, this.lapso.getTo());
	}
	
	@Test
	void testSizeInDays() {
		assertEquals(365, this.lapso.sizeInDays());
	}
	
	@Test
	void testIncludesDate() {
		
		assertTrue(this.lapso.includesDate(LocalDate.of(2020, 12, 31)));
		assertTrue(this.lapso.includesDate(LocalDate.of(2020, 10, 1)));
		assertTrue(this.lapso.includesDate(LocalDate.of(2021, 10, 1)));
		assertFalse(this.lapso.includesDate(LocalDate.of(2020, 9, 30)));
		assertFalse(this.lapso.includesDate(LocalDate.of(2021, 11, 1)));
		
	}

}


