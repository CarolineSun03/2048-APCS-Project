import java.util.Random;

public class Board {
 
	private int[][] board; // holds state of game
	private Random rnd = new Random(); // setup random # generator
	
	//What instance variable can you add to keep track of the size or the number of tiles occupied?
	int size = 0;
    /*
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 4; j++){
            if(board[i][j] != 0){
                size += 1;
            }
        }
    }
    */
    
	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {
		
		// instantiate the board
		board = new int[4][4];
		
	}

	/*
	 * return a String representation of the 2D array board
	 * each row should be in its own line
	 * 
	 * Example:
	 * 
	 * { {1, 2, 3}, {4, 5, 6}} -> 1 2 3
	 * 
	 * 4 5 6
	 */

	
	// overriding a method is when a "child"
	// class implement the exact same method
	// that its parent class has
	public String toString() {
		
		/*
		 * Use the String formatter to pad the numbers with leading 0s
		 * so that the print out does not become jagged
		 * An example is shown below. 
		 * String str = String.format("%04d", 9);  // 0009  
		 * int x = 30;
		 * System.out.println(String.format("%04d",x));
		 *     
		 */
		
		//setup loops to visit
		//every spot possible
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(String.format("%04d", board[i][j]) + " ");
            }
            System.out.println();
        }
		
		return "";
	}

	/*
	 * set one of the empty spaces (at random)
	 * to a 2 or 4 (90/10 chance). an empty spot is defined to be a 0 element
	 * Must use the Random class object rnd.
	 * Example Use of rnd object.
	 * 
	 * int randomNum = rnd.nextInt(10); //returns a number in range [0 10) (not
	 * inclusive on the 10)
	 */

	public void populateOne() {
		
		// is there an empty spot?
		// for randomness, generate a row and column
		// check if that tile is empty, if it is NOT empty,
		// generate another set of row and column
		// what happens if the entire board is full??! 
		boolean space = true;

		if(size != 16){
			while(space){
				int row = rnd.nextInt(4);
				int col = rnd.nextInt(4);
				if(board[row][col] == 0){
					if(rnd.nextInt(10) < 9){
						board[row][col] = 2;
					}else{
						board[row][col] = 4;
					}
					space = false;
				}
			}
			size += 1;		
		}else{
			gameOver();
		}
	}

	/*
	 * 
	 * Given an array of integers, slide all non-zero elements to the right.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2]->[0 0 2 2]
	 * [2 8 0 2]->[0 2 8 2]
	 * [4 0 0 0]->[0 0 0 4]
	 */

	public void slideRight(int[] row) {
		int count = 3;
		for(int i = 3; i >= 0; i--){
			if(row[i] != 0){
				row[count] = row[i];
				if(i != count){
					row[i] = 0;
				}
				count -= 1;
			}
		}
	}

	/*
	 * 
	 * Move the numbers as far to the right as they can go
	 * aka the numbers are trying to move to the right-most
	 * empty spaces. This method must utilize the slideRight(int[] row) method
	 * must utilize the helper method above for full credit.
	 * param: a valid row of 2048 where 0s are "empty" spots
	 * effect: row is modified so all numbers are to the right side
	 * return: none
	 */

	public void slideRight() {

		// go through 2D array, move all digits as far right as possible
		//setup a loop to grab ONE row at a time from 2d array board
		for(int i = 0; i < 4; i++){
			slideRight(board[i]);
		}		
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the left.
	 * zero elements are considered open spots.
	 * example:
	 * 
	 * [0 2 0 2] -> [2 2 0 0]
	 * [2 0 0 2] -> [2 2 0 0]
	 */

	public void slideLeft(int[] arr) {
		int count = 0;
		for(int i = 0; i < 4; i ++){
			if(arr[i] != 0){
				arr[count] = arr[i];
				if(i != count){
					arr[i] = 0;
				}
				count += 1;
			}
		}
	}

	/*
	 * Slide all the numbers to the left so that
	 * 
	 * all of the empty spaces are on the right side
	 */

	public void slideLeft() {
		
		// grabbing a row from a 2D array
		// if it's called arr then arr[i] grabs ONE row!
		
		//visit every single row in the 2D array
		//call the slideLeft method that takes in one argument
		for(int i = 0; i < 4; i++){
			slideLeft(board[i]);
		}	
	}

	/**
	 * Given a 2D array and a column number, return a 1D array representing the
	 * elements in the given column number.
	 */
	public int[] getCol(int[][] data, int c) {
		int[] column = new int[4];
		for(int i = 0; i < 4; i++){
			column[i] = data[i][c];
		}

		//you can also add print out statements here
		return column;
		
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the top.
	 * 
	 * zero elements are considered open spots.
	 */

	public void slideUp(int[] arr) {
		/* calls a helper method */
		// do not rewrite logic you already have!
		slideLeft(arr);
	}

	/*
	 * 
	 * Slide all elements in the board towards the top.
	 * 
	 * You must use slideUp and getCol for full credit.
	 */
	public void slideUp() {
		
		//visit every column index
		//grab each column as an array using getCol -> keep track of it in a 1d array
		// variable/reference
		//have slideLeft perform manipulation on the array
		// copy over the 1D array representation of the column
		// back to the 2D board array
		int[] temp;
		for(int i = 0; i < 4; i++){
			temp = getCol(board, i);
			slideUp(temp);
			for(int j = 0; j < 4; j++){
				board[j][i] = temp[j];
			}
		}
	}

	public void slideDown(int[] arr) {
		slideRight(arr);
	}

	/*
	 * slide all the numbers down so that any
	 * empty space is at the top
	 * You must use slideDown and getCol for full credit.
	 */
	public void slideDown() {
		int[] temp;
		for(int i = 0; i < 4; i++){
			temp = getCol(board, i);
			slideDown(temp);
			for(int j = 0; j < 4; j++){
				board[j][i] = temp[j];
			}
		}
	}

	/*
	 * Given the 2D array, board, combineRight will take adjacent numbers that
	 * are the same and combine them (add them).
	 * After adding them together, one of the numbers is zeroed out. For
	 * example, if row 0 contained [0 0 4 4],
	 * a call to combineRight will produce [0 0 0 8]. If row 1 contained [2 2 2
	 * 2], a call to combineRight will
	 * produce [0 4 0 4].
	 * 
	 * Notice that the left element is zeroed out.
	 * 
	 * Although you are not asked to write helper methods for combine, you are 
	 * highly encouraged to do so to break down the problem. It can help with 
	 * debugging, but it's not necessary to complete the problem.
	 */

	public void combineRight() {
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == board[i][j+1]){
					board[i][j] = 0;
					board[i][j+1] *= 2;
					j += 1;
					size -= 1;
				}
			}
			slideRight(board[i]);
		}
	}

	/*
	 * same behavior as combineRight but the right element is zeroed out when
	 * two elements are combined
	 */

	public void combineLeft() {
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j] == board[i][j+1]){
					board[i][j+1] = 0;
					board[i][j] *= 2;
					j += 1;
					size -= 1;
				}
			}
			slideLeft(board[i]);
		}
	}
	
	/*
	 * same behavior as combineRight but the bottom element is zeroed out when
	 * two elements are combined
	 */

	public void combineUp() {
		int[] temp;
		for(int i = 0; i < 4; i++){
			temp = getCol(board, i);
			for(int j = 0; j < 3; j++){
				if(temp[j] == temp[j+1]){
					temp[j+1] = 0;
					temp[j] *= 2;
					j += 1;
					size -= 1;
				}
			}
			slideUp(temp);
			for(int j = 0; j < 4; j++){
				board[j][i] = temp[j];
			}
		}
	}

	/*
	 * same behavior as combineRight but the top element is zeroed out when two
	 * elements are combined
	 */

	public void combineDown() {
		int[] temp;
		for(int i = 0; i < 4; i++){
			temp = getCol(board, i);
			for(int j = 0; j < 3; j++){
				if(temp[j] == temp[j+1]){
					temp[j] = 0;
					temp[j+1] *= 2;
					j += 1;
					size -= 1;
				}
			}
			slideDown(temp);
			for(int j = 0; j < 4; j++){
				board[j][i] = temp[j];
			}
		}
	}

	
	
	/* reminder: these are the methods that will ultimately invoke
	 * a series of methods
	 */
	public void left() {
		//1) numbers slide to the left
		//2) combine
		//3) slide
	}

	public void right() {

	}

	public void up() {

	}

	public void down() {

	}

	public void eraseBoard() {
		for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                board[i][j] = 0;
            }
        }
	}

	public boolean gameOver() {
		return false;
	}

	public int[][] getBoard() {
		return board;
	}

	// populate with a given 2d array
	public void populate(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
			}
		}
	}

}
