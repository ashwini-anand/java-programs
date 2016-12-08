package hr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class GreatestInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyScanner in = new MyScanner();
		int n = in.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			hs.add(in.nextInt());
		}
		ArrayList<Integer> al = new ArrayList<>();
		al.addAll(hs);
		int m = in.nextInt();
		boolean flag = false;
		while(true){
			flag = false;
			HashSet<Integer> hs2 = new HashSet<>();
			for (int i = 0; i < al.size(); i++) {
				for (int j = i+1; j < al.size(); j++) {
					int e1 = al.get(i);
					int e2 = al.get(j);
					if(!hs.contains(Math.abs(e1-e2))){
						flag = true;
						hs2.add(Math.abs(e1-e2));
					}
				}
				if(flag==false) break;
			} 
//			{
//				for (Integer e2 : hs) {
//					if(e1 != e2){
//						if(!hs.contains(Math.abs(e1-e2))){
//							flag = true;
//							hs2.add(Math.abs(e1-e2));
//						}
//					}
//				}
//			}
			if(flag==false) break;
			else{
				al.clear();
				hs.addAll(hs2);
				al.addAll(hs);
			}
		}
		//ArrayList<Integer> sortedList = new ArrayList<Integer>(hs);
		Collections.sort(al);
		System.out.println(al.get(al.size()-m));
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
