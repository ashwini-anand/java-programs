package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Nkmobile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		MyScanner s = new MyScanner();
		int p = s.nextInt();
		int m = s.nextInt();
		int[][] matrix = new int[m][m];
		while (p != 3) {
			p = s.nextInt();
			if (p == 1) {

				int x = s.nextInt();
				int y = s.nextInt();
				int a = s.nextInt();
				//matrix[x][y] += a;
				for (int i = y; i < matrix.length; i++) {
						matrix[x][i] += a;
				}
			} else if (p == 2) {

				int l = s.nextInt();
				int b = s.nextInt();
				int r = s.nextInt();
				int t = s.nextInt();
				int sum =0, extra =0;
				for (int i = l; i <= r; i++) {
					sum+=matrix[i][t];
				}
				if(b!=0){
					for (int i = l; i <= r; i++) {
						extra+=matrix[i][b-1];
					}
				}
				System.out.println(sum-extra);
			}else{
				break;
			}
		}

	}
	
	static class MyScanner {
		   static BufferedReader br;
		   static StringTokenizer st;

		   public MyScanner() {
		      br = new BufferedReader(new InputStreamReader(System.in));
		   }

		    String  next() {
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

		    String nextLine(){
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
