package hr;

import java.util.Scanner;

public class PDStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		s.nextLine();
		while(t>0){
			t--;
			int count =0;
			String ss = s.nextLine();
			for (int i = 0; i < ss.length(); i++) {
				for (int j = i; j < ss.length(); j++) {
					String ss2 = ss.substring(i, j+1);
					if(palin(ss2)) count++;
				}
			}
			
			int n = ss.length();
			int numStr = (n*(n+1))/2;
			int gcdd = gcd(count,numStr);
			int count2=count/gcdd;
			int numStr2 = numStr/gcdd;
			System.out.println(count2+"/"+numStr2);
			
		}
	}
	
	public static boolean palin(String s){
		int count[]=new int[26];
		 
	    for (int i = 0; i< s.length();  i++)
	        count[((int)s.charAt(i))%26]++;
	 
	    int odd = 0;
	    for (int i = 0; i < 26; i++)
	        if ((count[i] & 1)!=0)
	            odd++;
	     
	    return (odd <= 1);
	}

	public static int gcd(int a, int b){
		return b==0 ? a : gcd(b, a%b); 
	}
}
