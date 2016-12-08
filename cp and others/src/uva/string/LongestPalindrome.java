package uva.string;

import java.util.*;

public class LongestPalindrome {

    public static String str;
    public static int[][] mat;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        while(t-- >0){
            str = in.nextLine();
            if(str == null || str.isEmpty()){
                System.out.println(0);
                continue;
            }
            mat = new int[str.length()][str.length()];
            for(int i=0;i<str.length();i++){
                Arrays.fill(mat[i],-1);
            }
            System.out.println(longestPalin(0,str.length()-1));
        }
    }
	
    public static int longestPalin(int l, int m){
        if(l+1 == m){
            if(str.charAt(l)==str.charAt(m)) return 2;
        }
        if(l==m) return 1;
        //if(mat[l][m] != -1) return mat[l][m];
        
        if(str.charAt(l) == str.charAt(m)){
            if(mat[l+1][m-1] == -1){
                mat[l][m] = 2+ longestPalin(l+1,m-1);
            }else{
                mat[l][m]  = 2 + mat[l+1][m-1];
            }
            return mat[l][m];
        }
        
        int x = mat[l][m-1] == -1 ? longestPalin(l,m-1) : mat[l][m-1];
        int y = mat[l+1][m] == -1 ? longestPalin(l+1,m): mat[l+1][m];
        
        mat[l][m] = Math.max(x,y);
        return mat[l][m];
    }

}
