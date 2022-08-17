package ar.edu.unlp.info.oo1.ejercicio13ClienteDeCorreoConAdjuntos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteDeCorreoTest {
	
	private ClienteDeCorreo clientedecorreo;
	private Carpeta carpetaB, carpetaC, carpetaD;
	private Email email1,email2,email3,email4;
	
	
	@BeforeEach
	public void setUp() {
		this.clientedecorreo = new ClienteDeCorreo();
		
		Archivo archivo1 = new Archivo("arch1");
		Archivo archivo2 = new Archivo("arch2");
		Archivo archivo3 = new Archivo ("arch3");
		Archivo archivo4 = new Archivo("arch4");
		Archivo archivo5 = new Archivo("arch5");

		
		this.email1 = new Email("TextoB","CuerpoD");
		this.email2 = new Email("TextoC", "CuerpoC");
		this.email3 = new Email("TextoD", "CuerpoD");
		this.email4 = new Email("TextoP", "CuerpoP");
		
		this.email1.adjuntarArchivo(archivo1);
		this.email1.adjuntarArchivo(archivo2);
		this.email2.adjuntarArchivo(archivo3);
		this.email3.adjuntarArchivo(archivo4);
		this.email4.adjuntarArchivo(archivo5);

		
		this.carpetaB = new Carpeta();
		this.carpetaC = new Carpeta();
		this.carpetaD = new Carpeta();
		
		this.carpetaB.agregarEmail(email1);
		this.carpetaB.agregarEmail(email2);
		this.carpetaC.agregarEmail(email3);
		this.carpetaD.agregarEmail(email1);
		this.carpetaD.agregarEmail(email3);
		
		clientedecorreo.agregarCarpeta(carpetaB);
		clientedecorreo.agregarCarpeta(carpetaC);
		clientedecorreo.agregarCarpeta(carpetaD);
		
	}
	
	@Test
	void testRecibir() { 
		this.clientedecorreo.recibir(email4);
		assertTrue(this.clientedecorreo.getCarpeta().getEmails().contains(email4));
	}

	@Test
	void testGetCarpetas() { //es necesario? 
		assertEquals(4, this.clientedecorreo.getCarpetas().size());
	}
	
	@Test
	void testMover() {
		this.clientedecorreo.mover(email2, carpetaB, carpetaC);
		
		assertTrue(this.carpetaC.getEmails().contains(email2));
		assertFalse(this.carpetaB.getEmails().contains(email2));
	}
	
	@Test
	void testBuscar() {
		assertNull(this.clientedecorreo.buscar("CuerpoJ"));
		assertEquals(this.email2, this.clientedecorreo.buscar("TextoC"));
		assertEquals(this.email3, this.clientedecorreo.buscar("CuerpoD")); //en cada ejecución aveces retorna el email1 o el email3 y me da error en los test  
	}
	
	
	@Test 
	void espacioOcupado() {
		assertEquals(100, this.clientedecorreo.espacioOcupado()); //la cuenta me dio 118, no 100. La carpeta del inbox se tiene en cuenta? 
	}
	


}
