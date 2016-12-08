package codechef;

import java.util.Scanner;

public class P1Z2S {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			int k = in.nextInt();
			if (k == 1)
				flag = true;
			sum += k;
		}
		int x =0;
		if (sum % 2 == 0) {
			 x =sum/2;
		} else {
			x=(sum + 1) / 2;
		}
		System.out.println(Math.max(n, x));
//		if (flag) {
//			int count = 1;
//			sum = sum - n;
//
//			while (sum > 0) {
//				count++;
//				sum = sum - 2 * n;
//			}
//			if (sum < 0) {
//				System.out.println((count * n) + sum);
//			} else {
//				System.out.println(count * n);
//			}
//		} else {
//			if (sum % 2 == 0) {
//				System.out.println(sum / 2);
//			} else {
//				System.out.println((sum + 1) / 2);
//			}
//		}

//		if (sum % 2 == 0) {
//			System.out.println(sum / 2);
//		} else {
//			System.out.println((sum + 1) / 2);
//		}
	}

}
