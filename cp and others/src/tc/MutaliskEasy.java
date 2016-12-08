package tc;

public class MutaliskEasy {
	public static void main(String[] args) {
      int[] x ={60, 40}   ;
      System.out.println(minimalAttacks(x));
		
	}
	
	public static int minimalAttacks(int[] x){
		
		int dp[][][] = new int[61][61][61];
		int att[][] = {{1,3,9},{3,1,9},{9,1,3},{9,3,1},{1,9,3},{3,9,1}};
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				for (int j2 = 0; j2 < 61; j2++) {
					if(i==0 && j==0 && j2==0) continue;
					dp[i][j][j2] = 10000000;
					for (int k = 0; k < att.length; k++) {
						int newx=0,newy=0,newz=0;
						newx = Math.max(0, i-att[k][0]);
						newy = Math.max(0, j-att[k][1]);
						newz = Math.max(0, j2-att[k][2]);
						dp[i][j][j2] = Math.min(dp[i][j][j2], dp[newx][newy][newz]+1);
					}
				}
			}
		}
		//System.out.println(dp[12][10][4]);
		int a=0,b=0,c=0;
		a=x[0];
		if(x.length > 1) b=x[1];
		if(x.length > 2) c=x[2];
		return dp[a][b][c];
		
	}

}
