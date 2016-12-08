package hr;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

	/**
	 * @param args
	 */
	
	static public int calculate1(char []str){
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();	
		while(t>0){
			t--;
			String s1 = s.next();
			String s2 = s.next();
			int r1 = calculate1(s1.toCharArray());
			int r2 = calculate1(s2.toCharArray());
			if(r1%2!=0 && r2%2!=0){
				System.out.println(r1+r2-1);
			}else{
				System.out.println(r1+r2);
			}
		}

	}

}
