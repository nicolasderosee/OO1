package ar.edu.unlp.info.oo1.ejercicio12VolumenYSuperficieDeSolidos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReporteDeConstruccionTest {
	
	protected Pieza Cilindro;
	protected Pieza Esfera;
	protected Pieza PrismaRectangular;
	protected ReporteDeConstruccion Reporte;
	
	private void initializePiezas() {
		Cilindro = new Cilindro("Hierro","Azul",3,6);
		Esfera = new Esfera("Acero","Rojo",4);
		PrismaRectangular = new PrismaRectangular("Hierro", "Rojo", 5, 4, 6);	
	}
	
	private void initializeReporte() {
		Reporte = new ReporteDeConstruccion();
	}
	
	
	@BeforeEach
    void setUp() {
    	this.initializePiezas();
    	this.initializeReporte();
	} 
	
	@Test
	private void addPiezas() {
		assertTrue(this.Reporte.getPiezas().isEmpty());
		this.Reporte.agregarPiezas(Cilindro);
		this.Reporte.agregarPiezas(Esfera);
		this.Reporte.agregarPiezas(PrismaRectangular);
		assertEquals(3, this.Reporte.getPiezas().size());
	}
	

	@Test
	void testcalcularVolumen() {
		assertEquals((Math.PI*54),Cilindro.calcularVolumen());
		assertEquals((4/3 * Math.PI * 64), Esfera.calcularVolumen());
		assertEquals(120, PrismaRectangular.calcularVolumen());
	}
	
	
	@Test
	void testcalcularSuperficie() {
		assertEquals((Math.PI * 36 + Math.PI * 18), Cilindro.calcularSuperficie());
		assertEquals(Math.PI * 64, Esfera.calcularSuperficie());
		assertEquals(148, PrismaRectangular.calcularSuperficie());
		
	}

	@Test
	void testVolumenDeMaterial() {
		
		this.Reporte.agregarPiezas(Cilindro);
		this.Reporte.agregarPiezas(Esfera);
		this.Reporte.agregarPiezas(PrismaRectangular);
		
		assertFalse(this.Reporte.getPiezas().isEmpty());
		
		assertEquals(Math.PI*54 + 120, Reporte.getVolumenDeMaterial("Hierro"));
		assertEquals(4/3 * Math.PI * 64, Reporte.getVolumenDeMaterial("Acero"));
		assertEquals(0,Reporte.getVolumenDeMaterial("Piedra"));
	}
	
	
	@Test
	void testSuperficieDeColor() {

		this.Reporte.agregarPiezas(Cilindro);
		this.Reporte.agregarPiezas(Esfera);
		this.Reporte.agregarPiezas(PrismaRectangular);
		
		assertFalse(this.Reporte.getPiezas().isEmpty());
		
		assertEquals(Math.PI * 64 + 148 , Reporte.getSuperficieDeColor("Rojo"));
		assertEquals(Math.PI * 36 + Math.PI * 18, Reporte.getSuperficieDeColor("Azul"));
		assertEquals(0, Reporte.getSuperficieDeColor("Amarillo"));
		
	}
	

}
