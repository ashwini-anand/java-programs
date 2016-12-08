package hr;

import java.math.BigInteger;
import java.util.Scanner;

public class FillingJars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr= new int[n];
		int ops = s.nextInt();
		BigInteger sum = BigInteger.valueOf(0);
		BigInteger avg = BigInteger.valueOf(0);
		for (int i = 0; i < ops; i++) {
			int start = s.nextInt();
			int end = s.nextInt();
			int k = s.nextInt();
			//sum+= (end-start +1)*k;
			sum = sum.add(BigInteger.valueOf((end-start +1)).multiply(BigInteger.valueOf(k)));
			
		}
		
		avg = sum.divide(BigInteger.valueOf(n));
		
		System.out.println(avg);
	}

}
