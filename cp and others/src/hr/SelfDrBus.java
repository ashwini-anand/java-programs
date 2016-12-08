package hr;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SelfDrBus {

	/**
	 * @param args
	 */
	public static boolean isPath(int vert){
		ll.push(vert);
		for (int i = 0; i < nodes[vert].size(); i++) {
			ll.push(nodes[vert].get(i));
			if(alist.contains(nodes[vert].get(i)) && alist.containsAll(ll)){
				return isPath(nodes[vert].get(i));
			}else{
				return false;
			}
		}
		return true;
		
	}
	
	static ArrayList<Integer>[] nodes;
	static Stack<Integer> ll = new Stack<>();
	static ArrayList<Integer> alist;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		nodes = (ArrayList<Integer>[]) new ArrayList[n];
		
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < nodes.length-1; i++) {
			int c1 = s.nextInt()-1;
			int c2 = s.nextInt()-1;
			nodes[c1].add(c2);
			nodes[c2].add(c1);
		}
		
		int count =0;
		alist = new ArrayList<>();
		for (int i = 0; i < (1<<n); i++) {
			alist.clear();
			for (int j = 0; j < n; j++) {
				if((i & (1<<j))!=0){
					alist.add(i);
				}
			}
			ll.clear();
			if(alist.size()==1 || (alist.size()>=1 && isPath(alist.get(0)))){
				count++;
			}
		}
		System.out.println(count);
	}

}
