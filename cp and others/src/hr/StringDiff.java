package hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyScanner in = new MyScanner();
		String a = in.next();
		String b = in.next();
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		if(a.length() < b.length()){
			System.out.println(0);
			return;
		}
		int count =0;
		for (int i = 0; i <= a.length()-b.length(); i++) {
			int chardiff =0;
			for (int j = 0; j < b.length(); j++) {
				if(aArr[i+j]!=bArr[j]) chardiff++;
				if(chardiff>=2) break;
			}
			
			if(chardiff==1) count++;
		}
		System.out.println(count);
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
