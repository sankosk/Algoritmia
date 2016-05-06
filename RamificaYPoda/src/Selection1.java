
import utils.RamificaYPoda;

public class Selection1 extends RamificaYPoda {

    public Selection1(int n, int k, int c) {
        super();
        Subset1 vNode = new Subset1(n, k, c);
        vNode.calcularValorHeuristico();
        ramificaYPoda(vNode);
    }
    
    public static void main(String[] args){
    	long t1= System.currentTimeMillis(); 
    	//Selection1 s = new Selection1(50, 25, 325);
    	Selection1 s = new Selection1(50, 25, 325);
    	long t2= System.currentTimeMillis(); 
    	s.mostrarTrazaSolucion();
    	System.out.println("");
    	System.err.println ("TIEMPO MILISEGUNDOS="+(t2-t1));
    }
}
