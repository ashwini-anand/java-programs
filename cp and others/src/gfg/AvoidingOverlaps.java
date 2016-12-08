package gfg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AvoidingOverlaps {

	/**
	 * @param args
	 */
	static class Rectangle {
		int lx;
		int ly;
		int rx;
		int ry;
		int area;

		public Rectangle() {
			// TODO Auto-generated constructor stub
		}

		public Rectangle(int lx, int ly, int rx, int ry, int area) {
			super();
			this.lx = lx;
			this.ly = ly;
			this.rx = rx;
			this.ry = ry;
			this.area = area;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScanner s = new MyScanner();
		int tc = s.nextInt();
		int t = 1;
		while (t <= tc) {
			//t++;
			int n = s.nextInt();
			if(n==0){
				System.out.println("Case "+t+": 0");
				t++;
				continue;
			}
			Rectangle rectarr[] = new Rectangle[n];
			int lx = s.nextInt();
			int ly = s.nextInt();
			int rx = s.nextInt();
			int ry = s.nextInt();
			Rectangle rect = new Rectangle(lx, ly, rx, ry, (ry - ly)
					* (rx - lx));
			rectarr[0] = rect;
			int rectCount = 1;
			for (int i = 1; i < n; i++) {
				lx = s.nextInt();
				ly = s.nextInt();
				rx = s.nextInt();
				ry = s.nextInt();
				boolean flag = false;
				for (int j = 0; j < rectCount; j++) {
					if (isOverlapping(rectarr[j], lx, ly, rx, ry)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					rectarr[rectCount++] = new Rectangle(lx, ly, rx, ry,
							(ry - ly) * (rx - lx));
				}
			}
			
			int res = 0;
			for (int i = 0; i < rectCount; i++) {
				res+=rectarr[i].area;
			}
			System.out.println("Case "+t+": "+res);
			t++;
		}

	}

	public static boolean isOverlapping(Rectangle rect, int lx, int ly, int rx,
			int ry) {
		if(rect.lx >= rx || lx >= rect.rx) return false;
		if(rect.ry <= ly || rect.ly >= ry) return false;
		
		return true;

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
