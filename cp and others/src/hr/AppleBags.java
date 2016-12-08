package hr;

import java.util.Scanner;

public class AppleBags {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int sum =0;
		for (int i = 0; i < n; i++) {
			sum += s.nextInt();
		}
		
		boolean flag = false;
		while(!flag){
			if(sum %3 ==0) {
				flag =true;
				break;
			}
			sum = sum -1;
		}
		
		System.out.println(sum);
	}

}
