package hr;

import java.util.Scanner;

public class EmmasNotebook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		long count = 1;
		int k =2;
		if(t%2==1){
			for(int i =2; i<=t; i=i+2){
				count += 2*k;
				k++;
			}
		}else{
			for(int i =2; i<t; i=i+2){
				count += 2*k;
				k++;
			}
			count += k;
		}
		
		System.out.println(count);
	}

}
