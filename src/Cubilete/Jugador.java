package Cubilete;

public class Jugador {
	private String nombre;
	private Double saldo;
	
	
	public Jugador(String nombre, Double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}


	public String getNombre() {
		return nombre;
	}


	public Double getSaldo() {
		return saldo;
	}
	
	
	
}
