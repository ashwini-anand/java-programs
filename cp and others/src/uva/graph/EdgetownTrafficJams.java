package uva.graph;


import java.util.*;

public class EdgetownTrafficJams {

	/**
	 * @param args
	 */
    static int max =99999;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        
        while(true){
            int n = in.nextInt();
            in.nextLine();
            if(n==0) break;
            int[][] matOld = new int[n][n];
            int[][] distOld = new int[n][n];
            int[][] distNew = new int[n][n];
            
            for(int i=0;i<n;i++){
                Arrays.fill(matOld[i],max);
                matOld[i][i] = 0;
            }
            for(int i=0;i<n;i++){
                String s1 = in.nextLine();
               // System.out.println(s1);
                String s1arr[] = s1.split("\\s+");
                int[] intarr = new int[s1arr.length];
                for(int j=0;j<s1arr.length;j++){
                	//System.out.println(s1arr.length);
                    intarr[j]= Integer.parseInt(s1arr[j].trim());
                }
                for(int j =1; j<intarr.length;j++){
                    matOld[i][intarr[j]-1] = 1;
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    distOld[i][j] = matOld[i][j];
                }
            }
            floydWarshall(distOld);
            
            for(int i=0;i<n;i++){
                String s1 = in.nextLine();
                String s1arr[] = s1.split(" ");
                int[] intarr = new int[s1arr.length];
                for(int j=0;j<s1arr.length;j++){
                    intarr[j]= Integer.parseInt(s1arr[j].trim());
                }
                for(int j =1; j<intarr.length;j++){
                    matOld[intarr[j]-1][i] = max;
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    distNew[i][j] = matOld[i][j];
                }
            }
            floydWarshall(distNew);
            
            int a = in.nextInt();
            int b = in.nextInt();
            boolean isPossible = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(distNew[i][j]>a*distOld[i][j]+b){
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            
        }

	}
    
    public static void floydWarshall(int[][] dist){
        int n = dist.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }

}

