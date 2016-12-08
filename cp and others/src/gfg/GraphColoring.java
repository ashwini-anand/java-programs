package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GraphColoring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		
		while(m>0){
			m--;
			int n = s.nextInt();
			int k = s.nextInt();
			ArrayList<Integer>[] varr = (ArrayList<Integer>[]) new ArrayList[n+1]; //array of vertices to keep list 
			boolean[][] ematrix = new boolean[n+2][n+2];  // matrix to keep edge information
			
			for (int i = 1; i <=n ; i++) {
				ematrix[i][i] = true;
			}
			
			for (int i = 0; i < k; i++) {
				int e1 = s.nextInt();
				int e2 = s.nextInt();
				ematrix[e1][e2] = true;
				ematrix[e2][e1] = true;
			}
			
			for (int i = 1; i <= n; i++) {
				varr[i] = new ArrayList<Integer>();
				varr[i].add(i);
			}
			
			for (int i = 1; i <=n; i++) {
				for (int j =1; j < i; j++) {
					if(!ematrix[i][j]){
						//System.out.println(i+" "+j);
						ArrayList<Integer> al = new ArrayList<Integer>();
						//al.add(j);
						for (int l = 0; l < varr[j].size(); l++) {
							int kk = varr[j].get(l);
							if(!ematrix[i][kk]){
								//System.out.println("abc");
								al.add(kk);
							}
						}
						//System.out.println(al.toString());
						if(varr[i].size()-1 < al.size()){
							varr[i].clear();
							al.add(i);
							varr[i]= al;
							//System.out.println(varr[i].toString());
						}
					}
				}
			}
			int max = varr[1].size();
			int maxidx = 1;
			for (int i = 1; i <= n; i++) {
				//System.out.println(varr[i].size());
				if(varr[i].size() > max){
					max = varr[i].size();
					maxidx = i;
				}
			}
			
			//System.out.println(maxidx);
			System.out.println(max);
			Collections.sort(varr[maxidx]);
			for (int i = 0; i < varr[maxidx].size()-1; i++) {
				System.out.print(varr[maxidx].get(i)+" ");
			}
			System.out.println(varr[maxidx].get(varr[maxidx].size()-1));
		}

	}

}
