package ar.edu.unlp.info.oo1.ejercicioParcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private String destino;
	private LocalDate fechaExp;
	private String nomEmpresa;
	private List<Item> items;
	
	
	public Pedido(String destino, LocalDate fechaExp, String nomEmpresa) {
		this.destino = destino;
		this.fechaExp = fechaExp;
		this.nomEmpresa = nomEmpresa;
		this.items = new ArrayList<Item>();
	}
	
	public void agregarBienes(String desc, int cant, double pesoKgU, double valorU) {
		Item b = new Bienes(desc, this, cant, pesoKgU, valorU);
		this.items.add(b);
	}
	
	public void agregarServicio(String desc, double costoMateriales, double costoManoObra) {
		Item s = new Servicio(desc,this,costoMateriales,costoManoObra);
		this.items.add(s);
	}
	
	public Factura facturar() {
		return new Factura(this.fechaExp,List.copyOf(this.items));
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getFechaExp() {
		return fechaExp;
	}

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public List<Item> getItems() {
		return items;
	}
	
	

}
