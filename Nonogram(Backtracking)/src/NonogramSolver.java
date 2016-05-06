import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Nonogram Solver using backtracking technique
 * @author Esteban
 */
public class NonogramSolver {
	private static final Boolean BLANK = false;
	private static final Boolean PAINTED = true;
	private Boolean[][] board;
	private int[][] rowConstraints;
	private int[][] colConstraints;
	private Boolean isSolution;
	
	public NonogramSolver(int boardSize, int[][] rowConstraints, int[][] colConstraints){
		this.board = new Boolean[boardSize][boardSize];
		this.rowConstraints = rowConstraints;
		this.colConstraints = colConstraints;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				board[i][j]=false;
			}
		}
		isSolution=false;
	}
	
	public void backtracking(int row, int col, int c){
		if(row==board.length && checkBoard()){
			isSolution=true;
			showBoard();
		}
		else{
			if(!isSolution){
				
				if(col == board.length && row == board.length){
					backtracking(0, 0, 0);
				}
				
				else if(col == board.length){
					backtracking(row+1, 0, c);
				}
				
				else if(row == board.length){
					backtracking(0, 0, 0);
				}
				
				else if(c == rowConstraints[row].length){
					c = 0;
				}
				
				else if(c == colConstraints[col].length){
					c = 0;
				}
				
				else if(!checkRow(row, c) && !checkCol(col, c)){
					board[row][col]=true;
				}else if(checkRow(row, c) && checkCol(col, c)){
					board[row][col]=false;
				}
				showBoard();
				System.out.println();
				backtracking(row, col+1, c);
			}
		}
	}
	
	private int maxConstraint(int row){
		int max = 0;
		for(int i=0; i<rowConstraints[row].length; i++)
			if(rowConstraints[row][i]>max)
				max = rowConstraints[row][i];
		
		return max;
	}
	
	private int maxConstraintInCol(int col){
		int max = 0;
		for(int i=0; i<colConstraints[col].length; i++)
			if(colConstraints[col][i]>max)
				max = colConstraints[col][i];
		
		return max;
	}
	
	private boolean checkRow(int row, int cons){
		if (countSuccessiveb(Arrays.asList(board[row]), true) == rowConstraints[row][cons])
			return true;
		else
			return false;
	}
	
	private boolean checkCol(int col, int cons){
		List<Boolean> aux = new ArrayList<Boolean>();
		for(int i=0; i<board[0].length; i++){
			aux.add(board[i][col]);
		}
		
		if(countSuccessiveb(aux, true) == colConstraints[col][cons])	return true;
		else return false;		
	}
	
	private void showBoard(){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(board[i][j])
					System.out.print(""+'X'+"\t"); // -> X = BLACK CELL
				else
					System.out.print(""+'0'+"\t"); // -> 0 = BLANK/EMPTY CELL
			}
			System.out.println();
		}
	}
	
	private int vectorSum(int[] vector){
		int total = 0;
		for(int i=0; i<vector.length; i++)	total += vector[i];
		return total;
	}
	
	public static int countSuccessiveb (List<Boolean> values, Boolean target) {
	    int maxLength = 0;
	    int tempLength = 0;

	    for (Boolean value : values) {
	        tempLength = (value == target) ? 1 + tempLength : 0;
	        if (tempLength > maxLength) {
	            maxLength = tempLength;
	        }
	    }
	    return maxLength;
	}
	
	private boolean checkBoard(){
		boolean flag = false;
		for(int i=0; i<board.length; i++){
			for(int k=0; k<rowConstraints[i].length; k++){
				flag=checkRow(i, k);//&& countBlakcsOnRow(i)==rowConstraints[i].length;
			}
		}

		for(int i=0; i<board[0].length; i++){
			for(int k=0; k<colConstraints[i].length; k++){
				flag=checkCol(i, k);// && countBlacksOnCol(i) == colConstraints[i].length;
			}
		}
		
		return flag;
	}
	
	
	private int countBlakcsOnRow(int row){
		int c = 0;
		for(int i=0; i<board.length; i++){
			if(board[row][i])	c++;
		}
		return c;
	}
	
	private int countBlacksOnCol(int col){
		int c=0;
		for(int i=0; i<board[0].length; i++){
			if(board[i][col])	c++;
		}
		return c;
	}
	
	public static void main(String[] args){
		NonogramSolver solver = new NonogramSolver(5, new int[][]{{3},{1},{4},{2},{1,2}}, new int[][]{{2}, {3}, {3}, {1, 1, 1}, {1, 1}});
		solver.backtracking(0, 0, 0);
	}
}
	
	

