package hackerearth;

import java.util.*;

public class Albums2 {

	/**
	 * @param args
	 */
	static HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		int n = in.nextInt();
		int[] prices = new int[n];
		for(int i=0; i<n; i++){
			prices[i] = in.nextInt();
		}
		for(int i=2; i<=10000; i++){
			ArrayList<Integer> tset = new ArrayList<>();
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
			
			ArrayList<Integer> ktset = hmap.get(k);
			Integer[] arr = ktset.toArray(new Integer[ktset.size()]);
			//printset(ktset);
			Integer high = ceilSearch(arr,0,ktset.size()-1,r);
			Integer low = ceilSearch(arr,0,ktset.size()-1,l);
			if(high == -1 || low == -1){
				System.out.println("0");
				continue;
			}
			//int res = ktset.headSet(high).size() - ktset.headSet(low).size() + 1;
			System.out.println(high+" "+low);
			int res = high-low;
			System.out.println(res);
		}

	}
	static int ceilSearch(Integer[] arr, int low, int high, int x)
	{
	  int mid;    
	 
	  /* If x is smaller than or equal to the first element,
	    then return the first element */
	  if(x <= arr[low])
	    return low; 
	 
	  /* If x is greater than the last element, then return -1 */
	  if(x > arr[high])
	    return -1;  
	 
	  /* get the index of middle element of arr[low..high]*/
	  mid = (low + high)/2;  /* low + (high - low)/2 */
	 
	  /* If x is same as middle element, then return mid */
	  if(arr[mid] == x)
	    return mid;
	     
	  /* If x is greater than arr[mid], then either arr[mid + 1]
	    is ceiling of x or ceiling lies in arr[mid+1...high] */ 
	  else if(arr[mid] < x)
	  {
	    if(mid + 1 <= high && x <= arr[mid+1])
	      return mid + 1;
	    else
	      return ceilSearch(arr, mid+1, high, x);
	  }
	 
	  /* If x is smaller than arr[mid], then either arr[mid] 
	     is ceiling of x or ceiling lies in arr[mid-1...high] */   
	  else
	  {
	    if(mid - 1 >= low && x > arr[mid-1])
	      return mid;
	    else    
	      return ceilSearch(arr, low, mid - 1, x);
	  }
	}
	
	static void printset(TreeSet<Integer> tset){
		for(Integer i: tset){
			System.out.println(i);
		}
	}

}
