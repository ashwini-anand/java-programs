package tc;

public class ColorfulRoad {

	/**
	 * @param args
	 */
	final static int inf = 9999999;
	
	public static void main(String[] args) {
          String road = "RG";
          
          System.out.println(getMin(road));
		
	}
	
	public static 	int getMin(String road){
		
		int n = road.length();
		int graph[][] = new int[road.length()][road.length()];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j]= inf;
			}
		}
		
		for (int i = 0; i < road.length(); i++) {
			for (int j = i+1; j < road.length(); j++) {
				if(road.charAt(i)=='R' && road.charAt(j)=='G') graph[i][j] = (j-i)*(j-i);
				else if(road.charAt(i)=='G' && road.charAt(j)=='B') graph[i][j] = (j-i)*(j-i); 
				else if(road.charAt(i)=='B' && road.charAt(j)=='R') graph[i][j] = (j-i)*(j-i); 
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(graph[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = graph[i][j] > (graph[i][k] + graph[k][j]) ? graph[i][k] + graph[k][j] : graph[i][j];
				}
			}
		}
		
		if(graph[0][n-1] == inf) return -1;
		
		return graph[0][n-1];
		
	}

}
