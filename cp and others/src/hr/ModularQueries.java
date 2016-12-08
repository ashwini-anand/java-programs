package hr;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ModularQueries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String[] arr = new String[n+1];
		arr[0]=null;
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = s.next();
		}
//		for (int i = 1; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		int q=s.nextInt();
		
		while(q>0){
			q--;
			int indi = s.nextInt();
			if(indi==1){
				int k = s.nextInt();
				arr[k] = s.next();
			}else{
				int k = s.nextInt();
				String ss = "";
				int k2 = s.nextInt();
				
				for (int i = k; i <= k2; i++) {
					ss += arr[i];
				}
				
				BigInteger res = new BigInteger(ss);
				int rr = 1000000007;
				BigInteger res1 = res.mod(BigInteger.valueOf(rr));
//				DecimalFormat df = new DecimalFormat("###.#");
//				System.out.println(df.format(res));
				System.out.println(res1);
			}
		}
				
	}

}
