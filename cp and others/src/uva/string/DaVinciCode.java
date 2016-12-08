package uva.string;

import java.util.*;

public class DaVinciCode {

	public static void main(String[] args) {
		Long[] fib = new Long[100];
		HashMap<Long, Integer> hmap = new HashMap<>();
		// fib[0] = 0;
		fib[0] = 1L;
		fib[1] = 2L;
		hmap.put(1L, 0);
		hmap.put(2L, 1);
		int k = 2;
		while (fib[k - 1] <= 2147483648L) {
			fib[k] = fib[k - 1] + fib[k - 2];
//			if(fib[k]==377){
//				System.out.println(fib[k]+" "+k);
//			}
			hmap.put(fib[k], k);
			k++;
		}
		//System.out.println(hmap.get(377));
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t-- > 0) {
			int n = in.nextInt();
			Long fibarr[] = new Long[n];
			Long max = 0L;
			for (int i = 0; i < n; i++) {
				Long num = in.nextLong();
				fibarr[i] = num;
				if (num > max) {
					max = num;
				}
			}
			in.nextLine();
			//System.out.println(max);
			//System.out.println(hmap.get(max));
			char[] decipher = new char[hmap.get(max) + 1];
            Arrays.fill(decipher,' ');
			String s = in.nextLine();
			s = s.replaceAll("[^A-Z]", "");
			char cipher[] = s.toCharArray();
			for (int i = 0; i < n; i++) {
				//System.out.println(i);
				//System.out.println(fibarr[i]);
				int idx = hmap.get(fibarr[i]);
				//System.out.println(idx);
				decipher[idx] = cipher[i];
			}
            System.out.println(new String(decipher));

		}
	}

}