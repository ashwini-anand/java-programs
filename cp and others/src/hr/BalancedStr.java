package hr;

import java.util.Scanner;

public class BalancedStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			t--;
			int n = in.nextInt();
			int fac = n/2;
			//if(fac%2!=0) fac++;
			int res =n;
			for (int i = fac; i >0; i=i/2) {
//				System.out.println(i);
				res = (res*n)%(1000000000+7);
			}
			if(fac%2!=0) res  = res*n;
			System.out.println(res);
		}
	}

}
