package uva.DP;

import java.util.Scanner;

public class MaximumSumTorus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int mat[][] = new int[n][n];
			if(n==0){
				System.out.println(0);
				continue;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = in.nextInt();
				}
			}
			int maxSum =Integer.MIN_VALUE;
			for (int i = 0; i < mat.length; i++) {
				int[] arr  = new int[n];
				for (int j = i,j3=0; j3 < mat.length; j3++,j=(j+1)%mat.length) {
					for (int j2 = 0; j2 < mat.length; j2++) {
						arr[j2] += mat[j2][j];
					}
					int sum = circularKadane(arr);
					if(sum > maxSum){
						maxSum = sum;
					}
				}
			}
			System.out.println(maxSum);
		}
	}

	public static int circularKadane(int[] arr){
		int max_kadane = kadane(arr);
		if(isAllOfSameSign(arr)){
			return max_kadane;
		}
		int max_wrap =0;
		for (int i = 0; i < arr.length; i++) {
			max_wrap += arr[i];
			arr[i] = -arr[i];
		}
		max_wrap = max_wrap + kadane(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = -arr[i];
		}
		return (max_wrap > max_kadane)? max_wrap: max_kadane;
	}
	public static boolean isAllOfSameSign(int[] arr){
		long sum =arr[0];
		long absSum = Math.abs(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			absSum += Math.abs(arr[i]);
			if(Math.abs(sum)<absSum) return false;
		}
		return true;
	}
	
	public static int kadane(int[] arr){
		int maxGlobal = arr[0];
		int maxCurrent = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			maxCurrent = Math.max(arr[i], maxCurrent+arr[i]);
			maxGlobal = Math.max(maxGlobal, maxCurrent);
		}
	    return maxGlobal;	
	}
//This algo will also work. Instead of 	circularKadane , put circularKadane1 in main function
//	public static int circularKadane1(int[] arr) {
//		int maxGlobal = arr[0];
//
//		for (int i = 0; i < arr.length; i++) {
//			int maxCurrent = arr[i];
//			for (int j = (i + 1) % arr.length, j2 = 0; j2 < arr.length-1; j2++, j = (j + 1)
//					% arr.length) {
//				maxCurrent = Math.max(arr[j], maxCurrent + arr[j]);
//				maxGlobal = Math.max(maxGlobal, maxCurrent);
//			}
//		}
//		return maxGlobal;
//	}
}
