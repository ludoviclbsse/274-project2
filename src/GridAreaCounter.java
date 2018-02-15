import java.io.*;
import java.util.Scanner;

public class GridAreaCounter {

	public static void read(String fileName, char[][] grid) {
		int i = 0;
		try {
			Scanner read = new Scanner(new File(fileName));
			do {
				String line = read.nextLine();
				for (int j = 0; j < 8; j++) {
					grid[i + 1][j + 1] = line.charAt(j);
				}
				i++;
			} while (read.hasNext());
			read.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("File was not found");
		}
	}

	public static void printGrid(char[][] grid) {
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

	public static void fillGrid(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = '#';
			}
		}
	}

	public static int countArea(char[][] grid, int x, int y, int count) {
		if (grid[x][y] != 'o') {
			return count;
		}
		grid[x][y] = '-';
		return countArea(grid, x + 1, y, count) + countArea(grid, x - 1, y, count) + countArea(grid, x, y + 1, count)
				+ countArea(grid, x, y - 1, count) + 1;
	}
	
	public static void checkGrid(char[][]grid) {
		int area = 1;
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				if (grid[i][j] == 'o') {
					System.out.println("Area " + area + " = " + countArea(grid, i, j, 0));
					area++;
				}
			}
		} 
	}

	public static void main(String[] args) {
		char[][] grid = new char[10][10];
		fillGrid(grid);
		read("grid1.txt", grid);
		printGrid(grid);
		checkGrid(grid);
		printGrid(grid);
	}

}
