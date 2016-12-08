package hr;

import java.util.Scanner;

// Hacker Country

class cities{
	int cost;
	int hops;
}

public class Solution2 {

	/**
	 * @param args
	 */
	
	public static int gcd(int x,int y){
		int m =x,res=1;
	    if(x>y)
	         m=y;
	    for(int i=m;i>=1;i--){
	         if(x%i==0&&y%i==0){
	        	 res =i;
	             break;
	         }
	    }
	    return res;
	    
	}
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		cities graph[][] = new cities[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int c = s.nextInt();
				//s.nextLine();
				graph[i][j] = new cities();
				graph[i][j].cost = c;
				graph[i][j].hops = 1;
			}
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(graph[i][k].cost + graph[k][j].cost < graph[i][j].cost){
						graph[i][j].cost = graph[i][k].cost + graph[k][j].cost;
						graph[i][j].hops++;
					}
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.printf("%4d",graph[i][j].cost);
//			}
//			System.out.println();
//		}
		
		cities minCity=graph[0][1] ;
		cities secondmincity = graph[1][0];
		int min = graph[0][1].cost + graph[1][0].cost;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((i !=j) && min > (graph[i][j].cost + graph[j][i].cost)){
					minCity = graph[i][j];
					secondmincity = graph[j][i];
				}
			}
		}
		//System.out.println(min+" "+(minCity.hops+secondmincity.hops));
		
		int gcd  = gcd(min, (minCity.hops+secondmincity.hops));
		int numer = min/gcd;
		int denom = (minCity.hops+secondmincity.hops)/gcd;
		System.out.println(numer+"/"+denom);
		
	}

}
