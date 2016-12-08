package tc;

import java.util.Arrays;

public class Undiv2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//long[] arr = new long[100000000];
		for (int i = 1; i <= 100000000; i++) {
			int count =0;
			long k=0;
			while(count !=2){
				k++;
				if(i%k !=0){
					count++;
				}
				
			}
			System.out.print(k+" ");
		}
		//Arrays.toString(arr);
	}

}
