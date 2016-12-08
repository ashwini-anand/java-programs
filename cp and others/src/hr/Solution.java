package hr;

import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		//s.nextLine();
		for (int l = 0; l < t; l++) 
			
		{
			//t--;
			int N = s.nextInt();
			//s.nextLine();
			int q = N/3;
			
			boolean flag = false;
			int n3=0, n5=0;
			q = q+1;
			while((--q)>=0)
				{
				 for (int i = 0; i < 33334; i++) {
					// System.out.println(q+" "+i);
				 if((3*q + 5*i) == N){
					flag = true;
					n5 = q;
					n3 = i;
					break;
				}
				 if(3*q + 5*i > N){
					 break;
				 }
			}
				 if(flag){
					 break;
				 }else{
					 //System.out.println("continue");
					 continue;
				 }
		}
			if(flag && n3>=0 &&n5>=0 ){
				for (int i = 0; i < n5; i++) {
					System.out.print(555);
				}
				for (int i = 0; i < n3; i++) {
					System.out.print(33333);
				}
			}else{
				System.out.print(-1);
			}
			System.out.println();
		}
	}

}
