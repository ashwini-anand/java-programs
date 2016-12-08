package tc;

public class Egalitarianism {

	/**
	 * @param args
	 */
	final static int inf = 9999999;
	
	public static void main(String[] args) {
		String[] isFriend = {"NY",
		 "YN"};
		
		System.out.println(maxDifference(isFriend, 0));

	}
	
	public static int maxDifference(String[] isFriend, int d){
		
		int n = isFriend[0].length();
		int gr[][] = new int[n][n];
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				gr[i][j] = inf;
//			}
//		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(isFriend[i].charAt(j)=='Y') gr[i][j] = 1;
				else gr[i][j] = inf;
			}
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					gr[i][j] = gr[i][j] > (gr[i][k] + gr[k][j]) ? gr[i][k] + gr[k][j] : gr[i][j];
				}
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(gr[i][j] == inf) return -1;
			}
		}
		
		int max = -1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(gr[i][j]!=inf){
				  max = max < gr[i][j] ? gr[i][j] : max;
				}
			}
		}
		
		//System.out.println(max);
		
		return max == -1 ? -1 : max*d;
		
	}

}
