package gfg;  //uva

import java.util.Arrays;
import java.util.Scanner;

public class ShoeMakerProblem {

	/**
	 * @param args
	 */
	
	static class Jobs implements Comparable<Jobs>{
		double ratio; // ratio fine/days
		int index;
		
		public Jobs(double f, double d, int i){
			ratio = f/d;
			index = i;
		}

		@Override
		public int compareTo(Jobs o) {

			if(this.ratio > o.ratio){
				return -1;
			}else if(this.ratio < o.ratio){
				return 1;
			}else{
				if(this.index > o.index){
					return 1;
				}else{
					return -1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			t--;
			int n = s.nextInt();
			Jobs jarr[] = new Jobs[n];
			
			for (int i = 0; i < jarr.length; i++) {
				double d = s.nextDouble();
				double f = s.nextDouble();
				
				Jobs j = new Jobs(f, d, i);
				jarr[i] = j;
				
			}
			
			Arrays.sort(jarr);
			for (int i = 0; i < jarr.length-1; i++) {
				System.out.print((jarr[i].index+1)+" ");
			}
			System.out.print(jarr[jarr.length-1].index+1);
			System.out.println();
			
			if(t>0){
				System.out.println();
			}
		}

	}

}
