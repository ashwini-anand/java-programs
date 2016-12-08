package tc;


import java.util.*;

public class DoubleWeights {
	public static int mat1[][];
	public static int mat2[][];
	public static int max = 999999;

    
    public static void main(String[] args){
        String[] weight1 = {"..14", "..14", "11..", "44.."};
        String[] weight2 = {"..94", "..94", "99..", "44.."};
        System.out.println(minimalCost(weight1, weight2));
    }
	public static int minimalCost(String[] weight1, String[] weight2) {
		int n = weight1.length;
		mat1 = new int[n][n];
		mat2 = new int[n][n];

		for (int i = 0; i < n; i++) {
			char[] carr = weight1[i].toCharArray();
			for (int j = 0; j < n; j++) {
				if (carr[j] == '.') {
					mat1[i][j] = max;
				} else {
					mat1[i][j] = (int) (carr[j] - '0');
				}

			}
		}
        
        for (int i = 0; i < n; i++) {
			char[] carr = weight2[i].toCharArray();
			//System.out.println(Arrays.toString(carr));
			for (int j = 0; j < n; j++) {
				if (carr[j] == '.') {
					mat2[i][j] = max;
				} else {
					mat2[i][j] = (int) (carr[j] - '0');
				}

			}
		}
        
//        for (int i = 0; i < weight2.length; i++) {
//			for (int j = 0; j < weight2.length; j++) {
//				System.out.print(mat2[i][j]+" ");
//			}
//			System.out.println();
//		}
        
        int w1 = fw(mat1);
        if(w1 >= max){
            return -1;
        }
        int w2 = fw(mat2);
        System.out.println(w1+" "+w2);
		return w1*w2;

	}
    
    public static int fw(int graph[][]){
        
        int n = mat1.length;
        
        int dp[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = graph[i][j];
                
            }
            
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    
                    if(dp[i][j] > dp[i][k] + dp[k][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                    
                }
            }
        }
        
        return dp[0][1];
        
        
        
    }

}
