package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarpetaTest {
	
	private Carpeta carpeta1, carpeta2, carpeta3;
	private Email email1, email2, email3,email4,email5;
	
	@BeforeEach
	public void setUp() {
		this.carpeta1 = new Carpeta();
		this.carpeta2 = new Carpeta();
		this.carpeta3 = new Carpeta();
		
		email1 = new Email("TituloX", "CuerpoZ");
		email2 = new Email("TituloZ", "CuerpoZ");
		email3 = new Email("TituloM", "CuerpoN");
		email4 = new Email("TituloN", "CuerpoZ");
		email5 = new Email("TituloN", "CuerpoN");
		
		carpeta1.agregarEmail(email1);
		carpeta1.agregarEmail(email2);	
		carpeta1.agregarEmail(email4);
		carpeta3.agregarEmail(email3);
		carpeta3.agregarEmail(email5);
	}
	
	
	@Test
	void testEmails() {	
		assertEquals(3, this.carpeta1.getEmails().size());
		assertEquals(0,this.carpeta2.getEmails().size());
		assertEquals(2,this.carpeta3.getEmails().size());
		
		assertTrue(this.carpeta1.getEmails().contains(email1));
		assertTrue(this.carpeta1.getEmails().contains(email2));
		assertTrue(this.carpeta1.getEmails().contains(email4));
		assertTrue(this.carpeta3.getEmails().contains(email3));
		assertTrue(this.carpeta3.getEmails().contains(email5));
		assertTrue(this.carpeta2.getEmails().isEmpty());
	}
	
	@Test
	void testEliminarEmail() {	
		assertTrue(this.carpeta1.eliminarEmail(email1));
		assertEquals(2,this.carpeta1.getEmails().size());
		assertFalse(this.carpeta1.eliminarEmail(email3));
		assertFalse(this.carpeta2.eliminarEmail(email1));
	}
	
	@Test
	void testBuscarEmail() {
		
		assertNull(this.carpeta2.buscarEmail("TituloX"));
		assertNull(this.carpeta1.buscarEmail("TextoD"));
		assertEquals(email3, this.carpeta3.buscarEmail("TituloM")); 
		assertEquals(email5, this.carpeta3.buscarEmail("CuerpoN")); //no tendria que devolver el email3? 
		
	}
	
	@Test
	void testTamañoCarpeta() {
		
		Archivo archivo1 = new Archivo("arch1");
		Archivo archivo2 = new Archivo("arch2");
		Archivo archivo3 = new Archivo ("arch3");
		Archivo archivo4 = new Archivo ("arch4");  
		
		this.email3.adjuntarArchivo(archivo1);
		this.email3.adjuntarArchivo(archivo2);
		this.email3.adjuntarArchivo(archivo3);
		this.email5.adjuntarArchivo(archivo4);
		
		assertEquals(48,this.carpeta3.tamañoCarpeta()); 
		
	}
		

}
