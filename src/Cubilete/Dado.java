package Cubilete;

import java.util.ArrayList;
import java.util.Random;

public class Dado {
	
		private ArrayList<Integer> Caras = new ArrayList(); 
		

	public Dado() {
		int[] Caras = new int[] {1,2,3,4,5,6};
		for (int i = 0; i < Caras.length; i++) {
			this.Caras.add(Caras[i]);
		}
		
	}

	

	public Integer getCara(int indice) {
		return this.Caras.get(indice);
	}

	
}	
