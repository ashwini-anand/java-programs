package tc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheKingsFactorization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		long N = 100000;
//		long[] primes = {2, 2, 2, 5, 5};
//		long[] res = getVector(N, primes);
//		for (int i = 0; i < res.length; i++) {
//			System.out.print(res[i]+" ");
//		}

	}
	
	public static long[] getVector(long N, long[] primes){
		List<Long> list = new ArrayList<Long>();
		
		for (int i = 0; i < primes.length; i++) {
			list.add(primes[i]);
			N=N/primes[i];
		}
		
		while(N%2==0){
			list.add((long) 2);
			N=N/2;
		}
		for (int i = 3; i*i <= N; i=i+2) {
			while(N%i==0){
				list.add((long) i);
				N= N/i;
			}
		}
		
		if(N>2){
			list.add(N);
		}
		
		Collections.sort(list);
		long[] res = new long[list.size()];
		int i=0;
		for (Long long1 : list) {
			res[i] = long1;
			i++;
		}
		
		return res;
		
	}

}
