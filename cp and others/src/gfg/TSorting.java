package gfg;

import java.util.Stack;

public class TSorting {

	/**
	 * @param args
	 */
	final static int inf = 9999;
	static int[][] graph={
		{inf,inf,inf,inf,inf,inf},
		{inf,inf,inf,inf,inf,inf},
		{inf,inf,inf,1,inf,inf},
		{inf,1,inf,inf,inf,inf},
		{1,1,inf,inf,inf,inf},
		{1,inf,1,inf,inf,inf}
	};
	static boolean visited[]=new boolean[6];
	static Stack<Integer> st = new Stack<Integer>();
	
	public static void main(String[] args) {

		tsort();
		
	}

	public static void tsort(){
		int count = 0;
		
		for (int i = 0; count < visited.length; i=(i+1)%visited.length) {
			count++;
			if(!visited[i]){
				//System.out.println("here1--");
				tsortutil(i);
			}
		}
		while(st.empty()==false){
			System.out.println(st.pop());
		}

		
	}
	
    public static void tsortutil(int i){
		visited[i] = true;
		//System.out.println(i+" ");
		
		for (int j = 0; j < visited.length; j++) {
			if(!visited[j] && graph[i][j]!=inf){
				tsortutil(j);
			}
		}
		st.push(i);
	}
}
