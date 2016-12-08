package codechef;

import java.util.Scanner;

public class GIVCANDY {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-- >0){
			long a = in.nextLong();
			long b = in.nextLong();
			long c = in.nextLong();
			long d = in.nextLong();
			
			if(a==b || c!=d){
				System.out.println(0);
				continue;
			}
			
			long diff = Math.abs(a-b);
			// from here starts the case with c==d
			long res ;
			if(diff < c){
				res = Math.min(diff, c-diff);
			}else{
				
				long tmp1 = a%c;
				long tmp2 = b%c;
				
				long res1 = Math.abs(tmp1-tmp2);
				
				res = Math.min(res1, c-res1);
				
			}
			System.out.println(res);
			
		}
	}

}
