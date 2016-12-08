package tc;


public class Fragile2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] graph = {"NYNNNN", "YNYNNN", "NYNNNN", "NNNNYN", "NNNYNY", "NNNNYN"};
		System.out.println(countPairs(graph));

	}

	public static int countPairs(String[] graph){
		int n = graph.length;
		int[][] edges = new int[n][n];
		//boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				edges[i][j] = graph[i].charAt(j) == 'Y' ? 1:99999;
			}
		}
		
		int[][] tedges1 = new int[n][n];
		
		
		for (int p = 0; p < n; p++) {
			for (int q = 0; q < n; q++) {
				tedges1[p][q] = edges[p][q];
			}
		}
		
		for (int p = 0; p < n; p++) {
			for (int q = 0; q < n; q++) {
				for (int r = 0; r < n; r++) {
					tedges1[q][r] = Math.min(tedges1[q][r], tedges1[q][p]+tedges1[p][r]);
				}
			}
		}
		
		int cnum = 0;
		for (int p = 0; p < n; p++) {
			if(tedges1[0][p] == 99999) cnum++;
		}
		System.out.println(cnum);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(tedges1[i][j]+"	");
			}
			System.out.println();
		}
		System.out.println();
		
		
		int res = 0;
		int count = 0;
		int done = 0;
		
		
		
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				count =0;
				int[][] tedges = new int[n][n];
				
				
				for (int p = 0; p < n; p++) {
					for (int q = 0; q < n; q++) {
						tedges[p][q] = edges[p][q];
					}
				}
				
				
				for (int k = 0; k < n; k++) {
					tedges[i][k] = 99999;
					tedges[k][i] = 99999;
				}
				for (int k = 0; k < n; k++) {
					tedges[j][k] = 99999;
					tedges[k][j] = 99999;
				}
				
//				for (int i1 = 0; i1 < n; i1++) {
//					for (int j1 = 0; j1 < n; j1++) {
//						System.out.print(tedges[i1][j1]+"	");
//					}
//					System.out.println();
//				}
				
				for (int p = 0; p < n; p++) {
					for (int q = 0; q < n; q++) {
						for (int r = 0; r < n; r++) {
							tedges[q][r] = Math.min(tedges[q][r], tedges[q][p]+tedges[p][r]);
						}
					}
				}
				for (int i1 = 0; i1 < n; i1++) {
					for (int j1 = 0; j1 < n; j1++) {
						System.out.print(tedges[i1][j1]+"	");
					}
					System.out.println();
				}
				System.out.println();
				boolean flag = true;
				int k1=0;
				for ( k1 = 0; k1 < n; k1++) {
					if(k1!=i && k1!=j) break;
				}
				for (int p = 0; p < n; p++) {
					if(p!=i && p!=j && tedges[k1][p] == 99999) {
						count++;
					}
				}
				if(count > cnum) {
					System.out.println(count);
					res +=1;
				}
				
			}
		}
		
		return res;
		
	}
}
