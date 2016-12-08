package hr;

import java.util.Scanner;

public class GridMaze {

	/**
	 * @param args
	 */
	static final int inf = 999999999;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int posP = 0;
		int posS = 0;
		
		char[][] str = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				str[i][j]=s.next().charAt(0);
				if(str[i][j] == 'P') posP = i*m+j;
				if(str[i][j] == 'S') posS = i*m+j;
			}
		}
		
		int t = m*n;
		int[][] gr = new int[m*n][m*n];
		
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				gr[i][j] = inf;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m-1; j++) {
				
				if((str[i][j]=='.' || str[i][j]=='S' || str[i][j]=='P') && (str[i][j+1]=='.' || str[i][j+1]=='S' || str[i][j+1]=='P')) {
					gr[i][i+1]=0;
					gr[i+1][i]=0;
				}else{
					gr[i][i+1]=1;
					gr[i+1][i]=1;
				}
				
			}
		}
		
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < m; j++) {
				if((str[i][j]=='.' || str[i][j]=='S' || str[i][j]=='P') && (str[i+1][j]=='.' || str[i+1][j]=='S' || str[i+1][j]=='P')){
					gr[j][j+n] = 1;
					gr[j+n][j] = 1;
				}else{
					gr[j][j+n] = 0;
					gr[j+n][j] = 0;
				}
				
			}
		}
		
		for (int k = 0; k < t; k++) {
			for (int i = 0; i < t; i++) {
				for (int j = 0; j < t; j++) {
					gr[i][j]= gr[i][j] > (gr[i][k]+gr[k][j]) ? (gr[i][k]+gr[k][j]):gr[i][j];
				}
			}
		}
		
		int costSP = gr[posS][posP];
		
		int costB = 0;
		
		for (int i = 0; i < t; i=i+n) {
			gr[i][0]=0;//left this pgm here
		}
		
		
		
		

	}

}
