package hr;

import java.util.Scanner;

public class ShashankNim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			t--;
			int n= s.nextInt();
			long[] arr=new long[n];
			long res = s.nextLong();
			for (int i = 1; i < arr.length; i++) {
				res = res ^ s.nextLong();
			}
			if(res !=0){
			System.out.println(res);
			}else{
				System.out.println("-1");
			}
		}
	}

}
