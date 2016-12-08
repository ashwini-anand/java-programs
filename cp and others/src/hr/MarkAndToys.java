package hr;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int amnt = s.nextInt();
		
		int toysarr[]= new int[n];
		
		for (int i = 0; i < toysarr.length; i++) {
			toysarr[i]= s.nextInt();
		}
		
		Arrays.sort(toysarr);
		
		int count =0;
		
		for (int i = 0; i < toysarr.length; i++) {
			amnt = amnt-toysarr[i];
			if(amnt >=0) count++;
			else break;
		}
		System.out.println(count);

	}

}
