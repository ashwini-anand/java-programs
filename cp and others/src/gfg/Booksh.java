package gfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Booksh {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int count =0;
		while(true){
			int n = s.nextInt();
			if(n==-1) break;
			count++;
			int arr[] = new int[n];
			Arrays.fill(arr, -1);
			
			while(true){
				String st = s.next();
				if(st.charAt(0)=='E') {
					HashSet<Integer> hs = new HashSet<>();
					
					for (int i = 0; i < arr.length; i++) {
						hs.add(arr[i]);
					}
					System.out.print("PROBLEM "+count+":");
					for (int i = 0; i < hs.size(); i++) {
						if(-1!=-1)
						System.out.println(" "+hs);
					}
					break;
				}
				if(st.charAt(0)=='R'){
					for (int i = 0; i < arr.length; i++) {
						if(arr[i]==Integer.parseInt(st, st.charAt(2))){
							
						}
					}
				}
			}
		}

	}

}
