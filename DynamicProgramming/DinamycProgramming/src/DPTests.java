import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DPTests {

	@Test
	public void caso1() {
		DataLoader d = new DataLoader();
		try {
			System.out.println("##### CASO 1 #####");
			PathsFinder caso1 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso1.txt");
			assertEquals(2, caso1.calcNumOfPaths());
			caso1.showM();
			System.out.println("#################");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void caso2(){
		DataLoader d = new DataLoader();
		PathsFinder caso2;
		try {
			System.out.println("##### CASO 2 #####");
			caso2 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso2.txt");
			assertEquals(252, caso2.calcNumOfPaths());
			caso2.showM();
			System.out.println("#################");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void caso3(){
		DataLoader d = new DataLoader();
		PathsFinder caso3;
		try {
			System.out.println("##### CASO 3 #####");
			caso3 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso3.txt");
			assertEquals(0, caso3.calcNumOfPaths());
			caso3.showM();
			System.out.println("#################");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void caso4(){
		System.out.println("##### CASO 4 #####");
		PathsFinder pf = new PathsFinder(new Point(32, 36), new Point(31, 0), new Point(0, 35), null);
		System.err.println("El número de caminos posibles es: " + pf.calcNumOfPaths());
		pf.showM();
		System.out.println();
		System.out.println("#################");

	}
	
	@Test
	public void caso5(){
		DataLoader d = new DataLoader();
		PathsFinder caso5;
		try {
			System.out.println("##### CASO 5 #####");
			caso5 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso5.txt");
			assertEquals(4, caso5.calcNumOfPaths());
			caso5.showM();
			System.out.println("#################");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void caso6(){
		DataLoader d = new DataLoader();
		PathsFinder caso6;
		try {
			System.out.println("##### CASO 6 #####");
			caso6 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso6.txt");
			assertEquals(2, caso6.calcNumOfPaths());
			caso6.showM();
			System.out.println("#################");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void caso7(){
		DataLoader d = new DataLoader();
		PathsFinder caso7;
		try {
			System.out.println("##### CASO 7 #####");
			caso7 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso7.txt");
			assertEquals(-1, caso7.calcNumOfPaths());
			caso7.showM();
			System.out.println("#################");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void caso8(){
		DataLoader d = new DataLoader();
		PathsFinder caso7;
		try {
			System.out.println("##### CASO 8 #####");
			caso7 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso8.txt");
			assertEquals(-1, caso7.calcNumOfPaths());
			caso7.showM();
			System.out.println();
			System.out.println("#################");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void caso9(){
		DataLoader d = new DataLoader();
		PathsFinder caso7;
		try {
			System.out.println("##### CASO 9 #####");
			caso7 = d.loadData("C:\\Users\\Esteban\\Documents\\casos\\caso9.txt");
			assertEquals(-1, caso7.calcNumOfPaths());
			caso7.showM();
			System.out.println("#################");
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
