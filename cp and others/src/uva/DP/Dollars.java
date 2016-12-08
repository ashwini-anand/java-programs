package uva.DP;

import java.util.*;

public class Dollars {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int[] denom = {5,10,20,50,100,200,500,1000,2000,5000,10000};
       int row = denom.length;
        while(true){
            double amnt = in.nextDouble();
            if(amnt==0) break;
            amnt = amnt*100;
            int amount = (int) amnt;
            int col = amount+1;
            int[][] mat = new int[row][col];
            for(int i=0;i<row;i++){
                mat[i][0] = 1;
            }
            for(int i=1;i<col;i++){
                if(i%5==0){
                    mat[0][i] = 1;
                }
            }
            for(int i=1;i<row;i++){
                for(int j=1;j<col;j++){
                    if(j-denom[i] <0){
                        mat[i][j] = mat[i-1][j];
                    }else{
                        mat[i][j] = mat[i-1][j]+mat[i][j-denom[i]];
                    }
                }
            }
            System.out.println(mat[row-1][col-1]);
        }
       
    }
}
