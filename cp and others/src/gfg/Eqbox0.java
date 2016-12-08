package gfg;

import java.awt.Rectangle;
import java.util.Scanner;

public class Eqbox0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while(t>0){
			t--;
			Rectangle tiles  = new Rectangle(s.nextInt(), s.nextInt());	
			Rectangle box = new Rectangle(s.nextInt(), s.nextInt());
			if(tiles.contains(box)){
				System.out.println("Escape is possible.");
			}else{
				System.out.println("Box cannot be dropped.");
			}
		}

	}

}
