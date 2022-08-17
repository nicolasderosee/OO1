package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArchivoTest {
	
	private Archivo archivo;
	
	@BeforeEach
	public void setUp() {
		this.archivo = new Archivo("archivoAdjunto");
	}

	@Test
	void testNombre() {
		assertEquals("archivoAdjunto",this.archivo.getNombre());
	}
	
	@Test
	void testTamaño() {
		assertEquals(14, this.archivo.getTamaño());
	}
	

}
