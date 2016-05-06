
public class FakeCoin {
	
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
			if(FakeCoin.fakeCoinRec(v, l, r-1) == -1){
				if(v[l]==v[r])	return -1;
				return r;
			}else	return FakeCoin.fakeCoinRec(v, l, r-1);
		}
		
		else if((n+1)>6){
			int[] v1 = FakeCoin.copyVector(v, l, ((n+1)/2)-1);
			int[] v2 = FakeCoin.copyVector(v, (n+1)/2, r);
					
			int a = FakeCoin.fakeCoinRec(v1, 0, v1.length-1);
			int b = FakeCoin.fakeCoinRec(v2, 0, v2.length-1);
			
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
}
