package tc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class positionlength implements Comparable<positionlength>{
	int startposition;
	int end;
	int leftdist;
	@Override
	public int compareTo(positionlength arg0) {
		return this.startposition - arg0.startposition;
	}
}

class distpos implements Comparable<distpos>{
	int dist;
	int index;
	@Override
	public int compareTo(distpos o) {
		return o.dist - this.dist;
	}
	
	public String toString(){
		return dist+" "+index;
	}
	
}


public class ConnectingCars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] positions =  	{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 900000001, 900000002, 900000003, 900000004, 900000005, 900000006, 900000007, 900000008, 900000009, 900000010, 900000011, 900000012, 900000013, 900000014, 900000015, 900000016, 900000017, 900000018, 900000019, 900000020, 900000021, 900000022, 900000023, 900000024, 900000025};
		int[] lengths = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000000000};
		
		System.out.println(minimizeCost(positions, lengths));

	}

	public static 	long minimizeCost(int[] positions, int[] lengths){
		
		List<positionlength> plist = new ArrayList<positionlength>();
		
		for (int i = 0; i < lengths.length; i++) {
			positionlength pl = new positionlength();
			pl.startposition = positions[i];
			pl.end = positions[i]+lengths[i];
			plist.add(pl);
		}
		
		Collections.sort(plist);
		
		List<distpos> dplist =  new LinkedList<distpos>();
		for (int i = 0; i < plist.size()-1; i++) {
			distpos dp = new distpos();
			int d = plist.get(i+1).startposition - plist.get(i).end ;
			dp.dist =d;
			dp.index = i;
			dplist.add(dp);
			
			plist.get(i).leftdist = d;
		}
		Collections.sort(dplist);

		long res =0;
		
		//System.out.println(dplist);
		
		for (int i = 0; i < dplist.size(); i++) {
			long m = dplist.get(i).index+1 > plist.size()-dplist.get(i).index-1 ? plist.size()-dplist.get(i).index-1 : dplist.get(i).index+1;
		//	System.out.println(m+" "+dplist.get(i).dist);
			res +=m*(long)dplist.get(i).dist;
		//	System.out.println(res);
			
		}
		
		
		return res;
		
	}
}
