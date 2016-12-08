package hr;

import java.util.Arrays;
import java.util.Scanner;

public class GameOfRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]= s.nextInt();
		}
		
		//Arrays.sort(arr);
		
		int sum =0,k=0;
		int maxsum = sum;
		while(k<n){
			k++;
			int i=k-1;
			sum=0;
			int counter =0;
			while(counter<n) {
				//System.out.println(arr[counter]+" "+((i%n)+1));
				sum+=arr[counter]*((i%n)+1);
				i++;
				counter++;
			}
			if(maxsum < sum){
				maxsum = sum;
			}
		
	   }
		System.out.println(maxsum);
	}

}
