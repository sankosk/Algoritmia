import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import junit.framework.Assert;

public class FakeCoinTest {

	@Test
	public void test() {
		int[] vector = new int[100000];
		for(int i=0; i<vector.length; i++){
			vector[i] = 1;
		}
		
		Random r = new Random();
		int valor = r.nextInt(100000);
		
		vector[valor] = 0; // insertamos la moneda falsa
		
		assertEquals(valor, FakeCoin.fakeCoinRec(vector, 0, vector.length-1));
	}

}
