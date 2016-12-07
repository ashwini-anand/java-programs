package hackerrank;

import java.math.BigInteger;

public class BinaryCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 25;
		System.out.println(Integer.toString(x,2));
		BigInteger k = BigInteger.valueOf(x);
		//System.out.println(k.toString(2));
		String binx = Integer.toString(x,2);
		char[] res = binx.toCharArray();
		for(int i=0; i<binx.length(); i=i+2){
			res[i] = '1';
		}
		System.out.println(new String(res));
		System.out.println(x>>1);
		System.out.println(x);
		int a = 0xAA;
		int b = a | x;
//		System.out.println(Integer.toString(a,2));
//		System.out.println(Integer.toString(b,2));

	}

}
