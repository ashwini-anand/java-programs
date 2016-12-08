package hr;

import java.util.Scanner;

public class TwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println(-1%5);
		int n = s.nextInt();
		int q = s.nextInt();
		
		long[] a=new long[n+1];
		long[] b = new long[n+1];
		
		int t =q;
		while(t>0){
			t--;
			int op = s.nextInt();
			if(op==1){
				int l = s.nextInt();
				int r = s.nextInt();
				int c = s.nextInt();
				
				for (int i = l; i <=r; i++) {
					a[i] = (a[i]+c)%1000000007;
				}
			}
			else if(op==2){
				int l = s.nextInt();
				int r = s.nextInt();
				int c = s.nextInt();
				
				for (int i = l; i <=r; i++) {
					b[i] = (b[i]+c)%1000000007;
				}
			}else{
				int l = s.nextInt();
				int r = s.nextInt();
				
				long sum = 0;
				
				for (int i = l; i <= r; i++) {
					long x=a[i];
					long y = b[i];
					sum=(sum+(x*y)%1000000007)%1000000007;
				}
				//System.out.println(-1000000008%1000000007);
				System.out.println(sum);
			}
		}
	}

}
