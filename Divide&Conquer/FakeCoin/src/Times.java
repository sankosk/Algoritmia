import java.util.Random;

public class Times {

	static int[] v;
	
	public static void fillVector(){
		for(int i=0; i<v.length; i++){
			v[i]=1;
		}
		
		Random r = new Random();
		int valor = r.nextInt(v.length);
		
		v[valor] = 0; // insertamos la moneda falsa
	}
	
	public static void main(String[] args){
		int nVeces = 1000;
		long t1, t2;
		
		for (int n=10000;n<1000000000;n*=2){
			v = new int[n];
			fillVector();
			t1 = System.currentTimeMillis();
			for (int repeticiones = 1; repeticiones <= nVeces; repeticiones++) {
				FakeCoin.fakeCoinRec(v, 0, v.length-1);
			}
			t2 = System.currentTimeMillis();
//			System.out.println ("n="+n+"**TIEMPO="+(t2-t1));
			System.out.println (n+"\t"+(t2-t1));
		}
	}
}
