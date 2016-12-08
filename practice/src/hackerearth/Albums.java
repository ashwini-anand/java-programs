package hackerearth;

import java.util.*;

public class Albums {

	/**
	 * @param args
	 */
	static HashMap<Integer, TreeSet<Integer>> hmap = new HashMap<Integer, TreeSet<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		int n = in.nextInt();
		int[] prices = new int[n];
		for(int i=0; i<n; i++){
			prices[i] = in.nextInt();
		}
		for(int i=2; i<=10000; i++){
			TreeSet<Integer> tset = new TreeSet<>();
			for(int j=0; j<n; j++){
				if(prices[j]%i == 0){
					tset.add(j);
				}
			}
			hmap.put(i, tset);
		}
		
		int q = in.nextInt();
		
		while(q-- >0){
			int l = in.nextInt()-1;
			int r = in.nextInt()-1;
			int k = in.nextInt();
			if(k==1){
				int res = r-l+1;
				System.out.println(res);
				continue;
			}
			
			TreeSet<Integer> ktset = hmap.get(k);
			//printset(ktset);
			Integer high = ktset.floor(new Integer(r));
			Integer low = ktset.ceiling(new Integer(l));
			if(high == null || low == null){
				System.out.println("0");
				continue;
			}
			int res = ktset.headSet(high).size() - ktset.headSet(low).size() + 1;
			System.out.println(res);
		}

	}
	
	static void printset(TreeSet<Integer> tset){
		for(Integer i: tset){
			System.out.println(i);
		}
	}

}
