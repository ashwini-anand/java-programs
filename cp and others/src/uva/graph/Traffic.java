//Works for all input present in Udebug but not accepted by uva. Seems to be some problem with uva input for this problem ( mentioned in uva oj board).

package uva.graph;

import java.util.*;

public class Traffic {

	/**
	 * @param args
	 */
    static class Edge implements Comparable <Edge>{
        int src;
        int dest;
        int wt;
        
        public int compareTo(Edge e){
            return this.wt - e.wt;
        }
    }
    
    static Edge edges[];
    static int dist[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner  in = new Scanner(System.in);
        int k =1;
        while(in.hasNextInt()){
            int n = in.nextInt();
            int [] b = new int[n]; // array b[] stores busyness
            dist = new int[n];
            for(int i=0;i<n;i++){
                b[i] = in.nextInt();
            }
            
            int r = in.nextInt();
            edges = new Edge[r];
            for(int i=0;i<r;i++){
                int src = in.nextInt() -1;
                int dest = in.nextInt() -1;
                int wt = (b[dest] - b[src])*(b[dest] - b[src])*(b[dest] - b[src]);
                edges[i] = new Edge();
                edges[i].src = src;
                edges[i].dest = dest;
                edges[i].wt = wt;
                
            }
            int q = in.nextInt();
            if(n==0) {
            	System.out.println("Set #"+k++);
            	continue;
            }
            
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[0] =0;
            bellmannFord();
            System.out.println("Set #"+k++);
            for(int i =0; i<q;i++){
                int jn = in.nextInt()-1;
                if(dist[jn]<3 || dist[jn] == Integer.MAX_VALUE){
                    System.out.println("?");
                }else{
                    System.out.println(dist[jn]);
                }
            }
        }
        in.close();

	}
    
    public static void bellmannFord(){
        int n = dist.length;
        int m = edges.length;
        for(int i=0;i<n-1;i++){
            for(int j =0;j<m;j++){
                int u = edges[j].src;
                int v = edges[j].dest;
                int wt = edges[j].wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        for(int j =0;j<m;j++){
                int u = edges[j].src;
                int v = edges[j].dest;
                int wt = edges[j].wt;
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){
                    dist[v] = Integer.MIN_VALUE;
                }
        }
    }

}
