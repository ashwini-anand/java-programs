package hr;

import java.util.ArrayList;
import java.util.Scanner;

public class ShortenPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
//		ArrayList<Integer> n =new ArrayList<>();
//		ArrayList<Integer> s =new ArrayList<>();
//		ArrayList<Integer> e =new ArrayList<>();
//		ArrayList<Integer> w =new ArrayList<>();
		//System.out.println(n[0]);
		
		int ncount=0;
		int scount=0;
		int ecount=0;
		int wcount=0;
		
		String str = in.next();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='N'){
				if(scount==0) ncount++;
				else scount--;
			}else if(str.charAt(i)=='S'){
				if(ncount==0) scount++;
				else ncount--;
			}else if(str.charAt(i)=='E'){
				if(wcount==0) ecount++;
				else wcount--;
			}else{
				if(ecount==0) wcount++;
				else ecount--;
			}
		}
		
		for (int i = 1; i <=ecount; i++) {
			System.out.print("E");
		}
		for (int i = 1; i <=ncount; i++) {
			System.out.print("N");
		}
		for (int i = 1; i <=scount; i++) {
			System.out.print("S");
		}
		for (int i = 1; i <=wcount; i++) {
			System.out.print("W");
		}
	}

}
