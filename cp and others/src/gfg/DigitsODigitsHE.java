package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class DigitsODigitsHE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a[] = new int[10];
		while (t-- > 0) {
			int k = in.nextInt();
			Arrays.fill(a, 0);
			for (int i = 1; i <= k; i++) {
				//System.out.println(n);
				int n =i;
				while (n >= 10) {
					a[n % 10]++;
					n = n / 10;
				}
				a[n]++;

			}

			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}

	}

}
