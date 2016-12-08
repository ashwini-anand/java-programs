package Misc;

import java.util.*;

/*
input is taken one by one as character as below:
A C
B C
C F
D E
E F
*/

/*
Result is in Map(Map is Dictionary ) "juniorCount".
SOLUTION APPROACH:
do depth first search ( dfs() ) and update the count of juniors for an employee	
*/


public class FindingNumberOfSubordinates {

	/**
	 * @param args
	 */
	static HashMap<Character, ArrayList<Character>> hmap;
	static TreeMap<Character, Integer> juniorCount; // this contains result
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		hmap = new HashMap<>();
		while(in.hasNext()){
			
			String junior = in.next();
			String senior = in.next();
			char j = junior.charAt(0);
			char s = senior.charAt(0);
			
			if(!hmap.containsKey(s)){
				ArrayList<Character> al = new ArrayList<>();
				al.add(j);
				hmap.put(s, al);
			}else{
				ArrayList<Character> al = hmap.get(s);
				al.add(j);
				hmap.put(s, al);
			}
			
			if(!hmap.containsKey(j)){
				ArrayList<Character> al = new ArrayList<>();
				hmap.put(j, al);
			}
		}
		
		juniorCount = new TreeMap<>();
		
		for(Character c : hmap.keySet()){
			juniorCount.put(c, -1);
		}
		
		for(Character c : hmap.keySet()){
			if(juniorCount.get(c)==-1){
				dfs(c);
			}
		}
		
		// Printing result
		for(Character c: juniorCount.keySet()){
			System.out.println(c+" "+juniorCount.get(c));
		}
		
	}
	
	public static int dfs(char c){
		if(juniorCount.get(c) == -1){
			juniorCount.put(c, 0);
		}else{
			return juniorCount.get(c);
		}
		
		ArrayList<Character> juniors = hmap.get(c);
		
		for(int i=0; i<juniors.size(); i++){
			char jj = juniors.get(i);
			int val =0;
			if(juniorCount.get(jj) != -1){
				val = juniorCount.get(c) + juniorCount.get(jj) + 1;
			}else{
				val = juniorCount.get(c) + 1 + dfs(jj);
			}
			juniorCount.put(c,val);
			
		}
		
		return juniorCount.get(c);
		
	}

}
