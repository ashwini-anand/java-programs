package hr;

import java.util.Arrays;
import java.util.Scanner;

public class TeamFormation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a=new int[10];
		
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		
		Arrays.sort(a);
		
		System.out.println(a[9]+a[7]+a[5]);
	}

}
