package ar.edu.unlp.info.oo1.ej8_distribuidora;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

public class Usuario {
	private String nombre;
	private String domicilio;
	private List<Factura> facturas;
	private List<Consumo> consumos;

	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.facturas = new ArrayList<Factura>();
		this.consumos = new ArrayList<Consumo>();
	}

	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	public String getNombre() {
		return this.nombre;
	}

	public String getDomicilio() {
		return this.domicilio;
	}
	public void agregarFactura(Factura factura){
		this.facturas.add(factura);
	}

	/**
	 * Obtiene el consumo de energía activa (valor de la variable de energiaConsumoActiva del consumo) desde el consumo con fecha más reciente.
	 * Si no hay ningún consumo, retorna 0
	 * @return
	 */
	public double ultimoConsumoActiva() {
		return this.ultimoConsumoAsOptional() //obtengo ultimo consumo mas reciente 
			.map((Consumo c) -> c.getConsumoDeEnergiaActiva()) //a ese le pido la energia activa 
			.orElse(0d); //si no tiene energia activa retorno 0
	}

	/**
	 * Retorna el último consumo o null en caso que no exista
	 * @return
	 */
	public Consumo ultimoConsumo() {
		return this.ultimoConsumoAsOptional().orElse(null); 
	}	
	
	/**
	 * Retorna un Optional, dependiendo si hay o no consumos.
	 * @return
	 */
	private Optional<Consumo> ultimoConsumoAsOptional() {
		//retorna un Optional ya que puede no tener consumos
		return this.consumos 
			.stream() //a la coleccion consumos le indico que entienda el stream 
			.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()));
	}
	/**
	 * Si hay consumos, retorna lo correspondiente al consumo realizado.
	 * Factura 0 si no hay consumos.
	 * @param precioKW
	 * @return
	 */
	public Factura facturarEnBaseA(double precioKW) {
		Consumo ultimo = this.ultimoConsumo(); //me guardo el ultimo consumo 
		if (ultimo == null) {
			return new Factura(0, 0, this); //retorno una factura vacia si no hay consumos 
		}

		double descuento = 0d;
		if (ultimo.factorDePotencia() > 0.8d) {
			descuento = 10;
		}
		return new Factura(ultimo.costoEnBase(precioKW), descuento, this);
	}


}
