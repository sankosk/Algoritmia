import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/* PROBLEMA DE LA MONEDA PARALELIZADO
 * NOTA : NO ESTA FUNCIONANDO
 * */

public class PFakeCoin extends RecursiveAction{
	
	static int[] v;
	private int l, r;
	
	public PFakeCoin(int[] v, int l, int r){
		this.v = v;
		this.l = l;
		this.r = r;
	}
	
	public static void main(String[] args){
		v = new int[100000];
		for(int i=0; i<v.length; i++){
			v[i] = 1;
		}
		
		Random r = new Random();
		int valor = r.nextInt(100000);
		
		v[valor] = 0; // insertamos la moneda falsa
		
		int threadCount = 2;
		ForkJoinPool pool = new ForkJoinPool(threadCount);
		PFakeCoin p = new PFakeCoin(v, 0, v.length-1);
		pool.invoke(p);
	}
	
	public static int fakeCoinRec(int[] v, int l, int r){
		int n = r-l;
		
		if((n+1)<3)	return -1;
		else if((n+1)==3){
			if(v[l] == v[l+1] && v[l] != v[r])	return r;
			else if(v[l+1] == v[r] && v[r] != v[l])	return l;
			else if(v[l] == v[r] && v[l+1] != v[l])	return l+1;
			else	return -1;
		}
		
		else if((n+1)>3 && (n+1)<7){
			if(fakeCoinRec(v, l, r-1) == -1){
				if(v[l]==v[r])	return -1;
				return r;
			}else	return fakeCoinRec(v, l, r-1);
		}
		
		else if((n+1)>6){
			int[] v1 = copyVector(v, l, ((n+1)/2)-1);
			int[] v2 = copyVector(v, (n+1)/2, r);
					
			int a = fakeCoinRec(v1, 0, v1.length-1);
			int b = fakeCoinRec(v2, 0, v2.length-1);
			
			return b==-1 ? a: v1.length+b;
		}
		return -1;
	}
	
	public static int[] copyVector(int[] v, int from, int to){
		int[] copy = new int[(to-from)+1];
		for(int i=from; i<to+1; i++){
			copy[i-from] = v[i];
		}
		return copy;
	}

	@Override
	protected void compute() {
		PFakeCoin p1 = new PFakeCoin(v, l, r/2);
		PFakeCoin p2 = new PFakeCoin(v, r/2, r);
		invokeAll(p1, p2);

	}
}
