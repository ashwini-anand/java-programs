package hr;

import java.util.Scanner;

public class BinaryGift {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		String a=s.nextLine();
		String b= s.nextLine();
		if(a.length() != b.length()) System.out.println(-1);
		else{
			int counta = 0, countb =0,countd =0;
			for (int i = 0; i < b.length(); i++) {
				char aa = a.charAt(i);
				char bb = b.charAt(i);
				if(aa=='1'){
					counta++;
				}
				if(bb=='1'){
					countb++;
				}
				if(aa!=bb){
					countd++;
				}
			}
			if(counta == countb) System.out.println(countd/2);
			else System.out.println(-1);
		}

	}

}
