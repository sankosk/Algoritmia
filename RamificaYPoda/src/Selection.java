import utils.RamificaYPoda;

public class Selection extends RamificaYPoda{
	
	public Selection(int n, int k, int c){
		super();
		Subset s = new Subset(n, k, c);
		s.calcularValorHeuristico();
		ramificaYPoda(s);
	}
	
	public static void main(String[] args){
		Selection s = new Selection(30, 15, 120);
		s.mostrarTrazaSolucion();
	}
}
