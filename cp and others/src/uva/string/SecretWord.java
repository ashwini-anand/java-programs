package uva.string;

import java.util.Scanner;

public class SecretWord {

	/**
	 * @param args
	 */
	public static String pattern;
	public static int[] lps;
	static int max;
	static int resIdx;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- >0){
			String s1 = in.next();
			String rev = new StringBuilder(s1).reverse().toString();
			pattern = s1+"A"+rev;
			lps = new int[pattern.length()];
			max = resIdx = 0;
			computeLps();
			
			System.out.println(new StringBuilder(pattern.substring(resIdx-max+1, resIdx+1)).reverse());
		}

	}
	
	public static void computeLps(){
		int len =0;
		int i = 1;
		int m = pattern.length();
		lps[0] = 0;
		
		while(i<m){
			if(pattern.charAt(i)==pattern.charAt(len)){
				len++;
				lps[i] = len;
				if(i> pattern.length()/2 && len >max){
					max = len;
					resIdx = i;
				}
				i++;
			}else{
				if(len !=0){
					len = lps[len-1];
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
	}

}
