package ar.edu.unlp.info.oo1.ejercicio9CuentaConGanchos;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro(double saldo) {
		super(saldo);
	}

	protected boolean puedeExtraer(double monto) {
		return (this.getSaldo() - this.adicional(monto) >= 0); 		
	}
	
	public void extraerSinControlar(double monto) {
		super.extraerSinControlar(this.adicional(monto));
	}
	
	public void depositar(double monto) {
		super.depositar(this.adicional(monto));
	}
	
	public double adicional(double monto) {
		return monto + monto * 0.02;
	}

}