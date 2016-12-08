
package hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BuildString {

	/**
	 * @param args
	 */
	static int minCost[];
	static String ss;
	static int a;
	static int b;
	
	static int findcost(int n){
		
		if(minCost[n]!=Integer.MAX_VALUE){
			return minCost[n];
		}
		if(n==0){
			return a;
		}
		
		int min = findcost(n-1)+a;
		
		for (int i = n/2; i <= n-2; i++) {
			if(ss.substring(0, i+1).contains(ss.substring(i+1, n+1))){
				int ccost = findcost(i);
				if(ccost+b<min){
					min = ccost+b;
				}
				break;
			}
		}
		minCost[n] = min;
		return min;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner s = new MyScanner();
		int t = s.nextInt();
		
		while(t>0){
			t--;
			int n=s.nextInt();
			a=s.nextInt();
			b=s.nextInt();
			ss=s.next();
			minCost = new int[n];
			Arrays.fill(minCost, Integer.MAX_VALUE);
			int min = findcost(n-1);
			System.out.println(min);
		}

	}
	
	static class MyScanner {
		static BufferedReader br;
		static StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

}
