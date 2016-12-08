package hackerearth;

import java.util.*;

public class MicroAndSon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Integer> hset = new HashSet<>();
		hset.add(2002);hset.add(0);hset.add(440);hset.add(550);hset.add(1221);hset.add(1551);hset.add(110);hset.add(1331);
		hset.add(220);hset.add(1001);hset.add(1441);hset.add(2112);hset.add(2222);hset.add(1111);hset.add(330);hset.add(2332);
		//hset.addAll({2002, 0, 440, 550, 1221, 1551, 110, 1331, 220, 1001, 1441, 2112, 2222, 1111, 330, 2332})
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.next());
		
		while(t-- >0){
			int s = Integer.parseInt(in.next());
			int e = Integer.parseInt(in.next());
			int count =0;
			
			for(Integer i : hset){
				if((i>=s) && (i<=e)){
					count++;
				}
			}
			System.out.println(count);
			
		}

	}

}
