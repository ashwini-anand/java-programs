package Misc;

import java.util.*;

/*Solution approach:
Straightforward implementation by storing characters in a matrix and then printing	it as required
*/

public class EncodingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		String str = in.next();
		String input = str.replaceAll("\\s+", "");
		int n = input.length();

		char[] inarr = input.toCharArray();
		double rows = Math.sqrt(n);
		rows = Math.floor(rows);
		int r = (int) rows; // number of rows
		double cols = Math.sqrt(n);
		cols = Math.ceil(cols);
		int c = (int) cols; // number of cols

		if (r * c < n) { // check if r*c is greater equal to n
			r++;
		}

		char[][] matrix = new char[r][c];
		int k = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				matrix[i][j] = inarr[k];
				k++;
				if (k >= n) {
					break;
				}
			}
			if (k >= n) {
				break;
			}
		}

		k = 0;
		for (int j = 0; j < c; j++) {
			String res = "";
			for (int i = 0; i < r; i++) {
				//if(matrix[i][j] != ' ')
				System.out.print(matrix[i][j]);
			}
			System.out.print(" ");
		}

	}

}
