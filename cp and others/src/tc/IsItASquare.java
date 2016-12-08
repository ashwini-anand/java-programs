//Wrong program. Refer http://geeksquiz.com/check-given-four-points-form-square/   or other website

package tc;

public class IsItASquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String isSquare(int[] x, int[] y){
		
		int dist1 = findDistance(x[0], y[0], x[1], y[1]);
		int dist2 = findDistance(x[0], y[0], x[2], y[2]);
		int dist3 = findDistance(x[0], y[0], x[3], y[3]);
		
		if(dist1==dist2){
			if(dist3==dist1+dist2) return "It's a square";
		}else if(dist1==dist3){
			if(dist2==dist1+dist3) return "It's a square";
		}else if(dist2==dist3){
			if(dist1==dist2+dist3) return "It's a square";
		}
		
		return "Not a square";
		
	}
	
	public static int findDistance(int x1, int y1, int x2, int y2){
		int d2 = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
		return d2;
	}

}
