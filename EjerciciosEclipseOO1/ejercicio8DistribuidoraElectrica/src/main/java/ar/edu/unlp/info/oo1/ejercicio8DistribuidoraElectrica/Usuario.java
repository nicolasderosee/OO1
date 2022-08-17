package ar.edu.unlp.info.oo1.ejercicio8DistribuidoraElectrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Usuario {
	
	private String domicilio;
	private String nombre;
	private List <Consumo> consumos;
	private List <Factura> facturas;
	
	
	public Usuario(String domicilio, String nombre) {
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.consumos = new ArrayList<Consumo>();
		this.facturas = new ArrayList<Factura>();
	}
	

	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	

	public String getDomicilio() {
		return this.domicilio;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	
	public List <Factura> facturas() {
		return this.facturas();
	}
	
	
	public List <Consumo> consumos() {
		return this.consumos();
	}
	

	public double ultimoConsumoActiva() {
		return this.ultimoConsumoAsOptional() //obtengo ultimo consumo mas reciente 
			.map((Consumo c) -> c.getConsumoEnergiaActiva()) //a ese le pido la energia activa 
			.orElse(0d); //si no tiene energia activa retorno 0
	}
	
	public Consumo ultimoConsumo() {
		return this.ultimoConsumoAsOptional().orElse(null); 
	}
	
	
	private Optional<Consumo> ultimoConsumoAsOptional() {
		//retorna un Optional ya que puede no tener consumos
		return this.consumos 
			.stream() //a la coleccion consumos le indico que entienda el stream 
			.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()));
	}
	
	
	public Factura facturarEnBaseA (double precioKWh) {
		Factura factura;
		Consumo ultimo = this.ultimoConsumo();	
		if(ultimo == null) {
			factura = new Factura(0,0,this);
		}
		double costo = 0d;
		double descuento = 0d; 
		costo = ultimo.costoEnBaseA(precioKWh);
		if(ultimo.factorDePotencia() > 0.8)
				descuento = 10;
		factura = new Factura(costo,descuento,this);
		this.agregarFactura(factura);
		return factura;
		
	}


}