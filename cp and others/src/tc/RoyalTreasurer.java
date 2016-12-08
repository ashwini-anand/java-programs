package tc;

import java.util.Arrays;

public class RoyalTreasurer {
	public static void main(String[] args) {
		int[] a= {5,15,100,31,39,0,0,3,26};
		int[] b={11,12,13,2,3,4,5,9,1};
		System.out.println(minimalArrangement(a,b));;
	}
	
	public static int minimalArrangement(int[] A, int[] B){
		
		Arrays.sort(A);
		Arrays.sort(B);
		int sum =0;
		for (int i = 0; i < B.length; i++) {
			sum += A[i] * B[B.length - i -1];
		}
		return sum;
	}

}
