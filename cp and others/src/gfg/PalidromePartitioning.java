package gfg;

import java.util.Scanner;

public class PalidromePartitioning {

	/**
	 * @param args
	 */
	
	public static int minPartition(String str){
		
		int n = str.length();
		boolean p[][] =  new boolean[n][n];
		for (int i = 0; i < n; i++) {
			p[i][i] = true;
		}
		
		for (int L = 2; L <=n; L++) {
			for (int i = 0; i < n-L+1; i++) {
				int j = i+L-1;
				if(L==2) {
					p[i][j] = str.charAt(i) == str.charAt(j);
					
				}
				else{
					p[i][j] = (str.charAt(i) == str.charAt(j)) && p[i+1][j-1];
				}
			}
		}
		
		int c[] =  new int[n];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = Integer.MAX_VALUE;
			for (int j = 0; j <= i; j++) {
				if(j==0){
					if(p[0][i] == true) {
						c[i] =0;
						break;
					}
				}
				else 
					if(p[j][i]== true && c[j-1] + 1 < c[i]){
					c[i] = c[j-1] + 1;
				}
			}
		}
		
		return c[n-1];
		
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter string");
		String str = s.next();
		int n = minPartition(str);
		System.out.println("Minimum partition needed is "+n);
	}

}
