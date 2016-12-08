package codechef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class KGOOD {

	/**
	 * @param args
	 */

	public static class Occurances implements Comparable<Occurances> {
		int x;
		int count;

		public int compareTo(Occurances occ) {

			return this.x - occ.x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			String str = in.next();
			int k = in.nextInt();

			HashMap<Character, Integer> hmap = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				char cc = str.charAt(i);
				if (!hmap.containsKey(cc)) {
					hmap.put(cc, 1);
				} else {
					hmap.put(cc, hmap.get(cc) + 1);
				}
			}

			ArrayList<Occurances> occList = new ArrayList<>();
			ArrayList<Integer> al = new ArrayList<>();
			for (Character key : hmap.keySet()) {
				int val = hmap.get(key);
				if (!al.contains(val)) {
					al.add(val);
					Occurances occ = new Occurances();
					occ.x = val;
					occ.count = 1;
					occList.add(occ);
				} else {
					int idx = al.indexOf(val);
					occList.get(idx).count++;
				}
			}

			Collections.sort(occList);

			int res = 0;

			for (int i = 0; i < occList.size(); i++) {
				Occurances curr = occList.get(i);
				int sum = 0;
				int j = i + 1;
				for (j = i + 1; j < occList.size(); j++) {
					if (occList.get(j).x - curr.x > k) {
						break;
						// sum += occList.get(j).count * (occList.get(j).x -
						// curr.x-k);
					}
				}

				int idx = j;
				if(j==occList.size()){
					continue;
				}
				// if(j!=occList.size()){
				while (j < occList.size()) {
					sum += occList.get(j).count * (occList.get(j).x - curr.x-k);
					j++;
				}
				// }
				int newVal = curr.x+k;
				if(curr.count*curr.x < sum){
					res = res + curr.count*curr.x;
					occList.get(i).x = 0;
				}else{
					res = res + sum;
					for (int l = idx; l < occList.size(); l++) {
						occList.get(l).x = newVal;
					}
					
					
				}

			}
			System.out.println(res);

		}

	}

}
