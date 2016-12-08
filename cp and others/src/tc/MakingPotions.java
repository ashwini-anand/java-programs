package tc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MakingPotions {
	
	static class I{
		String potion;
		int unit;
		
		public I(String p,int u){
			potion = p;
			unit = u;
		}
		
	}
   
	static class R{
		String target;
		List<I> igs = new ArrayList<I>();
		
		R(String i){
			target = i;
		}
		public void add(I i){
			igs.add(i);
		}
	}
	public static void main(String[] args) {
		String[] marketGoods={"MILK","WATER","HOP"};
		int[] cost = {6,1,14};
		String[] recipes= {"NECTAR=4HOP+2MILK","LOVE=5MILK+3BEER","LOVE=2WATER+1LOVE","LOVE=2MIX+1NECTAR",
				"MIX=1MILK+1WATER+1HOP","BEER=5WATER+2HOP","LOVE=1NECTAR+3WATER+3HOP","NECTAR=3BEER+1MILK+2MILK"};
        System.out.println(getCost(marketGoods,cost,recipes));      
	}
	public static int getCost(String[] marketGoods, int[] cost, String[] recipes){
		Map<String, Long> mcost = new HashMap<String,Long>();
		R[] rs = new R[recipes.length];
		int id = 0;
		for (String recipe : recipes) {
			String[] t = recipe.split("=");
			rs[id] = new R(t[0]);
			for(String rr:t[1].split("\\+")){
				int u = rr.charAt(0)-'0';
				String pt = rr.substring(1);
				rs[id].add(new I(pt,u));
				mcost.put(pt, Long.MAX_VALUE);
			}
			mcost.put(t[0], Long.MAX_VALUE);
			id++;
		}
		for (int i = 0; i < cost.length; i++) {
			mcost.put(marketGoods[i], Long.valueOf(cost[i]));
		}
		
		boolean isChanged =  false;
		do{
			isChanged =  false;
			for (R r : rs) {
				String t = r.target;
				Long oldc = mcost.get(t);
				Long newc = (long) 0;
				boolean found = true;
				for (I i : r.igs) {
					Long icost = mcost.get(i.potion);
					if(icost == Long.MAX_VALUE){
						found= false;
						break;
					}
					 newc += icost * i.unit;
					 if(newc > 1000000000){
						 newc = (long) 1000000001;
					 }
				}
				if(found && oldc > newc){
					mcost.put(r.target, newc);
					isChanged = true;
				}
				
			}
		}while(isChanged);
		
		Long ans = mcost.get("LOVE");
		if (ans == null || ans == Long.MAX_VALUE) {
		      return -1;
		    }
		return ans.intValue();
	}
	  

}
