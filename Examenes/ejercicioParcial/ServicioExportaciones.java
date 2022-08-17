package ar.edu.unlp.info.oo1.ejercicioParcial;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ServicioExportaciones {

	private Set<Pedido> pedidos;
	private Set<Factura> facturas;
	
	public ServicioExportaciones() {
		this.pedidos = new HashSet<Pedido>();
		this.facturas = new HashSet<Factura>();
	}
	
	public Pedido darAltaPedido(String destino, LocalDate fechaExp, String nomEmpresa) {
		Pedido p = new Pedido(destino, fechaExp, nomEmpresa);
		this.pedidos.add(p);
		return p;
	}
	
	public Factura generarFactura(Pedido pedido) {
		Factura f = pedido.facturar();
		this.facturas.add(f);
		return f;
	}
	
	public Factura obtenerFacturaMayorCosto(LocalDate inicio, LocalDate fin) {
		return this.obtenerFacturaMayorCostoAsOptional(inicio, fin).orElse(null);
	}
	
	private Optional<Factura> obtenerFacturaMayorCostoAsOptional(LocalDate inicio, LocalDate fin){
		return this.facturas.stream()
				.filter(f -> f.periodoFactura(inicio, fin))
				.max(Comparator.comparing(f -> f.costoFinal()));
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}
}
