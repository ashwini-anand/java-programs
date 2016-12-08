package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class CodegrndNL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		
		Arrays.sort(arr);
		
		int count =1;
		int maxCount =count;
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]==arr[i-1]+1) count++;
			else{
				if(maxCount < count) maxCount = count;
				count =1;
			}
		}
		if(maxCount < count) maxCount = count;
		
		System.out.println(maxCount);

	}

}
