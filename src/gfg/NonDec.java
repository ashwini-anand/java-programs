package gfg;

import java.util.Arrays;

public class NonDec{
    public static int dp[][];
    public static void main(String[] args){
        int n =3;
        //System.out.println("abc"); 
        dp = new int[10][n+1];
        for(int i=0; i<10; i++){
        	Arrays.fill(dp[i], -1);
        }
        System.out.println(getCount(0,n));
    }
    
    public static int getCount(int k, int n){
        if(n==0) return 1;
        if(dp[k][n] != -1) return dp[k][n];
        int res =0;
        for(int i=k;i<10;i++){
            res += getCount(i,n-1);
        }
        //System.out.println("abc"); 
        return res;
    }
    
}