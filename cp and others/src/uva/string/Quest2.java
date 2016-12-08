package uva.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Quest2 {

	/**
	 * @param args
	 */
	//static int[] colors;
	public static int sum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- >0){
			int n = in.nextInt();
			int[] colors = new int[n];
			sum =0;
			for (int i = 0; i < n; i++) {
				colors[i] = in.nextInt();
				sum += colors[i];
			}
			
			int[] arr = new int[sum];
			Arrays.fill(arr, -1);
			res =0;
			recurse(colors,arr,0);
			
		}

	}
	static int res;
	static void recurse(int[] colors, int[] arr, int k){
		if(k==sum && arr[0] != arr[sum-1]){
			res++;
		}
		
		
		
	}

}
