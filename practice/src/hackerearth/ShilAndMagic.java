	package hackerearth;

	import java.util.*;

	public class ShilAndMagic {

		/**
		 * @param args
		 */
		static HashMap<Integer,Integer> forRes;
		static class BITNode{
			HashMap<Integer, Integer> hmap = new HashMap<>();
//			public BITNode() {
//				hmap.put(0, 0);
//			}
		}
		static BITNode[] bitree;
		static int[] input;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int q = in.nextInt();
			input = new int[n];
			bitree = new BITNode[n+1];
		
			for (int i = 0; i < bitree.length; i++) {
				bitree[i] = new BITNode();
			}
		
			for(int i=0; i<n; i++){
				updatebitree(0, i,false);
			}
			//printbitree();
			for(int i=0; i<q; i++){
				int op = in.nextInt();
				if(op==1){
					int idx = in.nextInt()-1;
					int k = in.nextInt();
					updatebitree(k, idx,true);
					//printbitree();
				}else{
					int p = in.nextInt()-1;
					forRes = new HashMap<>();
					populateRes(p);
					int res =1;
					for(Integer ii : forRes.keySet()){
						int count = forRes.get(ii) +1;
						//System.out.println(forRes.get(ii)+" "+ii);
						int tr = count;
						for(int idx =1; idx <count; idx++){
							//System.out.println(tr);
							tr = (tr * count)%(1000000000 + 7);
						}
						res = (res * tr)%(1000000000 + 7);
					}
					System.out.println(res);
				
				}
			}
		

		}

		static void populateRes(int idx) {
			idx = idx +1;
			while(idx >0){
				HashMap<Integer, Integer> tmap = bitree[idx].hmap;
				for(Integer i : tmap.keySet()){
					//System.out.println(i);
					if(!forRes.containsKey(i)){
						int t1 = tmap.get(i);
						//System.out.println("t1 "+t1);
						forRes.put(i, t1);
					}else{
						int t2 = forRes.get(i);
						t2 = t2 + tmap.get(i);
						//System.out.println("t2 "+t2);
						forRes.put(i, t2);
					}
				}
				idx = getParent(idx);
				//System.out.println("idx"+idx);
			}
		
		}

		static void updatebitree(int newVal, int idx, boolean replace){
			int oldval = input[idx];
			input[idx] = newVal;
			idx = idx+1;
			int prev = idx;
			int count =1;
			while(idx < bitree.length){
				HashMap<Integer, Integer> premap = bitree[prev].hmap;
				HashMap<Integer, Integer> nodemap = bitree[idx].hmap;
				if(nodemap.containsKey(oldval) && replace){
					int t1 = nodemap.get(oldval);
					t1--;
					nodemap.put(oldval, t1);
				}
				if(!nodemap.containsKey(newVal)){
					nodemap.put(newVal, 1);
				}else{
					int t2 = nodemap.get(newVal) + 1;
					nodemap.put(newVal, t2);
				}
				//printbitree();
				prev = idx;
				idx = getNext(idx);
			}
		
		}

		static int getNext(int index) {
			// TODO Auto-generated method stub
			return index + (index & -index);
		}
		 
		static int getParent(int index) {
				// TODO Auto-generated method stub
				return index - (index & -index);
		}
	

		static void printbitree() {
		
			for (int i = 0; i < input.length; i++) {
				System.out.print(input[i]+" ");
			}
			System.out.println();
			for(int i=0; i<bitree.length; i++){
				HashMap<Integer, Integer> hmap = bitree[i].hmap;
				System.out.println("Node"+i);
				for(Integer key : hmap.keySet()){
					System.out.println(key+" "+hmap.get(key));
				}
			}
		
		}

	}
