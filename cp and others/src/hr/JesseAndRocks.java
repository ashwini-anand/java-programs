package hr;

import java.util.Scanner;

public class JesseAndRocks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int js = s.nextInt();
		
		int counter =0;
		int count =0;
		for (int i = 0; i < n; i++) {
			int rs =s.nextInt();
			if(counter > 1) break;
			if(rs <= js) count++;
			else counter++;
		}
		System.out.println(count);
		
	}

}
