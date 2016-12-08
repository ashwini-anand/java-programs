package gfg;

import java.util.Scanner;

public class ClosestKHE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int diff = Integer.MAX_VALUE;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(Math.abs(k-arr[i])<diff ){
				diff = Math.abs(k-arr[i]);
				res = arr[i];
			}else if(Math.abs(k-arr[i])==diff  && arr[i] > res){
				res = arr[i];
			}
		}
		
		System.out.println(res);

	}

}
