package Cubilete;

import java.util.ArrayList;
import java.util.Random;


public class Cubilete {
	
	private ArrayList<Dado> dados = new ArrayList();
	private ArrayList<Integer> jugada = new ArrayList();
	
	public Cubilete() {
		for (int i = 0; i < 5; i++) {
			Dado dado = new Dado();
			this.dados.add(dado);
		}
	}
	

	public ArrayList<Integer> retornarJugada() {
	Random random = new Random();
		for (Dado dadoAux : dados) {
			int numero = random.nextInt(6);
			this.jugada.add(dadoAux.getCara(numero));
		}
		
	return jugada;
	}
	
	
	
	public ArrayList<Integer> retornarJugada (Integer cantidad){
		Random random = new Random();
		int cantidadDados = 5- cantidad;
		for (int i = 0; i < dados.size()-cantidadDados; i++) {
			int numero = random.nextInt(6);
			this.jugada.add(dados.get(i).getCara(numero));
		}
		return jugada;
  }
	
//	
//	public void limpiarLista() {
//		for (Integer valor : this.jugada) {
//			this.dados.remove(valor);
//		} 
//				
//	}
//	
//	
//	
//	public void limpiarIndice(int indice){
//			this.dados.remove(indice);
//	}
//	
//	
//	public ArrayList<Integer> getJugada() {
//		return jugada;
//	}
//	
	
	
}
 
	

