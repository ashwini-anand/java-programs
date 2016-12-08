package geeksforgeeks;

import java.util.*;

public class MinimumSquares{

	public static int max = 99999;
	public static int[] table;
	
	public static void main(String[] args){
		int n = 100;
		table = new int[n+1];
		Arrays.fill(table,max);
		table[0] =0;
		System.out.println(getMinimumsquares(n));

	}

	public static int getMinimumsquares(int n){
		int a = (int)Math.sqrt(n);

		for(int i =1; i<=a;i++){
			for(int j=1;j<=n;j++){
				if(j-i*i >=0){
					table[j] = Math.min(table[j],1+table[j-i*i]);
				}
			}
		}
		return table[n];
	}

}