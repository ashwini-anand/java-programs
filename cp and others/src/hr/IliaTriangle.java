package hr;

import java.util.Scanner;

public class IliaTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[n];
		int rt = 0;
		int at = 0;
		int ot = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
			// arr1[i] = arr[i] * arr[i];
		}

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i] * arr[i];
		}

		for (int i = 0; i < arr1.length - 2; i++) {
			for (int j = i + 1; j < arr1.length - 1; j++) {
				for (int j2 = j + 1; j2 < arr1.length; j2++) {
					if (arr[i] + arr[j] > arr[j2]) {
						if (arr1[i] + arr1[j] == arr1[j2]) {
							rt++;

						}
						else if (arr1[i] + arr1[j] > arr1[j2]) {
							at++;
						}
						else {
							ot++;
//							ot = ot+(arr.length-j2-1);
//							break;
							int count =0;
							for (int k = j2+1; k < arr1.length; k++) {
								if(arr[i] + arr[j] > arr[k]) count++;
								else break;
							}
							ot += count;
							break;

						}
					} else {
						break;
					}
				}
			}
		}

		System.out.println(at + " " + rt + " " + ot);

	}

}
