package uva.DP;

import java.util.Scanner;

public class DividingCoins {

	/**
	 * @param args
	 */
	static int coins[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t>0){
        	t--;
        	int sum =0;
        	int m = in.nextInt();
        	coins = new int[m];
        	for (int i = 0; i < m; i++) {
				coins[i] = in.nextInt();
				sum += coins[i];
			}
        	int sumby2 =sum/2;
        	if(sum%2 !=0){
        		sumby2 = sumby2 + 1;
        	}
        	boolean mat[][] = new boolean[sumby2+1][m+1];
        	
        	for (int i = 0; i <=m; i++) {
				mat[0][i] = true;
			}
        	
        	for (int i = 1; i <=sumby2; i++) {
				mat[i][0] = false;
			}
        	
        	for (int i = 1; i <= sumby2; i++) {
				for (int j = 1; j <=m; j++) {
					mat[i][j] = mat[i][j-1];
					if(i>=coins[j-1]){
						mat[i][j] = mat[i][j] || mat[i-coins[j-1]][j-1];
					}
				}
			}
        	int i = sumby2;
        	for (i = sumby2; i >=0; i--) {
				if(mat[i][m]==true) break;
			}
        	System.out.println(Math.abs(sum-2*i));
        }
	}

}
