package codechef;

import java.util.Scanner;

public class NDIFFPAL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		//System.out.println((char)('a'+2));
		while(t-- >0){
			String repeat = "abcdefghijklmnopqrstuvwxyz";
			String res = "";
			int n = in.nextInt();
			int repNum = n/26;
			for (int i = 0; i < repNum; i++) {
				res += repeat;
			}
			
			int remainder = n%26;
			
			for (int i = 0; i < remainder; i++) {
				char c = (char) ('a'+i);
				res += String.valueOf(c);
			}
			
			System.out.println(res);
			
			
			
		}

	}

}
