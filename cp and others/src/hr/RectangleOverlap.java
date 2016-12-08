package hr;

import java.util.Scanner;

public class RectangleOverlap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int x1= s.nextInt();
		int y1 = s.nextInt();
		int x2 = s.nextInt();
		int y2 = s.nextInt();
		
		int x3 = s.nextInt();
		int y3 = s.nextInt();
		int x4 = s.nextInt();
		int y4 = s.nextInt();
		
		//System.out.println("abcs");
		if((x3>=x1 && x3 <= x2)&&(y3>=y2 && y3 <= y1)) System.out.println("overlap");
		else if((x4>=x1 && x4 <= x2)&&(y4>=y2 && y4 <= y1)) System.out.println("overlap");
		else{
			System.out.println("no overlap");
		}

	}

}
