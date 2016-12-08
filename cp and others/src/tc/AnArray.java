package tc;

import java.util.Arrays;

public class AnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solveProblem(int[] A, int K){
		
		int count =0;
		int n=A.length;
		
		Arrays.sort(A); //can not simply sort, create one more class with original index
		
		for (int i = 0; i < A.length-2; i++) {
			if(A[i]%K==0) count = count+(n-i-2);
		}
		
		for (int i = 0; i < A.length-2; i++) {
			int j=i+1;
			if((A[i]*A[j])%K == 0) count = count+(n-j-1);
			
			//Not done , To be done
			
		}
		
		return count;
		
	}

}
