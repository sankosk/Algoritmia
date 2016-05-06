package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class MinCashFlow {
	private	Person[] v;	


	public Person[] getV(){
		return v;
	}
	
	public MinCashFlow(Person[] v){
		this.v = v;
	}
	
	public void minimization(){
		Arrays.sort(v, new Comparator<Person>(){
			@Override
			public int compare(Person p1, Person p2){
				return p1.getMoney()-p2.getMoney();
			}
		}
		);
		
		int i = 0;	int j = v.length-1;
		System.err.println("\n**Resultados Finales");
		do{			
			if(v[j].getMoney() > -v[i].getMoney()){
				System.out.println("" + v[i].getName() + " paga a " + v[j].getName() + " " + -v[i].getMoney() + " euros");
				v[j].setMoney(v[j].getMoney() + v[i].getMoney());
				v[i].setMoney(0);
				i++;
			}else{
				System.out.println("" + v[i].getName() + " paga a " + v[j].getName() + " " + v[j].getMoney() + " euros");
				v[i].setMoney(v[i].getMoney() + v[j].getMoney());
				v[j].setMoney(0);
				j--;
			}
		} while(!areBalanced());
	}
	
	private void showTrace(){
		for(int i=0; i<v.length; i++){
			System.err.print(v[i].getMoney() + "\t");
		}
		System.err.println();
	}
	
	public boolean areBalanced(){
		for(Person i: v){
			if(i.getMoney()!=0)	return false;
		}
		return true;
	}
	
//	public static void main(String[] args){
		//int[] a = new int[]{5050, 150, 75,25,-100,-200,-5000};
		//int[] a = new int[]{45, 15, 5, 5, -10, -60};
		//Arrays.sort(a);
		//int a[] = new int[]{-4000, -3000, 7000};

//		Person[] a = new Person[]{new Person("Victor", -60), new Person("Alberto", -10), new Person("Celia", 5),
//				new Person("Pablo", 5), new Person("Elena", 15), new Person("Tamara", 45)};
//		
//		
//		MinCashFlow m = new MinCashFlow(a);
//		m.minimization();
//	}
	
	
}
