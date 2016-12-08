package hr;

import java.util.Scanner;

public class MarsExpo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		String ss = s.next();
		int count =0;
		for (int i = 0; i < ss.length(); i=i+3) {
			if(ss.charAt(i)!='S') count++;
			if(ss.charAt(i+1)!='O') count++;
			if(ss.charAt(i+2)!='S') count++;
		}
		System.out.println(count);
	}

}
