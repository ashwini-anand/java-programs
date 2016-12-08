package hr;

import java.util.Arrays;
import java.util.Scanner;

public class FindMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		long[] arr = new long[n];
		long maxnum = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextLong();
			//if(arr[i]>maxnum) maxnum = arr[i];
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(arr[i]+" ");
//		}
		
		//Arrays.sort(arr);
		
//		if(n%2==1) System.out.println(arr[(n-1)/2]);
//		else {
//			
//		}
		
//		long[][] cubeArr = new long[(int) maxnum][(int) maxnum];
//		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				cubeArr[i][j] = Long.MAX_VALUE;
//			}
//		}
		
		Arrays.sort(arr);
		maxnum = arr[arr.length-1];
		
		long max =Long.MAX_VALUE;
		long sum =0;
		long digit = -1;
		for (int i = 0; i <= maxnum; i++) {
			sum =0;
			for (int j = 0; j < n; j++) {
//				cubeArr[i][j] = cubeArr[i][j] == Long.MAX_VALUE ? getcube(Math.abs(i-arr[j])) : cubeArr[i][j];
//				cubeArr[j][i]=cubeArr[i][j];
//				sum += cubeArr[i][j];
				sum+=getcube(i-arr[j]);
			}
			//System.out.println(sum);
			if((max > sum ) || ((max == sum) && (digit > i))){
				max = sum;
				digit = i;
			}
			
			
		}
		
		System.out.println(digit);
		
	}
	
	public static long getcube(long num){
		
		long cube = num*num*num;
		
		return cube = cube < 0 ? -cube : cube;
		
		
	}

}
