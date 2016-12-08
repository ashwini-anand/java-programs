package uva.DP;

import java.util.*;

public class WeddingShoping2 {

	/**
	 * @param args
	 */
	static ArrayList<Integer>[] garments;
	static boolean[][] mat;
	static int max;
	static int m;
	static int c;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t > 0) {
			t--;
			m = in.nextInt();
			c = in.nextInt();
			garments = (ArrayList<Integer>[]) new ArrayList[c];
			mat = new boolean[c][m + 1];
			if (c == 0) {
				System.out.println(0);
				continue;
			}
			if (m == 0) {
				System.out.println("no solution");
				continue;
			}
			for (int i = 0; i < c; i++) {
				int k = in.nextInt();
				ArrayList<Integer> al = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					al.add(in.nextInt());
				}
				garments[i] = al;
			}

			max = Integer.MIN_VALUE;
			recurse(0, 0);
			if(max == Integer.MIN_VALUE){
				System.out.println("no solution");
			}else{
				System.out.println(max);
			}
		}

	}

	public static void recurse(int sum,int n){
		if(n==c){
			if(sum<=m && sum>max){
				max = sum;
			}
			return;
		}
		if(sum > m || mat[n][sum]) return;
		mat[n][sum] = true;
		for (int i = 0; i < garments[n].size(); i++) {
			recurse(sum+garments[n].get(i), n+1);
		}
		
	}
}
