package hr;

import java.util.Scanner;

class sq{
	int x;
	int y;
	
	sq(int i,int j){
		x=i;
		y=j;
	}
}

public class Squares {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int m = s.nextInt();
		int l = s.nextInt();
		
		sq[] sarr = new sq[n];
		
		for (int i = 0; i < sarr.length; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			
			sarr[i] = new sq(x,y);
		}
		
		int max =0;
		int count =0;
		for (int i = 0; i < m; i++) {
			count =0;
			int xx = s.nextInt();
			int yy = s.nextInt();
			 
			for (int j = 0; j < sarr.length; j++) {
				if(xx<=sarr[j].x+l && xx>=sarr[j].x && yy<=sarr[j].y+l && yy>=sarr[j].y ) count++;
				if(count + (sarr.length - j) <=max) break;
			}
			
			max = max < count ? count:max;
			
		}
		
		System.out.println(max);
		
		
	}

}
