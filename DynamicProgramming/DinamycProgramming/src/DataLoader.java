import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {
	private Point begin;
	private Point end;
	private Point size;
	private ArrayList<Point> barriers = new ArrayList<Point>();
	
	 
	public PathsFinder loadData(String fPath) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fPath));
	    StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		int counter = 0;
		while (line != null) {
	        sb.append(line);
	        sb.append(System.lineSeparator());
			line = br.readLine();
		}
	    String everything = sb.toString();
		br.close();
		
		String[] splitted = everything.split("\n");
		String[] s1 = splitted[0].split(",");
		size = new Point(Integer.parseInt(s1[0].split("")[0]), Integer.parseInt(s1[1].split("")[0]));
			
		if(!splitted[1].equals("\r")){
			String[] s2 = splitted[1].split(";");
			for(String i : s2){
				String[] s3 = i.split(",");
				barriers.add(new Point(Integer.parseInt(s3[0].split("")[0]), Integer.parseInt(s3[1].split("")[0])));
			}
		}else{
			barriers = null;
		}
		
		String[] s4 = splitted[2].split(";");
		String s5 = s4[0].split(",")[0].split("")[0];
		String s6 = s4[0].split(",")[1].split("")[0];
		String s7 = s4[1].split(",")[0].split("")[0];
		String s8 = s4[1].split(",")[1].split("")[0];
		
		begin = new Point(Integer.parseInt(s5), Integer.parseInt(s6));
		end = new Point(Integer.parseInt(s7), Integer.parseInt(s8));
		
		PathsFinder pf = null;
		if(barriers != null){
			Point[] barriersArray = new Point[barriers.size()];
			for(int i=0; i<barriers.size(); i++)
				barriersArray[i] = barriers.get(i);
			
			pf = new PathsFinder(size, begin, end, barriersArray);
		}else{
			pf = new PathsFinder(size, begin, end, null);
		}

		return pf;
	}
}
