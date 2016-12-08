package hr;

import java.util.Scanner;

public class FairRations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		int count =0;
		for (int i = 0; i < n-1; i++) {
			if(arr[i] % 2!=0){
				arr[i]++;
				arr[i+1]++;
				count += 2;
			}
		}
		
		if(arr[n-1]%2==0){
			System.out.println(count);
		}else{
			System.out.println("NO");
		}

	}

}
