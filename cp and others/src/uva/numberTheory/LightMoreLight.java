package uva.numberTheory;

import java.util.Scanner;

public class LightMoreLight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true){
			long n = in.nextLong();
			if(n==0){
				break;
			}
			long a = (long) Math.sqrt(n);
			if(a*a == n){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
		}

	}

}
