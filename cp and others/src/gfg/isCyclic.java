package gfg;

import java.util.LinkedList;
import java.util.Scanner;

public class isCyclic {

	/**
	 * @param args
	 */
	final static int inf = 9999;
	static int[][] graph={
		{inf,1,1,inf},
		{inf,inf,1,inf},
		{inf,inf,inf,1},
		{inf,inf,inf,inf}
	};
	static boolean visited[]=new boolean[4];
	static boolean recstack[]=new boolean[4];
	
	public static void main(String[] args) {

		if(isCyclic()) System.out.println("Graph has cycle");
		else System.out.println("Graph has no cycle");
		
	}

	public static boolean isCyclic(){
		int count = 0;
		for (int i = 0; count < visited.length; i=(i+1)%visited.length) {
			count++;
			if(!visited[i] && isCyclicutil(i)){
				//System.out.println("here1--");
				return true;
			}
		}
		return false;
	}
	
    public static boolean isCyclicutil(int i){
		visited[i] = true;
		recstack[i] = true;
		//System.out.println(i+" ");
		
		for (int j = 0; j < visited.length; j++) {
			if(!visited[j] && graph[i][j]!=inf && isCyclicutil(j)){
			//	System.out.println("here2--");
				return true;
			}else if(recstack[j] && graph[i][j]!=inf){
				//System.out.println(i+" "+j+"here3--");
				return true;
			}
		}
		recstack[i]=false;
		return false;
	}
}
