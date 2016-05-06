import java.util.ArrayList;

import utils.Estado;

public class Subset extends Estado{
	private static int[]v;     
	private static int k;
	private static int c;       
	private static boolean[]marca; // si se elige o no un elemento
	private static int s;          // suma acumulada hasta un estado 
	private static int escogidos;  // número elementos escoger
	
	
	public Subset(int n, int k, int c){
		super();
		marca = new boolean[n];
		Subset.v = new int[n];
		for(int i=0; i<n; i++){
			v[i] = i+1;
		}
		Subset.k = k;
		Subset.c= c;
	}

	public Subset(Subset padre, boolean[] marca, int aSumar){
		super();
		idPadre = padre.getId();
		this.marca = marca;
		this.s=padre.s+aSumar;
		this.profundidad = padre.profundidad+1;
		
        if (aSumar != 0) escogidos = padre.escogidos + 1;
        else escogidos = padre.escogidos;
        
		calcularValorHeuristico();
	}

	@Override
	public void calcularValorHeuristico() {
		// TODO Auto-generated method stub
		if(escogidos > k || s > c)	valorHeuristico=Integer.MAX_VALUE; //no permitido
		else if(c == s && escogidos == k)	valorHeuristico = Integer.MIN_VALUE; //solucion
		else if(c - s == 0 && escogidos != k) valorHeuristico = Integer.MAX_VALUE; //nivel de profunidad incorrectoo
		else valorHeuristico = c-s;
	}


	@Override
	public ArrayList<Estado> expandir() {
		// TODO Auto-generated method stub
		ArrayList<Estado> resultado = new ArrayList<Estado>();
		boolean[] marca1 = marca.clone();
		Subset s1 = new Subset(this, marca1, 0);
		boolean[] marca2 = marca.clone();
		marca2[profundidad] = true;
		Subset s2 = new Subset(this, marca2, v[profundidad]);
		resultado.add(s1);
		resultado.add(s2);
		return resultado;
	}

	@Override
	public int valorInicialPoda(){
		return c+1;
	}
	
	@Override
	public boolean solucion() {
		// TODO Auto-generated method stub
		return escogidos == k && s == c;
	}
	
	@Override
	public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Profundidad: ").append(profundidad).append("\n");
        for (int i = 0; i < marca.length; i++) {
            sb.append(marca[i]).append(" ");
        }
        return sb.toString().trim();	
	}
	
}
