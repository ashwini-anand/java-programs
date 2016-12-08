package hr;

import java.util.*;

public class PresidentialGala {

	/**
	 * @param args
	 */
	static HashMap<String, Integer> dpmap = new HashMap<String, Integer>();
	static ArrayList<Integer>[] neigh;
	static int n;
	static int population[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		neigh = (ArrayList<Integer>[])new ArrayList[n];
		population = new int[n];
		for (int i = 0; i < n; i++) {
			population[i] = in.nextInt();
			neigh[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			neigh[a].add(b);
			neigh[b].add(a);
		}
		char[] carr = new char[n];
		Arrays.fill(carr,'0');
		int res = getCount(carr);
		//System.out.println(Arrays.toString(carr));
		System.out.println(res);

	}
	
	public static int getCount(char[] carr){
		
		String str = new String(carr);
		if(dpmap.get(str) != null){
			return dpmap.get(str);
		}
		
		int res =0;
		
		int node = -1;
		int count0 = 0;
		if(node == -1){
			for(int i=0; i< str.length(); i++){
				if(str.charAt(i)=='0'){
					node = i;
					count0++;
				}
			}
		}
		if(node ==-1 ){
			return  0;
		}
		int res1 = 0;
		
		carr[node] = '1';
		
		if(count0 == 1){
			carr[node] = '0';
			return population[node];
		}
		
		ArrayList<Integer> hset = neigh[node];
		for (Integer i : hset) {
			if(carr[i] != '1'){
				res1  = Math.max(res1, getCount(carr));
			}
		}
		
		int nxt=-1;
		ArrayList<Integer> al = new ArrayList<>();
		for (Integer i : hset) {
			if(carr[i] != '1'){
				al.add(i);
				carr[i] = '1';
			}
		}
		res = population[node] + getCount(carr);
		
		for (Integer i : al) {
			carr[i] = '0';
		}
		carr[node] = '0';
		
		res = Math.max(res, res1);
		
		dpmap.put(str, res);
		return res;
	}

}
