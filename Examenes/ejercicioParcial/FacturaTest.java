package ar.edu.unlp.info.oo1.ejercicioParcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacturaTest {

	Factura f1, f2;
	
	@BeforeEach
	void setuP(){
		List<Item> items1 = new ArrayList<Item>();
		this.f1 = new Factura(LocalDate.of(2020, 10, 10), items1);
		
		Pedido p = new Pedido("Suisa", LocalDate.of(2021, 11, 15), "Los Pollos Hermanos");
		Item b = new Bienes("Manguera de Riego",p,500,3.4,122);
		Item s = new Servicio("contruir",p,10,10);
		List<Item> items2 = new ArrayList<Item>();
		items2.add(b);
		items2.add(s);
		this.f2 = new Factura(LocalDate.now(),items2);
	}
	
	@Test
	void testCostoFinal() {
		assertEquals(0, f1.costoFinal());
		assertEquals(70476, f2.costoFinal());
	}
}
