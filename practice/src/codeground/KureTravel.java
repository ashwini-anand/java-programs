package codeground;

import java.util.Scanner;

public class KureTravel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long ha = in.nextLong();
		long hb = in.nextLong();
		long hc = in.nextLong();
		long ac = in.nextLong();
		long ab = in.nextLong();
		long bc = in.nextLong();
		
		long res1 = 2*ha+2*hb;
		long res2 = ha+ab+hb;
		long res3 = 2*hc + 2*ha;
		long res4 = hc+ac+ha;
		long res5 = 2*hb+2*hc;
		long res6 = hb+bc+hc;
		long res7 = ha+ac+bc+hb;
		long res8 = hc+ac+ab+hb;
		long res9 = ha+ab+bc+hc;
		long res10 = 2*ha + 2*ac;
		long res11 = 2*hb + 2*bc;
		long res12 = 2*ha + 2*ab;
		long res13 = 2*hb + 2*ab;
		long res14 = 2*hc + 2*ac;
		long res15 = 2*hc + 2*bc;
		
		
		long res = Math.min(res1, res2);
		res = Math.min(res, res3);
		res = Math.min(res, res4);
		res = Math.min(res5, res);
		res = Math.min(res, res6);
		res = Math.min(res,res7);
		res = Math.min(res,res8);
		res = Math.min(res, res9);
		res = Math.min(res, res10);
		res = Math.min(res, res11);
		res = Math.min(res, res12);
		res = Math.min(res, res13);
		res = Math.min(res, res14);
		res = Math.min(res, res15);
		System.out.println(res);

	}

}
