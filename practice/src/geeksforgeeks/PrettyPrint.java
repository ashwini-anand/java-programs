package geeksforgeeks;

import java.util.*;

public class PrettyPrint {

	public static void main(String[] args) {
		prettyPrint(4);
	}

	public static void prettyPrint(int a) {
		int n = 2 * a - 1;
		boolean[][] visMat = new boolean[n][n];

		int[][] resMat = new int[n][n];
		int[] arrX = { 0, 1, -1, 0 };
		int[] arrY = { 1, 0, 0, -1 };

		int prevDir = 0;
		int count = 0;
		int locX = 0;
		int locY = 0;
		int pholder = a;
		resMat[0][0] = pholder;
		visMat[0][0] = true;
		int i = 0;
		while (true) {
			// System.out.println("here");
			if (i >= arrX.length) {
				// System.out.println("here1");
				break;
			}
			if (count == 4) {
				count = 0;
				pholder--;
			}
			while (locX + arrX[prevDir] >= 0 && locX + arrX[prevDir] < n
					&& locY + arrY[prevDir] >= 0 && locY + arrY[prevDir] < n
					&& !visMat[locX + arrX[prevDir]][locY + arrY[prevDir]]) {
				locX = locX + arrX[prevDir];
				locY = locY + arrY[prevDir];
				resMat[locX][locY] = pholder;
				visMat[locX][locY] = true;
			}
			//System.out.println(locX+" "+locY);
			//System.out.println(!visMat[locX + arrX[prevDir]][locY + arrY[prevDir]]);
			
			for (i = 0; i < arrX.length; i++) {
				if (locX + arrX[i] >= 0 && locX + arrX[i] < n
						&& locY + arrY[i] >= 0 && locY + arrY[i] < n
						&& !visMat[locX + arrX[i]][locY + arrY[i]]) {
					//System.out.println(prevDir);
					prevDir = i;
					count++;
					break;
				}

			}

		}

		ArrayList<ArrayList<Integer>> resAl = new ArrayList<ArrayList<Integer>>(); // this was List needed for submission in interviewbit
		for (int j = 0; j < n; j++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int j2 = 0; j2 < n; j2++) {
				System.out.print(resMat[j][j2]+" ");
				al.add(resMat[j][j2]);
				
			}
			resAl.add(al);
			System.out.println();
		}

	}
}
