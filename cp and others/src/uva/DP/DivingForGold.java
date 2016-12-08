package uva.DP;

import java.util.*;

public class DivingForGold{
    static int depth[];
    static int val[];
    static int weight[];
    static int dp[][];
    static boolean path[][];
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int test =0;
        while(in.hasNextInt()){
            int t = in.nextInt();
            int w = in.nextInt();
            int n = in.nextInt();
            if(n==0){
                if(test++ !=0){
                    System.out.println();
                }
                System.out.println(0);
                System.out.println(0);
                continue;
            }
            depth = new int[n];
            val = new int[n];
            weight = new int[n];
            dp = new int[n+1][t+1];
            path = new boolean[n+1][t+1];
            for(int i =0;i<n;i++){
                depth[i] = in.nextInt();
                val[i] = in.nextInt();
                weight[i] = 3*w*depth[i];
            }
            for(int i=0;i<=n;i++){
                for(int j=0;j<=t;j++){
                    if(i==0 || j==0){
                        dp[i][j]=0;
                    }else{
                        dp[i][j] = dp[i-1][j];
                        if(j>=weight[i-1] && val[i-1]+dp[i-1][j-weight[i-1]] > dp[i-1][j]){
                            dp[i][j] = val[i-1]+dp[i-1][j-weight[i-1]];
                            path[i][j] = true;
                        }
                    } 
                }
            }
            if(test++ !=0){
                System.out.println();
            }
            System.out.println(dp[n][t]);
            printPath(n,t,0);
        }
    }
    
    public static void printPath(int n, int t, int cnt){
        if(n<=0){
            System.out.println(cnt);
        }else if(path[n][t]){
            printPath(n-1,t-weight[n-1], cnt+1);
            System.out.println(depth[n-1]+" "+val[n-1]);
        }else{
            printPath(n-1,t,cnt);
        }
    }
}
