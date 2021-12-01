package Cubilete;

import java.util.ArrayList;
import java.util.Scanner;

public class PokerDado {

		private Cubilete cubilete;
		private ArrayList<Jugador> Jugadores = new ArrayList();
		private ArrayList<Integer> jugadaActual = new ArrayList();
		private ArrayList<ArrayList> jugadas = new ArrayList();
		private ArrayList<Integer> jugadasNombres = new ArrayList();
		private Jugada jugada;
		
		
		public PokerDado() {
			cubilete = new Cubilete();
			Jugadores = new ArrayList<Jugador>();
		}
				
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokerDado juego = new PokerDado();
		juego.comenzarJuego();
	}
		
	
	
	public void comenzarJuego() {
		int opcion = -1;
		while (opcion!= 0) {
			opcion = mostrarMenu();
			switch(opcion) {
			case 1:
				//Agregar Jugador
				Scanner n = new Scanner(System.in);
				System.out.println("            Ingresar nombre                ");
				String nombre = n.nextLine();
				Jugadores.add(new Jugador(nombre,verificarSaldo()));
				esperarEnter();
				break;
			case 2:
				//Mostrar Jugadores		
				mostrarJugadores();
				break;				
			case 3:
				//Comenzar Juego
				if (Jugadores.size()>0) {
					jugar();
				}else {
					System.out.println("Debe ingresar jugadores antes.");
				}
				break;
			
			}
		
		}
	}
	
	private void jugar() {
		Integer jugadaNombre = 0;
		int jugadorActual = 0;
		while (jugadorActual< this.Jugadores.size()) {
			Jugada jugada = new Jugada();
			Cubilete cubilete = new Cubilete();
			jugadaActual = new ArrayList(cubilete.retornarJugada());
			System.out.println("======================================================");
			System.out.println("Jugador: " + Jugadores.get(jugadorActual).getNombre());
			System.out.println("------------------------------------------------------");
			System.out.println("Su jugada es : ");
			mostrarJugada();
			System.out.println("------------------------------------------------------");
			jugadaNombre=jugada.retornarJugada(jugadaActual);
			jugadaCartel(jugadaNombre);
			
			
			if (tirarSegundoTurno()) {
				mostrarJugada();
				jugadaNombre=jugada.retornarJugada(jugadaActual);
				jugadaCartel(jugadaNombre);	
				jugada.retornarJugada(jugadaActual);
				
			}
			
			jugadasNombres.add(jugadaNombre);
			jugadas.add(jugadaActual);
			esperarEnter();
			jugadorActual+=1;
			
			}
		
		System.out.println("El jugador ganador fue: "+ Jugadores.get(jugadaGanadora()).getNombre().toString());
		esperarEnter();
	}
	
	
//	private ArrayList apuesta() {
//		
//		
//	}
	
	private Integer jugadaGanadora(){
		int mayor = 0;
		int contador = 1;
		Integer jugador = -1;
		mayor=jugadasNombres.get(0);
		for (int i = 1; i < jugadasNombres.size(); i++) {
			if (mayor <= jugadasNombres.get(i)) {
				if (mayor== jugadasNombres.get(i)) {
					contador+=1;
				}
				mayor = jugadasNombres.get(i);
				jugador = i;
				
			}
		}
		if (contador>1) {
			
		}
		return jugador;
	}
	
	private int mostrarMenu(){
		int opcion = -1;
		while (opcion<0 || opcion>3) {
			System.out.println("=====================================================");
			System.out.println("-----------------------------------------------------");
			System.out.println("                        CUBILETE                     ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                     Menu Principal                  ");
			System.out.println("-----------------------------------------------------");
			System.out.println("                   1.Agregar Jugador                 ");
			System.out.println("                                                     ");
			System.out.println("                   2.Mostrar Jugadores               ");
			System.out.println("                                                     ");
			System.out.println("                   3.Comenzar Juego                  ");			
			System.out.println("                                                     ");
			System.out.println("                       0. Salir                      ");
			System.out.println("-----------------------------------------------------");
			System.out.println("=====================================================");
			Scanner respuesta = new Scanner(System.in);
			opcion = respuesta.nextInt();	
		}
		
		return opcion;
	}
	
	
	private void jugadaCartel(Integer jugada) {
		if (jugada==9) {
			System.out.println("SU JUGADA FUE POKER REAL!");
		}
		if (jugada==8) {
			System.out.println("SU JUGADA FUE POKER CUADRUPLE!");			
		}
		if (jugada==7) {
			System.out.println("SU JUGADA FUE FULL HOUSE!");			
		}
		if (jugada==6) {
			System.out.println("SU JUGADA FUE ESCALERA MAYOR!");			
		}
		if (jugada==5) {
			System.out.println("SU JUGADA FUE ESCALERA MENOR!");			
		}
		if (jugada==4) {
			System.out.println("SU JUGADA FUE UNA PIERNA!");			
		}
		if (jugada==3) {
			System.out.println("SU JUGADA FUE UNA PAR DOBLE!");			
		}
		if (jugada==2) {
			System.out.println("SU JUGADA FUE UNA PAR!");			
		}
		if (jugada==1) {
			System.out.println("NO OBTUVO NINGUNA JUGADA :(");			
		}
		

	}
	
	private Boolean tirarSegundoTurno() {
		Boolean respuesta = false;
		ArrayList<Integer> dadosNuevos = new ArrayList();
		Cubilete cubilete = new Cubilete();
		Jugada jugada = new Jugada();
		Integer cantidadDados = elegirDados(); 
		if (cantidadDados > 0) {
			respuesta = true;
			dadosNuevos = new ArrayList(cubilete.retornarJugada(cantidadDados));
			for (Integer integer : dadosNuevos) {
				jugadaActual.add(integer);
			}
		}
		return respuesta;
		}
	
	
	
	//metodo para que elija los dados que no quiere en su jugada y vuelva a tirar en su ultimo intento
	private Integer elegirDados() {
		Integer contador = 0;
		int opcion= -1;
		
		
		System.out.println("=====================================================");
		System.out.println("-----------------------------------------------------");
		System.out.println("       Desea volver a tirar?               ");
		System.out.println("");
		System.out.println("			 1.SI						 ");
		System.out.println("");
		System.out.println("  	         2.NO					     ");
		System.out.println("-----------------------------------------------------");
		System.out.println("=====================================================");
	
		Scanner sc = new Scanner(System.in);
		opcion = sc.nextInt();
		if (opcion == 1) {
			int respuesta = 1;
			while ((jugadaActual.size() != 0) &&(respuesta==1)) {
				mostrarJugada();
				System.out.println("Ingrese el DADO(indice) que quiere volver a tirar");
				Scanner dado = new Scanner(System.in);
				int indice = dado.nextInt();
				jugadaActual.remove(indice-1);
				contador+=1;
				mostrarJugada();

				System.out.println("	Desea sacar otro dado?				");
				System.out.println("");
				System.out.println("		   1.SI					   	    ");
				System.out.println("");
				System.out.println("	       2.NO						    ");
				Scanner resp = new Scanner(System.in);
				respuesta = resp.nextInt();
			}
		}
		
		return contador;
	}
	


	
	private void mostrarJugada() {
		for (Integer integer : jugadaActual) {
			System.out.println(integer);
		}
	}
	private void esperarEnter() {
		System.out.println("Presione ENTER para continuar");
		Scanner enter = new Scanner(System.in);
		String pausa = enter.nextLine();
	}
	
	
	private Double verificarSaldo(){
		
		Double saldo = -1.00;
		while (saldo<100) {
			Scanner sald = new Scanner(System.in);
			System.out.println("            Ingresar saldo (mayor a $100)                 ");
			saldo = sald.nextDouble();
		}
		
		return saldo; 
	}
	
	private void mostrarJugadores() {
		System.out.println("-----------------------------------------------------");
		System.out.println("                        JUGADORES                    ");
		System.out.println("-----------------------------------------------------");
		for (Jugador jugador : Jugadores) {
			System.out.println("Nombre: "+ jugador.getNombre());
			System.out.println("Saldo: "+ jugador.getSaldo().toString());
			System.out.println("-----------------------------------------------------");
			esperarEnter();
		}
	}
	
	public void eliminarJugador(int indice) {
		this.Jugadores.remove(indice);
	}
	
}
	
	
	
	
	