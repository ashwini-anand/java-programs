package tc;

public class PrivateD2party {
//	public static void main(String[] args) {
//        int[] a = {0,1};
//		System.out.println(getsz(a));
//	}
	public static int getsz(int[] a){
		int n = a.length;
		boolean visited[][] = new boolean[n][n];
		int[][] b = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] = 999;
				visited[i][j] = false;
				//System.out.println(b[i][j]);
			}
		}
		for (int i = 0; i < a.length; i++) {
			b[i][a[i]] = 1;
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.println(b[i][j]);
//			}
//		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(b[j][j2] > b[j][i]+b[i][j2]) 
						b[j][j2] = b[j][i]+b[i][j2];
				}
			}
		}
		
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.println(b[i][j]);
//			}
//		}
		
		int res = n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
		//		System.out.print(b[i][j]+" ");
				if(visited[i][j] == false &&  visited[j][i] == false && b[i][j] != 999 && b[j][i] != 999 && i!=j){
					visited[i][j] = true;
					visited[j][i] = true;
					res = res-1;
				}
			}
		//	System.out.println();
		}
		
		return res;
		
	}

}
