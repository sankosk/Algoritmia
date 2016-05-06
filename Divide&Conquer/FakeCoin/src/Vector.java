

import java.util.Random ;

/**
	Clase de utilidad, que genera para un vector los 3 órdenes 
	iniciales posibles: ordenado, inverso y aleatorio.
	También escribe el contenido de un vector
 */
public class Vector
{

	/**	Este método da valores ordenados
	 */
	public static void ordenDirecto (int[]a)
	{
		int n= a.length;
		for(int i=0;i<n;i++) a[i]=i;
	}

	/** 	Este método da valores ordenados
	 */
	public static void ordenInverso (int[]a)
	{
		int n= a.length;
		for(int i=0;i<n;i++) a[i]=n-i-1;
	}     

	/**
	 * Este método da valores aleatorios a un vector de enteros, 
	 * utiliza para ello la clase Random del paquete java.util
	 * @param a - array de enteros que rellena con los aleatorios
	 */
	public static void aleatorio (int[] a)
	{
		aleatorio(a,1000000);
	}
	
	/**
	 * Este método da valores aleatorios a un vector de enteros, 
	 * utiliza para ello la clase Random del paquete java.util
	 * @param a - array de enetros que rellena con aleatorios
	 * @param maxAlea - máximo número aleatorio para rellenar
	 */
	public static void aleatorio (int[]a, int maxAlea)
	{
		Random r= new Random ();
		int n= a.length;
		for(int i=0;i<n;i++)
			a[i]=r.nextInt (maxAlea);//valores entre 0 y maxAlea
	}     

	/**	Este método escribe los componentes del vector
	 */
	public static void escribe (int[]a)
	{
		int n= a.length;
		System.out.print("(");
		for (int i=0; i<n; i++ )
			System.out.print(a[i]+", ");
		System.out.println(")");
	}    

}
