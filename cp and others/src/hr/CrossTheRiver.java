package hr;

import java.util.Scanner;

class Rocks{
	int x;
	int y;
	int points;
	
	public Rocks(int x, int y, int p){
		this.x=x;
		this.y=y;
		this.points = p;
	}

	public Rocks() {
		// TODO Auto-generated constructor stub
	}
	
}



public class CrossTheRiver {

	/**
	 * @param args
	 */
	static int dh;
	static int dw;
	static boolean[][] vis;
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int h = s.nextInt();
	    dh = s.nextInt();
		dw = s.nextInt();
		int[][] rdist = new int[n+1][n+1];
		Rocks[] rarr = new Rocks[n+1];
		vis = new boolean[n+1][n+1];
		
		rarr[0]=new Rocks(0,0,0);
		
		
		for(int i=1;i<=n;i++){
			int x = s.nextInt();
			int y = s.nextInt();
			int p = s.nextInt();
			
			rarr[i] = new Rocks(x, y, p);
		}
		
		for (int i = 0; i < rarr.length; i++) {
			for (int j = 0; j < rarr.length; j++) {
				rdist[i][j] = -1;
			}
		}
		
		
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					if(isPath(rarr[i], rarr[j],i,j) && j>i){
						rdist[i][j] = rarr[i].points+rarr[j].points;
						vis[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					System.out.print(rdist[i][j]+"\t");
				}
				System.out.println();
			}
			
			for (int k = 0; k <= n; k++) {
				for (int i = 0; i <= n; i++) {
					for (int j = 0; j <= n; j++) {
						System.out.println("i="+i+" j="+j+" k="+k+" points="+rdist[i][j]);
						if(i==0&&j==5&&k==3){
							System.out.println(isPath(rarr[i], rarr[k],i,k)+" "+isPath(rarr[k], rarr[j],k,j)+"-------------------------------------");
						}
						if(isPath(rarr[i], rarr[k],i,k)&& isPath(rarr[k], rarr[j],k,j) && k>i && j>k){
							
							if(rdist[i][j] < rdist[i][k]+rarr[j].points) {
								rdist[i][j] = rarr[i].points+rarr[j].points+rarr[k].points;
								vis[i][j] = true;
							}
							System.out.println("i="+i+" j="+j+" k="+k+" points="+rdist[i][j]);
						}
					}
				}
			}
			
			int max = -1;
			for (int i = 0; i < rarr.length; i++) {
				if(rdist[0][i] > max) max = rdist[0][i];
			}
			
			System.out.println(max);
			
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					System.out.print(rdist[i][j]+"\t");
				}
				System.out.println();
			}
	}
	
	public static boolean isPath(Rocks r1,Rocks r2,int i, int j){
		
		if(r1.y==0 && r1.x==0){
			System.out.println((r2.y+" "+r1.y+" "+Math.abs(r2.y-r1.y)));
			if((r2.y > r1.y && Math.abs(r2.y-r1.y) <= dh) || (vis[i][j] == true)) return true;
		}
		else if((r2.y > r1.y && Math.abs(r2.y-r1.y) <= dh && Math.abs(r2.x-r1.x) <= dw) || (vis[i][j] == true)) return true;	
		
		return false;
		
	}

}
