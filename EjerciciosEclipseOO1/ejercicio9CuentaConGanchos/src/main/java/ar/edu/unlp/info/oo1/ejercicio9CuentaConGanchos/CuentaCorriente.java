package ar.edu.unlp.info.oo1.ejercicio9CuentaConGanchos;

public class CuentaCorriente extends Cuenta {
	
	private double limiteDescubierto;
	
	public CuentaCorriente(double saldo) {
		super(saldo);
		this.limiteDescubierto = 0;
	}

	public double getDescubierto() {
		return limiteDescubierto;
	}

	public void setDescubierto(double descubierto) {
		this.limiteDescubierto = descubierto;
	}

	protected boolean puedeExtraer(double monto) { //si el monto no se pasa del limite, retorna true sino retorna false 
		return (this.getSaldo() + this.getDescubierto()>= monto);
	}
	

}
