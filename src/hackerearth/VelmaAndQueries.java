package hackerearth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class VelmaAndQueries {

	/**
	 * @param args
	 */
	static class Node{
		HashSet<Integer> hset = new HashSet<Integer>();
		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
		int idx;
		int val;
		int level;
		ArrayList<Integer> neighs = new ArrayList<Integer>();
		
		Node(int i, int v){
			idx =i;
			val =v;
		}
	}
	static Node[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		while(t-- >0){
			int n = in.nextInt();
			int q = in.nextInt();
			arr = new Node[n];
			
			for(int i=0; i<n; i++){
				arr[i] = new Node(i,in.nextInt());
				arr[i].hset.add(i);
			}
			
			for (int i = 0; i < n-1; i++) {
				int u = in.nextInt()-1;
				int v = in.nextInt() -1;
				arr[u].neighs.add(v);
				arr[v].neighs.add(u);
			}
			arr[0].level = 1;
			ArrayList<Integer> al0 = new ArrayList<Integer>();
			al0.add(0);
			arr[0].hmap.put(1, al0);
			for(int i=0; i<arr[0].neighs.size();i++){
				int index = arr[0].neighs.get(i);
				dfs(index,0,1+1);
				for(Integer k : arr[index].hset){
					int ll = arr[k].level;
					if(arr[0].hmap.containsKey(ll)){
						ArrayList<Integer> al = arr[0].hmap.get(ll);
						al.add(k);
					}else{
						ArrayList<Integer> al = new ArrayList<Integer>();
						al.add(k);
						arr[0].hmap.put(ll, al);
					}
				}
			}
			
			//printArray();
			for(int i=0; i<q; i++){
				int ii = in.nextInt()-1;
				int l = in.nextInt();
				int res =0;
				if(!arr[ii].hmap.containsKey(l)){
					System.out.println(0);
				}else{
					ArrayList<Integer> relist = arr[ii].hmap.get(l);
					for(Integer id: relist){
						res += arr[id].val;
					}
					System.out.println(res);
				}
			}
			
		}

	}
	private static void printArray() {
		
		for(int i=0; i< arr.length; i++){
			System.out.println(i);
			for(Integer key : arr[i].hmap.keySet()){
				ArrayList<Integer> alist = arr[i].hmap.get(key);
				for(Integer idx : alist){
					System.out.println(key+"-->"+idx);
				}
			}
		}
		
	}
	private static void dfs(int index, int parentidx, int level) {
		// TODO Auto-generated method stub
		Node curr = arr[index];
		curr.level = level;
		ArrayList<Integer> alcurr = new ArrayList<Integer>();
		alcurr.add(index);
		curr.hmap.put(level, alcurr);
		for(int i=0; i< curr.neighs.size(); i++){
			int next = curr.neighs.get(i);
			if(next != parentidx){
				dfs(next,index,level+1);
				for(Integer k : arr[next].hset){
					curr.hset.add(k);
					int ll = arr[k].level;
					if(curr.hmap.containsKey(ll)){
						ArrayList<Integer> al = curr.hmap.get(ll);
						al.add(k);
						curr.hmap.put(ll, al);
					}else{
						ArrayList<Integer> al = new ArrayList<Integer>();
						al.add(k);
						curr.hmap.put(ll, al);
					}
				}
			}
		}
		
	}

}
