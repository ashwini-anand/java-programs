package hr;

import java.util.Scanner;

public class DevuDiet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int c[] = new int[n];
		int b[] = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = in.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			b[i] = in.nextInt();
		}
		int count =0;
		for (int i = 0; i < n; i++) {
			int sum1=0,sum2=0;
			for (int j = i; j < n; j++) {
				sum1+=c[j];
				sum2+=b[j];
				if(sum1>=sum2){
					count++;
				}
//				else{
//					break;
//				}
			}
		}
		System.out.println(count);

	}

}
