/*Not a correct solution. 
use greedy*/

package hr;

import java.util.Arrays;
import java.util.Scanner;

public class Mandragora {

	/**
	 * @param args
	 */
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-- >0){
			int n = in.nextInt();
			arr = new int[n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			dp=new int [1000][100000];
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}
			
			System.out.println(getExp(1, 0));
		}

	}
	
	public static int getExp(int s, int k){
		
		int n = arr.length;
		if(k==n-1){
			return s*arr[k];
		}
		
		if(dp[s][k] != -1) return dp[s][k];
		
		return Math.max(getExp(s+1, k+1), getExp(s, k+1)+s*arr[k]);
		
	}

}
