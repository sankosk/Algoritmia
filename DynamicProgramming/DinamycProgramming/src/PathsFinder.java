import static java.lang.Math.*;

/**
 * Práctica programación dinámica - Encontrar todos los caminos posibles desde un punto A a otro punto B
 * existiendo la posibilidad de barreras.
 * @author EstebanMontesMorales
 */

public class PathsFinder {
	private long[][] M;
	private Point size;
	private Point begin;
	private Point end;
	private Point[] barriers;
	
	public PathsFinder(Point size, Point begin, Point end, Point[] barriers){
		this.size = size;
		this.begin = begin;
		this.end = end;
		this.barriers = barriers;
		this.M = new long[this.size.x][this.size.y];
		
		//Minimizing the matrix if its necessary:
		if(checkIfBarriersAtBegin() == true)	prepareSpecial();
		if(isNecessaryMinimize() || barriers == null)	minimize();
	}
	
	private void addBarriers(Point barrierCoord){
		M[barrierCoord.x][barrierCoord.y] = -1;
	}
	
	private void minimize(){
		Point a = new Point((size.x-begin.x),(size.y-begin.y));
		Point b = new Point((size.x-end.x),(size.y-end.y));
		
		int nrows = max(a.x, b.x) - min(a.x, b.x);
		int ncols = max(a.y, b.y) - min(a.y, b.y);

		this.M = new long[nrows+1][ncols+1];
		prepareBoard();
		if(barriers != null){
			// new barriers positions
			for(int i=0; i<barriers.length; i++){
				barriers[i] = new Point((nrows-barriers[i].x), (ncols-barriers[i].y));
				addBarriers(barriers[i]);
			}
		}
	}
	
	private void prepareBoard(){		
		for(int i=0; i<M[0].length; i++){
			M[0][i] = 1;
		}
		for(int i=0; i<M.length; i++){
			M[i][0] = 1;
		}
	}
	private void prepareSpecial(){
		for(int i=0; i<M[0].length; i++){
			M[1][i] = 1;
		}
	}
	
	public long calcNumOfPaths(){
		//Not valid inputs:	
		//check if we're inside of the board
		boolean predicate = begin.x >= size.x || begin.y >= size.y || end.x >= size.x || end.y >= size.y;
		boolean predicate2 = begin.x < 0 || begin.y < 0 || end.x < 0 || end.y < 0;
		//check that the end point is not before of the begin point or in the same coord
		boolean predicate3 = end.y <= begin.y || (end.x == begin.x && end.y == begin.y);
		
		if(predicate || predicate2 || predicate3)	return -1;
		for(int i=1; i<M.length; i++){
			for(int j=1; j<M[i].length; j++){
				if(M[i][j] == -1)	M[i][j] = 0;
				else	M[i][j] = M[i-1][j] + M[i][j-1];//recurrence f
			}
		}
		return M[M.length-1][M[0].length-1];
	}
	
	private boolean isNecessaryMinimize(){
		return ((begin.x + 1) != size.x && (begin.y + 1) != size.y);
	}
	
	private boolean checkIfBarriersAtBegin(){
		boolean flag = false;
		if(barriers == null)	return flag;
		for(Point p: barriers){
			if(p.x==0 || p.y==0)	flag=true;
			else	flag=false;
		}
		return flag;
	}

	public void showM(){
		for(int i=0; i<M.length; i++){
			for(int j=0; j<M[0].length; j++){
				System.out.print(""+M[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
