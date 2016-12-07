package interviewbit;
import java.util.*;

public class KnightOnChess {


    static int n;
    static int m;
    static int dx;
    static int dy;
    static int maxInt = 999999;
    static int[] c = {-2,-1,1,2,2,1,-1,-2};
    static int[] r = {-1,-2,-2,-1,1,2,2,1};
    static boolean vis[][];
    static int minval;
    static Node stab;
    static class Node{
        int x;
        int y;
        Node(int a, int b){
            x = a;
            y = b;
        }
    }
    
	public static int knight(int N, int M, int x1, int y1, int x2, int y2) {
	    n = N;
	    m = M;
	    vis = new boolean[N+1][M+1];
	    LinkedList<Node> q = new LinkedList<Node>();
	    stab = new Node(-1,-1);
	    q.addFirst(new Node(x1,y1));
	    vis[x1][y1] = true;
	    q.addFirst(stab);
	    int steps =0;
	    boolean flag = false;
	    while(!q.isEmpty()){
	        Node nd = q.removeLast();
	        if(nd.x == -1){
	            if(!q.isEmpty()){
	                q.addFirst(stab);
	                steps++;
	            }else{
	                break;
	            }
	        }
	        for(int k=0; k<8; k++){
	            System.out.println((nd.x+r[k])+" "+(nd.y+c[k])+" "+(steps+1));
	            if(nd.y+c[k] == y2 && nd.x+r[k] == x2){
	                flag = true;
	                break;
	            }
	            System.out.println(isValid(nd.x+r[k],nd.y+c[k]));
    	        if(isValid(nd.x+r[k],nd.y+c[k]) && !vis[nd.x+r[k]][nd.y+c[k]]){
    	        	//System.out.println("AA");
    	        	vis[nd.x+r[k]][nd.y+c[k]] = true;
    	            q.addFirst(new Node(nd.x+r[k],nd.y+c[k]));
    	        }
	        }
	        if(flag){
	            break;
	        }
	        
	    }
	    
	    if(!q.isEmpty()){
	        return steps+1;
	    }else{
	        return -1;
	    }
	    
	}
	static boolean isValid(int i, int j){
	    
	    if(i <= 0 || i >n || j <= 0 || j >m){
	        return false;
	    }
	    return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(knight(4, 7, 2, 6, 2, 4));
		System.out.println(knight(8, 8, 1, 1, 8, 8));

	}

}
