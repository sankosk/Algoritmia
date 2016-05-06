import java.util.concurrent.ForkJoinPool;

/** Este programa sirve para medir tiempos del algoritmos 
	de ordenacion RAPIDO
	Lo hace en tres supuestos: 
	1) array inicialmente ordenado 
	2) array inicialmente en orden inverso
	3) array inicialmente aleatorio
 */

public class Rapido2P
{
	static int []v;

	public static void main (String arg [] )
	{ 
		String opcion=arg[0];
		int nVeces= 1000;

		long t1,t2;
		int threadCount = 2;
		ForkJoinPool pool = new ForkJoinPool(threadCount);
		
		for (int n=10000;n<1000000000;n*=2)
		{
			v = new int [n] ;

			if (opcion.compareTo("ordenado")==0)
				Vector.ordenDirecto (v);
			else if (opcion.compareTo("inverso")==0)
					Vector.ordenInverso (v);
			else
				Vector.aleatorio (v);

			t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				RapidoParal rapido = new RapidoParal(v,0,n-1);
				pool.invoke(rapido);			}
			t2 = System.currentTimeMillis();

//			System.out.println ("n="+n+"**TIEMPO="+(t2-t1));
			System.out.println (n+"\t"+(t2-t1));
		} // de for
	} //fin de main

}