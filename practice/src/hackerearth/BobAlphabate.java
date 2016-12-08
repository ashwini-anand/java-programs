package hackerearth;

import java.util.*;

public class BobAlphabate {

	/**
	 * @param args
	 */
	static int[] dp;
	static int minimum = 999999;
	static String str;
	static HashMap<Character,ArrayList<Integer>> hmap;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- >0){
			str = in.next();
			hmap = new HashMap<Character,ArrayList<Integer>>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(!hmap.containsKey(c)){
					ArrayList<Integer> al = new ArrayList<>();
					al.add(i);
					hmap.put(c, al);
				}else{
					ArrayList<Integer> al = hmap.get(c);
					al.add(i);
					hmap.put(c, al);
				}
			}
			dp = new int[str.length()];
			Arrays.fill(dp, -1);
			ArrayList<Integer> ala = hmap.get('a');
			ArrayList<Integer> alb = hmap.get('b');
			int min = minimum;
			for(int i=0; i<ala.size(); i++){
				int aidx = ala.get(i);
				for(int j=0; j<alb.size(); j++){
					int res = Math.abs(aidx - alb.get(j)) + getMinLen(alb.get(j));
					min = Math.min(min, res);
				}
			}
			System.out.println(min);
			
		}

	}
	static int getMinLen(int idx) {
		if(str.charAt(idx) == 'z'){
			return 0;
		}
		if(dp[idx] != -1){
			return dp[idx];
		}
		char c = str.charAt(idx);
		char next = (char) (c+1);
		ArrayList<Integer> alnext = hmap.get(next);
		int min = minimum;
		
		for(int i=0; i<alnext.size(); i++){
			int res = Math.abs(idx - alnext.get(i)) + getMinLen(alnext.get(i));
			min = Math.min(min,res);
		}
		dp[idx] = min;
		return min;
	}

}
