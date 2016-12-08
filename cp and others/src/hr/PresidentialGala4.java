package hr;

import java.util.*;

public class PresidentialGala4 {

	/**
	 * @param args
	 */
	static HashMap<String, Integer> dpmap = new HashMap<String, Integer>();
	//static HashMap<ArrayList<Integer>, Integer> dpp = new HashMap<>();
	static ArrayList<Integer>[] neigh;
	static int n;
	static int population[];
	static ArrayList<Integer> global;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int m = in.nextInt();
		neigh = (ArrayList<Integer>[])new ArrayList[n];
		population = new int[n];
		global = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			population[i] = in.nextInt();
			neigh[i] = new ArrayList<>();
			global.add(i);
		}
		for (int i = 0; i < m; i++) {
			int a = in.nextInt()-1;
			int b = in.nextInt()-1;
			neigh[a].add(b);
			neigh[b].add(a);
		}
		char[] carr = new char[n];
		Arrays.fill(carr,'0');
		int res =0;
		for (int i = 0; i < carr.length; i++) {
			char[] carr1 = new char[carr.length];
			System.arraycopy(carr, 0, carr1, 0, carr.length);
			carr1[i] = '1';
			int res1 = getCount(carr1);
			//al1.removeAll(neigh[0]);
			for (Integer idx : neigh[i]) {
				carr1[idx] = '1';
			}
			int res2 = population[i] + getCount(carr1);
			res2 = Math.max(res1, res2);
			res = Math.max(res, res2);
		}
		
		System.out.println(res);

	}
	
	public static int getCount(char[] carr){
		String str = new String(carr);
		int idx = str.indexOf('0');
		if(idx == -1){
			return 0;
		}
		if(dpmap.get(str) != null){
			return dpmap.get(str);
		}
		int res =0;
		for (int i = 0; i < carr.length; i++) {
			if(carr[i] != '1'){
				char[] carr1 = new char[carr.length];
				System.arraycopy(carr, 0, carr1, 0, carr.length);
				
				//System.out.println(Arrays.toString(carr));
				carr1[i] = '1';
				int res1 = getCount(carr1);
				for (Integer iii : neigh[i]) {
					carr1[iii] = '1';
				}
				int res2 = population[i]  + getCount(carr1);
				res2 = Math.max(res1, res2);
				res = Math.max(res, res2);
			}
			
		}
		
		dpmap.put(str,res);
		return res;
	}

}
