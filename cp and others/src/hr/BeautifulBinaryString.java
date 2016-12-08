package hr;

import java.util.Scanner;

public class BeautifulBinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String str = "";
		str = in.nextLine();
		if(n==1 || n==2){
			System.out.println(0);
		}else{
			char[] charr = str.toCharArray();
			int count =0;
			
			for (int i = 2; i < str.length(); i++) {
				if(charr[i-2]=='0' && charr[i-1]=='1' && charr[i]=='0'){
					count++;
					charr[i] = '1';
				}
			}
			
			System.out.println(count);
			
		}
	}

}
