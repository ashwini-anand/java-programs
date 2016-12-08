// Does not clear the time limit

package tc;

import java.util.*;

public class DivFreed2{
    
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(count(n,k));
    }
    
    //public static int[] arr;
    public static int dp[][];
    public static int size;
    public static int range;
    public static  int count(int n, int k){
        
        size = n;
        range = k;
        int[] arr = new int[n];
        dp = new int[n][k+1];
        
        
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int count =0;
        for(int i=1;i<= k;i++){
           arr[0] = i; 
           dp[0][i] = getCount(1,arr);
           count += dp[0][i]; 
        }
        
        return count;
    }
    
    public static int getCount(int l, int[] arr){
        
        if(l==size){
            return 1;
        }
        
        int count =0;
        for(int i=1;i<=range;i++){
            if(arr[l-1] <= i || arr[l-1]%i != 0){
                if(dp[l][i] != -1) {
                    count += dp[l][i];
                }else{
                    arr[l] = i;
                    dp[l][i] = getCount(l+1,arr);
                    count += dp[l][i];
                }    
            }
        }
        
        return count;
        
    }
    
    
    
}