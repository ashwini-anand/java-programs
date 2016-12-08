package gfg;

public class KMP {

	/**
	 * @param args
	 */
	public static String text;
	public static String pattern;
	public static int[] lps;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		text = "aaaaaaaaa";
		pattern = "aaaaaa";
		KMPSearch();

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
	
	public static void KMPSearch(){
		int m = pattern.length();
		int n = text.length();
		lps = new int[m];
		int j=0,i=0;
		
		computeLps();
		
		while(i<n){
			if(pattern.charAt(j)==text.charAt(i)){
				i++;
				j++;
			}
			if(j==m){
				System.out.println("Found pattern at index "+(i-j)); // better store result (i.e i-j) in an ArrayList
				j=lps[j-1];
			}
			else if(i<n && pattern.charAt(j) != text.charAt(i)){
				if(j!=0){
					j=lps[j-1];
				}else{
					i = i+1;
				}
			}
		}
	}

}
