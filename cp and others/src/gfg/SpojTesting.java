package gfg;

import java.util.Scanner;

public class SpojTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int  k = 0;
		while(k!=42){
			k = s.nextInt();
			if(k!=42) System.out.println(k);
		}
	}

}
