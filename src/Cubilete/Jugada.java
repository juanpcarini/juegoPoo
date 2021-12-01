package Cubilete;

import java.util.ArrayList;

public class Jugada {	
		
		private int cantidadRepetida[] = new int[6] ;
		
		public Integer retornarJugada(ArrayList jugada){
			Integer jugadaGanadora = -1;
			limpiarArreglo();
			retornarArreglo(jugada);
			if (pokerReal()) {
				jugadaGanadora =9;			
			} 
			if (pokerCuadruple()) {
				jugadaGanadora =8;
			}
			if (full()) {
				jugadaGanadora 	=7;
			}
			if (escaleraMayor()) {
				jugadaGanadora =6;
			}
			if (escaleraMenor()) {
				jugadaGanadora =5;
			}
			if (pierna()) {
				jugadaGanadora =4;
			}			
			if (parDoble()) {
				jugadaGanadora =3;
			}
			if (par()) {
				jugadaGanadora =2;
			}
			if (mejorCarta()) {
				jugadaGanadora =1;
			}
			return jugadaGanadora;
		}

		
		
		private void retornarArreglo(ArrayList<Integer> jugada) {
			
			for (int i = 0; i < jugada.size(); i++) {
									
				if (jugada.get(i) == 1 ) {
					cantidadRepetida[0]+=1;
				}
				if (jugada.get(i) == 2) {
					cantidadRepetida[1]+=1;					
				}
				if (jugada.get(i) == 3) {
					cantidadRepetida[2]+=1;					
				}
				if (jugada.get(i) == 4) {
					cantidadRepetida[3]+=1;				
				}
				if (jugada.get(i) == 5) {
					cantidadRepetida[4]+=1;	
				}
				if (jugada.get(i) == 6) {
					cantidadRepetida[5]+=1;
				}
			}
			
		}
		
		private void limpiarArreglo() {
			for (int i = 0; i < cantidadRepetida.length; i++) {
				cantidadRepetida[i]= 0;
			}
		}
		
		private Boolean pokerReal() {
			Boolean resultado;
			resultado = false;
			for (int i = 0; i < cantidadRepetida.length; i++) {
				if (cantidadRepetida[i]==5) {
					resultado= true;
				}
			}
			
			return resultado;
		}
		
		private Boolean pokerCuadruple() {
			Boolean resultado;
			resultado = false;
			for (int i = 0; i < cantidadRepetida.length; i++) {
				if (cantidadRepetida[i]==4) {
					resultado = true;
				}
			}
			
			return resultado;
		}
		
		private Boolean full() {
			Boolean resultado;
			resultado = false;
			boolean igualATres = false;
			boolean igualADos = false;
			for (int i = 0; i < cantidadRepetida.length; i++) {
				if (cantidadRepetida[i]==2) {
					igualADos = true;
				}
				if (cantidadRepetida[i]==3) {
					igualATres = true;
				}
			}
			if (igualATres && igualADos) {
				resultado = true;
			}
			return resultado;
		}
		
		
		
		private Boolean escaleraMayor() {
			Boolean resultado = false;
			int contador = 0 ;
			if (full() == false) {
				for (int i = 1; i < cantidadRepetida.length; i++) {
					if (cantidadRepetida[i]==1) {
						contador+=1;						
					}		
			}
				if (contador==5) {
				resultado=true;
				}
			
			}
			return resultado;
		}
		
		private Boolean escaleraMenor() {
			Boolean resultado = false;
			int contador = 0 ;
			if (full() == false) {
				for (int i = 0; i < cantidadRepetida.length-1; i++) {
					if (cantidadRepetida[i]==1) {
						contador+=1;						
					}		
			}
				if (contador==5) {
					resultado=true;	
				}
				
			}
			return resultado;
		}
		
		private Boolean pierna() {
			Boolean resultado = false;
			if (full() == false) {
				for (int i = 0; i < cantidadRepetida.length; i++) {
					if (cantidadRepetida[i]==3) {
					
						resultado=true;
					}	
			}
			
			}
			return resultado;
		}
		
		private Boolean parDoble() {
			Boolean resultado= false;
			int contador =0;
			for (int i = 0; i < cantidadRepetida.length; i++) {
				if (cantidadRepetida[i]==2) {
					contador+=1;
				}
			}
			if (contador ==2) {
				resultado = true;
			}
			return resultado;
			}
			
		
		
		private Boolean par() {
			Boolean resultado= false;
			int contador =0;
			if (full() == false) {
				for (int i = 0; i < cantidadRepetida.length; i++) {
					if (cantidadRepetida[i]==2) {
						contador+=1;
					}
				}
				if (contador ==1) {
					resultado = true;
				}	
			}
			
			return resultado;
			}
		
		private Boolean mejorCarta() {
			Boolean resultado = false;
			if ((pokerReal()==false)&&(pokerCuadruple()==false)&&(full()==false)&&(escaleraMayor()==false)&&(escaleraMenor()==false)&&(pierna()==false)&&(parDoble()==false)&&(par()==false)) {
				resultado =true;
			}
			return resultado;
		}
}


