package tc;

import java.util.Arrays;

class Counter{
	int count4;
	int count7;
	
}


public class LuckyCycle {
	static final int inf = 9999;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] edge1 = {1, 3, 2, 4};
//		int[] edge2 = {2, 2, 4, 5};
//		int[] weight = {4, 7, 4, 7};
		int[] edge1 = {1, 2, 3, 5, 6};
		int[] edge2 = {2, 3, 4, 3, 5};
		int[] weight = {4, 7, 7, 7, 7};
		//System.out.println(Arrays.toString((getEdge(edge1, edge2, weight))));

	}

	public static	int[] getEdge(int[] edge1, int[] edge2, int[] weight){
		int n = edge1.length+2;
		int[][] ed = new int[n][n];
		int[][] ed2 = new int[n][n];
		int[] res = new int[3];
		//res = {};
		Counter[][] c = new Counter[n][n];
		for(int i=0;i<n;i++){
			for (int j = 0; j < n; j++) {
				ed[i][j] = inf;
				ed2[i][j] = inf;
			}
		}
		
		for (int i = 0; i < edge1.length; i++) {
		//	System.out.println(edge1[i]+" "+edge2[i]);
			ed[edge1[i]][edge2[i]] = 1;
			ed2[edge1[i]][edge2[i]] = weight[i];
			
			ed[edge2[i]][edge1[i]] = 1;
			ed2[edge2[i]][edge1[i]] = weight[i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Counter cc = new Counter();
				cc.count4 =0;
				cc.count7 = 0;
				c[i][j] = cc;
			}
		}
		
		
		for (int i = 0; i < c.length; i++) {
			
		}
		
		for (int k = 0; k < ed.length; k++) {
			for (int i = 0; i < ed.length; i++) {
				for (int j = 0; j < ed.length; j++) {
					if((Math.min(ed[i][j], ed[i][k]+ed[k][j]) == ed[i][j]) && ed[i][j] == 1){
						//System.out.println(ed2[i][j]);
						if(ed2[i][j] == 4) c[i][j].count4=1;
						if(ed2[i][j] == 7) c[i][j].count7=1;
						
					}else if((Math.min(ed[i][j], ed[i][k]+ed[k][j]) == ed[i][k]+ed[k][j])){
						//if(k==2 && i==1 && j==4) System.out.println("here--------"+c[i][k].count4);
						c[i][j].count4 =(c[i][k].count4 + c[k][j].count4);
						c[i][j].count7 =(c[i][k].count7 + c[k][j].count7);
//						if(ed2[i][k] == 4) c[i][j].count4++;
//						if(ed2[i][k] == 7) c[i][j].count7++;
//						if(ed2[k][j] == 4) c[i][j].count4++;
//						if(ed2[k][j] == 7) c[i][j].count7++;
						//if(k==2 && i==1 && j==4) System.out.println("here--------"+c[i][j].count4);
					}
					
					
					ed[i][j] = Math.min(ed[i][j], ed[i][k]+ed[k][j]);
					
				}
				
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(c[i][j].count4+"\t");
//			}
//			System.out.println();
//		}
		
		boolean flag = false;
		
		for (int i = 0; i < ed.length; i++) {
			if(flag) break;
			for (int j = 0; j < ed.length; j++) {
				if(flag) break;
				if(ed[i][j] % 2 != 0 && ed[i][j] != 1){
					//System.out.println("here");
					//System.out.println((c[i][j].count4 - c[i][j].count7) );
					if((c[i][j].count4 - c[i][j].count7) == 1){
						res[0] = i;
						res[1] = j;
						res[2] = 7;
						flag = true;
					}else if((c[i][j].count4 - c[i][j].count7) == -1){
						res[0] = i;
						res[1] = j;
						res[2] = 4;
						flag = true;
					}
				}
			}
		}
		
		int[] empty={};
		if(res[0]==0 && res[1]==0 && res[2]==0) return empty;
		
		return res;
		
	}
}
