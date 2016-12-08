package tc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class cityprofit implements Comparable<cityprofit>{
	int city;
	int profit;
	
	@Override
	public int compareTo(cityprofit o) {
		return o.profit-this.profit;
	}
}

public class TravellingSalesmanEasy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//
//		int m =7;
//		int[] profit = {22,91,53,7,80,100,36,65,92,93,19,92,95,3,60,50,39,36,2,30,63,84,2};
//		int city[]={5,3,4,3,6,5,6,6,5,2,7,6,3,2,6,1,7,4,6,3,7,2,5};
//		int visit[]= {5,7,1,3,6,2,5,7,3,6,3,2,7,3,1,3,1,7,2,3,1,1,3,1,6,1};
//		System.out.println(getMaxProfit(m, profit, city, visit));
	}
	
	public static int getMaxProfit(int M, int[] profit, int[] city, int[] visit){
		
		List<cityprofit> clist = new ArrayList<cityprofit>();
		for (int i = 0; i < profit.length; i++) {
			cityprofit cp =  new cityprofit();
			cp.city = city[i];
			cp.profit  = profit[i];
			clist.add(cp);
		}
		Collections.sort(clist);
//		for (int i = 0; i < profit.length; i++) {
//			System.out.println(clist.get(i).profit);
//		}
		
		int res = 0;
		int profitvalue = 0;
		boolean found = false;
		for (int i = 0; i < visit.length; i++) {
			found = false;
			int j =0;
			for (j = 0; j < clist.size(); j++) {
				if(clist.get(j).city == visit[i]){
					profitvalue  = clist.get(j).profit;
					found = true;
					break;
				}
			}
			if(found){
				clist.remove(j);
			}else{
				profitvalue = 0;
			}
			res += profitvalue;
		}
		
		return res;
		
	}

}
