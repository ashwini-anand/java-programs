package tc;


public class PointDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] findPoint(int x1, int y1, int x2, int y2){
		int arr[] = new int[2];
		for (int i = -100; i <=100; i++) {
			for (int j = -100; j <=100; j++) {
				if(!(i==x1 && j==y1) && !(i==x2 && j==y2)){
					if(findDistance(x1, y1, i, j) > findDistance(x2, y2, i, j)){
						arr[0] = i;
						arr[1] = j;
						break;
					}
				}
			}
		}
		
		return arr;
		
	}
	
	public static double findDistance(int x1, int y1, int x2, int y2){
		int d2 = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
		return Math.sqrt(d2);
	}

}
