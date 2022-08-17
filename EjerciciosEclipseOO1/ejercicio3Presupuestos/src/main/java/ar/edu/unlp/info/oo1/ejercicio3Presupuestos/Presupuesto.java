package ar.edu.unlp.info.oo1.ejercicio3Presupuestos;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List; 

public class Presupuesto {
	
	private LocalDate fecha; 
	private String cliente;
	
	private List<Item> items = new ArrayList<Item>(); 

	
	public Presupuesto() {
		this.fecha = LocalDate.now();
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String unCliente) {
		this.cliente = unCliente;
	}
	
	public void agregarItem(Item unItem) {
		this.items.add(unItem);	
	}

	public Double calcularTotal() {
		double total = 0;
			for(Item item: items){
			     total = total + item.getCostoUnitario();
			}
		return total;
	}

	public Presupuesto cliente(String unCliente) {
		this.setCliente(unCliente);
		return this;
	}


}
