package gfg;

import java.util.Scanner;

public class AvoidingOverlaps2 {

	/**
	 * @param args
	 */
	static boolean matrix[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		int t = 1;
		while(t<=tc){
			int n = s.nextInt();
			matrix = new boolean[201][201];
			int area = 0;
			while(n>0){
				n--;
				int x1 = s.nextInt()+100;
				int y1 = s.nextInt()+100;
				int x2 = s.nextInt()+100;
				int y2 = s.nextInt()+100;
				
				if(!isOverlaping(x1, y1, x2, y2)){
					area+= (x2-x1)*(y2-y1);
				}
			}
			System.out.println("Case "+t+": "+area);
			t++;
		}

	}
	
	static boolean isOverlaping(int x1, int y1,int x2,int y2){
		
		for (int i = x1+1; i <=x2; i++) {
			for (int j = y1+1; j <=y2; j++) {
				if(matrix[i][j]) return true;
			}
		}
		for (int i = x1+1; i <=x2; i++) {
			for (int j = y1+1; j <=y2; j++) {
				matrix[i][j]= true;
			}
		}
		
		return false;
		
	}

}
