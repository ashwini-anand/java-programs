package gfg; //uva

import java.util.Scanner;

public class BitMaps {

	/**
	 * @param args
	 */
	static String input;
	static int[][] matrix;
	static int idx;
	static char[][] bmatrix;
	static String btodoutput;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int arr[] = new int[2];
		String dim = s.nextLine();
		while (true) {
			if (dim.charAt(0) == '#') {
				break;
			}
			if (dim.charAt(1) == ' ') {
				String[] strarr = new String[3];
				strarr = dim.split("\\s+");
				arr[0] = Integer.parseInt(strarr[1]);
				arr[1] = Integer.parseInt(strarr[2]);
				input = "";
				while (true) {
					String str = s.nextLine();
					if (str.charAt(0) == '#'
							|| (str.length() > 1 && str.charAt(1) == ' ')) {
						dim = str;
						break;
					}
					input += str;
				}

				// System.out.println(strarr[0]+" "+arr[0]+" "+arr[1]+" "+input);
				if (strarr[0].charAt(0) == 'B') {
					matrix = new int[arr[0]][arr[1]];
					int inputIndx = 0;
					for (int i = 0; i < matrix.length; i++) {
						for (int j = 0; j < matrix[i].length; j++) {
							matrix[i][j] = Integer.parseInt(""
									+ input.charAt(inputIndx));
							inputIndx++;
						}
					}
					btodoutput = "";
					System.out.print("D");
					System.out.format("%4d",arr[0]);
					System.out.format("%4d",arr[1]);
					System.out.println();
					if (arr[0] == 0 && arr[1] == 0) {

					} else {
						convertBtoD(0, 0, arr[0] - 1, arr[1] - 1);
					}
					
					int count =0;
					int cc =0;
					for (int i = 0; i < btodoutput.length(); i++) {
						System.out.print(btodoutput.charAt(i));
						count++;
						cc++;
						if(count == 50 && cc != btodoutput.length()){
							System.out.println();
							count  =0;
						}
					}
					
					System.out.println();
				}

				else if (strarr[0].charAt(0) == 'D') {
					bmatrix = new char[arr[0]][arr[1]];
					idx = 0;
					System.out.print("B");
					System.out.format("%4d",arr[0]);
					System.out.format("%4d",arr[1]);
					System.out.println();
					if (arr[0] == 0 && arr[1] == 0) {

					} else {
						convertDtoB(0, 0, arr[0] - 1, arr[1] - 1);
					}
					int count = 0;
					int cc = 0;
					for (int i = 0; i < arr[0]; i++) {
						for (int j = 0; j < arr[1]; j++) {
							System.out.print(bmatrix[i][j]);
							count++;
							cc++;
							if (count == 50 && cc != (arr[0]*arr[1])) {
								System.out.println();
								count = 0;
							}
						}
					}

					System.out.println();
				}
			}
		}
	}

	public static void convertDtoB(int rowS, int colS, int rowE, int colE) {
		if (idx < input.length() && input.charAt(idx) != 'D') {
			for (int i = rowS; i <= rowE; i++) {
				for (int j = colS; j <= colE; j++) {
					bmatrix[i][j] = input.charAt(idx);
				}
			}
			idx++;
		} else if (idx < input.length()) {
			idx++;
			if (rowE - rowS == 0) {

				int colMid = (colE - colS) / 2 + colS;
				convertDtoB(rowS, colS, rowE, colMid); // topLeft
				convertDtoB(rowS, colMid + 1, rowE, colE); // topRight

			} else if (colE - colS == 0) {

				int rowMid = (rowE - rowS) / 2 + rowS;
				convertDtoB(rowS, colS, rowMid, colE); // topLeft
				convertDtoB(rowMid + 1, colS, rowE, colE); // bottomLeft
			}

			else {
				int rowMid = (rowE - rowS) / 2 + rowS;
				int colMid = (colE - colS) / 2 + colS;
				convertDtoB(rowS, colS, rowMid, colMid); // topLeft
				convertDtoB(rowS, colMid + 1, rowMid, colE); // topRight
				convertDtoB(rowMid + 1, colS, rowE, colMid); // bottomLeft
				convertDtoB(rowMid + 1, colMid + 1, rowE, colE); // bottomRight
			}
		}
	}

	public static void convertBtoD(int rowS, int colS, int rowE, int colE) {
		boolean allsame = true;
		int first = matrix[rowS][colS];
		for (int i = rowS; i <= rowE; i++) {
			for (int j = colS; j <= colE; j++) {
				if (first != matrix[i][j]) {
					allsame = false;
				}
			}
		}
		if (allsame == true) {
			//System.out.print(first);
			btodoutput += first;
		} else {
			//System.out.print("D");
			btodoutput += "D";
			if (rowE - rowS == 0) {

				int colMid = (colE - colS) / 2 + colS;
				convertBtoD(rowS, colS, rowE, colMid); // topLeft
				convertBtoD(rowS, colMid + 1, rowE, colE); // topRight

			} else if (colE - colS == 0) {

				int rowMid = (rowE - rowS) / 2 + rowS;
				convertBtoD(rowS, colS, rowMid, colE); // topLeft
				convertBtoD(rowMid + 1, colS, rowE, colE); // bottomLeft
			}

			else {
				int rowMid = (rowE - rowS) / 2 + rowS;
				int colMid = (colE - colS) / 2 + colS;
				convertBtoD(rowS, colS, rowMid, colMid); // topLeft
				convertBtoD(rowS, colMid + 1, rowMid, colE); // topRight
				convertBtoD(rowMid + 1, colS, rowE, colMid); // bottomLeft
				convertBtoD(rowMid + 1, colMid + 1, rowE, colE); // bottomRight
			}

		}
	}

}
