package tc;

public class PathGameDiv2 {

	static final int inf = 9999;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] board ={"....#.##.....#..........."
				,"..#......#.......#..#...."};
		
		System.out.println(calc(board));

	}
	
	public static int calc(String[] board){
		int n = board[0].length();
		int graph[][] = new int[2*n][2*n];
		
		for (int i = 0; i < 2*n; i++) {
			for (int j = 0; j < 2*n; j++) {
				graph[i][j]=inf;
			}
		}
		
		int l =0;
		
		for ( l = 0; l < board[0].length()-1; l++) {
			if(board[0].charAt(l) == '.' && board[0].charAt(l+1) == '.'){
				graph[l][l+1]=1;
				graph[l+1][l]=1;
			}
		}
		
		l++;
		for ( int i=0; i < board[1].length()-1; i++) {
			if(board[1].charAt(i) == '.' && board[1].charAt(i+1) == '.'){
				graph[l][l+1]=1;
				graph[l+1][l]=1;
				l++;
			}
		}
		
		for (int i = 0; i < board[0].length(); i++) {
			if(board[0].charAt(i) == '.' && board[1].charAt(i) == '.'){
				graph[i][i+n]=1;
				graph[i+n][i]=1;
			}
		}
		
//		for (int i = 0; i < 2*n; i++) {
//			for (int j = 0; j < 2*n; j++) {
//				System.out.printf("%6d",graph[i][j]);
//			}
//			System.out.println();
//		}
		
		for (int k = 0; k < 2*n; k++) {
			for (int i = 0; i < 2*n; i++){
				for (int j = 0; j < 2*n; j++){
					if(i==n && j==n-1) System.out.println(graph[i][j]+" "+graph[i][k]+graph[k][j]);
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
			
		}
		
//		System.out.println("\n");
//		for (int i = 0; i < 2*n; i++) {
//			for (int j = 0; j < 2*n; j++) {
//				System.out.printf("%6d",graph[i][j]);
//			}
//			System.out.println();
//		}
		
		int min =0;
		
		min = Math.min(graph[0][n-1], graph[0][2*n-1]);
	//	System.out.println(min);
		min = Math.min(min, graph[n][2*n-1]);
		System.out.println(min);
		min = Math.min(min, graph[n][n-1]);
	//	System.out.println(min);
		
		if(min ==inf) return 0;
		if(2*n==2) return 1;
		int count =0;
		for (int i = 0; i < board[0].length(); i++) {
			if(board[0].charAt(i) == '#') count++;
		}
		
		for (int i = 0; i < board[1].length(); i++) {
			if(board[1].charAt(i) == '#') count++;
		}
		
		//System.out.println(count);
		
		return (2*n-(min+1)-count);
		
	}

}
