package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	
	private Email email, emailSinArchivos;
	private Archivo archivo1,archivo2,archivo3;
	
	@BeforeEach
	public void setUp() {
		this.email = new Email("Examen Final","Muestra de examen 9hs");
		this.emailSinArchivos = new Email("Fotos", "Fotos del curso de forografia");
		
		archivo1 = new Archivo("archivoAdj1");
		archivo2 = new Archivo("archivoAdj2");
		archivo3 = new Archivo("archivoAdj3");
		
		email.adjuntarArchivo(archivo1);
		email.adjuntarArchivo(archivo2);
		email.adjuntarArchivo(archivo3);
			
	}

	@Test
	void testAdjuntos() {
		assertEquals(0, this.emailSinArchivos.getAdjuntos().size());
		assertEquals(3, this.email.getAdjuntos().size());
		
		assertTrue(this.email.getAdjuntos().contains(archivo1));
		assertTrue(this.email.getAdjuntos().contains(archivo2));
		assertTrue(this.email.getAdjuntos().contains(archivo3));
		assertTrue(this.emailSinArchivos.getAdjuntos().isEmpty());
	}
	
	@Test
	void testContiene() {
		assertTrue(this.email.contiene("Examen Final"));
		assertFalse(this.email.contiene("Examen Cursada"));
	}
	
	@Test
	void testTamañoEmail() {
		assertEquals (66, this.email.tamañoEmail());
	}
	
	

}
