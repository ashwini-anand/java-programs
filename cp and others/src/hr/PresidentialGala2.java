package hr;

import java.util.*;

public class PresidentialGala2 {

	/**
	 * @param args
	 */
	static HashMap<String, Integer> dpmap = new HashMap<String, Integer>();
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
		ArrayList<Integer> al1 = new ArrayList<>(global);
		al1.remove(0);
		int res1 = getCount(al1);
		al1.removeAll(neigh[0]);
		int res2 = population[0] + getCount(al1);
		int res = Math.max(res1, res2);
		//System.out.println(Arrays.toString(carr));
//		for (Integer integer : global) {
//			System.out.println(global.get(integer));
//		}
		
		System.out.println(res);

	}
	
	public static int getCount(ArrayList<Integer> al){
		if(al.isEmpty()){
			return 0;
		}
		
//		for (Integer integer : al) {
//			System.out.print(integer+" ");
//		}
//		System.out.println();
		ArrayList<Integer> al1 = new ArrayList<>(al);
		int idx = al1.get(0);
		al1.remove(0);
		int res1 = getCount(al1);
		al1.removeAll(neigh[idx]);
		int res2 = population[idx]  + getCount(al1);
		int res = Math.max(res1, res2);
		return res;
	}

}
