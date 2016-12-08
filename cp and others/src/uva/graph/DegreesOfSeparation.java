package uva.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DegreesOfSeparation {

	/**
	 * @param args
	 */
	static int maxvalue = 99999;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int netNum = 1; // network number
		while (true) {
			int p = in.nextInt();
			int r = in.nextInt();

			if (p == 0 && r == 0)
				break;
			// if (netNum != 1) {
			// System.out.println();
			// }
			int[][] mat = new int[p][p];

			for (int i = 0; i < mat.length; i++) {
				Arrays.fill(mat[i], maxvalue);
				mat[i][i] = 0;
			}

			HashMap<String, Integer> hm = new HashMap<String, Integer>();
			int vertNum = 0; // vertex number
			for (int i = 0; i < r; i++) {
				String s1 = in.next();
				String s2 = in.next();
				int v1 = -1;
				int v2 = -1;
				if (hm.containsKey(s1)) {
					v1 = hm.get(s1);
				} else {
					v1 = vertNum++;
					hm.put(s1, v1);
				}
				if (hm.containsKey(s2)) {
					v2 = hm.get(s2);
				} else {
					v2 = vertNum++;
					hm.put(s2, v2);
				}

				mat[v1][v2] = 1;
				mat[v2][v1] = 1;

			}

			for (int k = 0; k < mat.length; k++) {
				for (int j = 0; j < mat.length; j++) {
					for (int j2 = 0; j2 < mat.length; j2++) {
						if (mat[j][k] + mat[k][j2] < mat[j][j2]) {
							mat[j][j2] = mat[j][k] + mat[k][j2];
						}
					}
				}
			}

			int res = -1;
			boolean isDisc = false;
			System.out.print("Network " + netNum + ": ");
			netNum++;
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat.length; j++) {
					if (mat[i][j] == maxvalue) {
						System.out.println("DISCONNECTED");
						isDisc = true;
						break;
					} else {
						if (mat[i][j] > res) {
							res = mat[i][j];
						}
					}
				}
				if (isDisc)
					break;
			}
			if (!isDisc) {
				System.out.println(res);
			}
			System.out.println();
		}
		in.close();
	}

}
