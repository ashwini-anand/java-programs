package uva.DP;

import java.util.*;

public class ECoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-->0){
			int m = in.nextInt();
			int s = in.nextInt();
			int conv[] = new int[m];
			int it[] = new int[m];
			int dp[][] = new int[s+1][s+1];
			
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			dp[0][0] =0;
			
			for (int i = 0; i < m; i++) {
				conv[i] = in.nextInt();
				it[i] = in.nextInt();
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = conv[i]; j <=s; j++) {
					for (int j2 = it[i]; j2 <= s; j2++) {
						if(dp[j-conv[i]][j2-it[i]] != Integer.MAX_VALUE){
							dp[j][j2] = Math.min(dp[j][j2], 1+dp[j-conv[i]][j2-it[i]]);
						}
					}
				}
			}
			int ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[i].length; j++) {
					if(i*i+j*j==s*s){
						if(dp[i][j] < ans){
							ans = dp[i][j];
						}
					}
				}
			}
			if(ans!=Integer.MAX_VALUE){
				System.out.println(ans);
			}else{
				System.out.println("not possible");
			}
		}

	}

}
