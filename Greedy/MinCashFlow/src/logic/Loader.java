package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Loader {
	private ArrayList<String[]> lines;
	private static ArrayList<Integer> money = new ArrayList<Integer>();
	private static ArrayList<String> names = new ArrayList<String>();
	
	private int[] v;
	private LinkedHashMap<String, Integer> persons;
	
	public int[] getV(){
		return v;
	}
	
	public LinkedHashMap<String, Integer> getPersons(){
		return persons;
	}
	
	public Loader(String path) throws IOException{
		persons = new LinkedHashMap<String, Integer>();
		lines = new ArrayList<String[]>();
		fReader(path);
		
		v = new int[persons.size()];
	}
	
	public void fReader(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = br.readLine();
		
		int counter=0;
		System.err.println("**Computando balance de cuentas:");
		while(line != null){
			String[] splitted = line.split(" ");
			lines.add(splitted);
			
			if(!persons.containsKey(splitted[0])){
				persons.put(splitted[0], counter);
				counter++;
			}
			if(!persons.containsKey(splitted[1])){
				persons.put(splitted[1], counter);
				counter++;
			}
			
			System.out.print("" + splitted[0] + " tiene que pagar " + splitted[2] + " a " + splitted[1] + "\n");
			line = br.readLine();
		}
		
		br.close();
	}
	
	public void prepareVector(){
		for(int i=0; i<lines.size(); i++){
			v[persons.get(lines.get(i)[0])] += -Integer.parseInt(lines.get(i)[2]);
			v[persons.get(lines.get(i)[1])] += Integer.parseInt(lines.get(i)[2]);
		}
	}
	
	
	public static void main(String[] args){
		Loader l;
		try {
			l = new Loader("C:\\Users\\Esteban\\Desktop\\caso1.txt");
			l.prepareVector();

			Iterator it = l.getPersons().keySet().iterator();
			while(it.hasNext()){
				String key = (String) it.next();
				names.add(key);
			}
			
			for(int i: l.getV()){
				money.add(i);
			}
			
			
			Person[] toLoad = new Person[money.size()];
			for(int i=0; i<money.size(); i++){
				toLoad[i] = new Person(names.get(i), money.get(i));
			}

			MinCashFlow m = new MinCashFlow(toLoad);
			m.minimization();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
