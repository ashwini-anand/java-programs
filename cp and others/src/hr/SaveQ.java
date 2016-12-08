package hr;

import java.util.Scanner;

public class SaveQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t > 0) {
			t--;
			int n = s.nextInt();
			int[] arr = new int[n];
			// int[] arr1 = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}

			int count = 0;
			if (n == 1) {
				//int res = arr[0] == 0 ? 1 : 0;
				System.out.println(0);
				continue;
			}
			

			for (int i = 1; i < arr.length - 1; i++) {
				if (arr[i] == 0) {
					if (arr[i - 1] != 1 && arr[i + 1] != 1) {
						arr[i] = 1;
						count++;
					}else if(arr[i-1]==2 && arr[i+1]==1){
						arr[i-1]= 1;
						count++;
					}else if(arr[i-1] == 1 && arr[i+1]==0){
						arr[i]=2;
					}
				}
			}

			if (arr[0] == 0) {
				if (arr[1] == 0 || arr[1]==2) {
					arr[0] = 1;
					count++;
				}
			}
			
			if (arr[n - 1] == 0) {
				if (arr[n - 2] == 0 || arr[n-2] == 2) {
					arr[n - 1] = 1;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}

}
