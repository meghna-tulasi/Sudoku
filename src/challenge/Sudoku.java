package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku {
	public static final int SIZE = 9;
	public static final int EMPTY = 0;

	public static void main(String args[]) 
	{
		int[][] sudokuBoard = new int[SIZE][SIZE];
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 0 for blank input/cell");

		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				System.out.format("Enter number for A[%d][%d]:", i, j);
				sudokuBoard[i][j] = scan.nextInt();
				if(sudokuBoard[i][j] > 9 || sudokuBoard[i][j] < 0)
					throw new IllegalArgumentException("number must be between 0 and 9");
			}
		}
		getHints(sudokuBoard);
	}


	//row check
	public static boolean checkInRow(int[][] sudokuBoard, int row, int hint) {
		checkArgument(hint);
		for (int i = 0; i < SIZE; i++)
			if (sudokuBoard[row][i] == hint)
				return true;

		return false;
	}

	//column check
	public static boolean checkInColumn(int[][] sudokuBoard,int col, int hint) {
		checkArgument(hint);
		for (int i = 0; i < SIZE; i++)
			if (sudokuBoard[i][col] == hint)
				return true;

		return false;
	}

	//box check
	public static boolean checkInBox(int[][] sudokuBoard, int row, int col, int hint) {
		checkArgument(hint);
		int r = row - row % 3;
		int c = col - col % 3;

		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (sudokuBoard[i][j] == hint)
					return true;

		return false;
	}

	//combing all three checks to fit in the cell
	public static boolean isValid(int[][] sudokuBoard,int row, int col, int hint) {
		checkArgument(hint);
		return !checkInRow(sudokuBoard,row, hint)  &&  !checkInColumn(sudokuBoard,col, hint)  &&  !checkInBox(sudokuBoard,row, col, hint);
	}

	//main function
	public static void getHints(int[][] sudokuBoard) {
		int[] hints = {1,2,3,4,5,6,7,8,9};

		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if(sudokuBoard[row][col] != EMPTY) //for non empty cell return empty list
					System.out.println(new ArrayList<>());
				else {
					List<Integer> output = new ArrayList<>();
					for (int i = hints[0]; i <= SIZE; i++) { //for empty cell find for each number and append the list
						if (isValid(sudokuBoard,row, col, i)) {
							output.add(i);
						}
					}
					System.out.format("A[%d][%d]:", row, col);
					System.out.println(output);
				}
			}
		}
	}

	public static void checkArgument(int num) {
		if(num > 9 || num < 0)
			throw new IllegalArgumentException("number must be between 0 and 9");
	}
}