package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ModularQueries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		MyScanner s = new MyScanner();
		int n = MyScanner.nextInt();
		String[] arr = new String[n+1];
		arr[0]=null;
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = MyScanner.next();
		}
//		for (int i = 1; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		int q=MyScanner.nextInt();
		
		while(q>0){
			q--;
			int indi = MyScanner.nextInt();
			if(indi==1){
				int k = MyScanner.nextInt();
				arr[k] = MyScanner.next();
			}else{
				int k = MyScanner.nextInt();
				String ss = "";
				int k2 = MyScanner.nextInt();
				
				for (int i = k; i <= k2; i++) {
					ss += arr[i];
				}
				
				BigInteger res = new BigInteger(ss);
				int rr = 1000000007;
				BigInteger res1 = res.mod(new BigInteger(String.valueOf(rr)));
//				DecimalFormat df = new DecimalFormat("###.#");
//				System.out.println(df.format(res));
				System.out.println(res1);
			}
		}
				
	

	}
	
	

}


class MyScanner {
   static BufferedReader br;
   static StringTokenizer st;

   public MyScanner() {
      br = new BufferedReader(new InputStreamReader(System.in));
   }

   static String  next() {
       while (st == null || !st.hasMoreElements()) {
           try {
               st = new StringTokenizer(br.readLine());
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return st.nextToken();
   }

   static int nextInt() {
       return Integer.parseInt(next());
   }

   static long nextLong() {
       return Long.parseLong(next());
   }

   static double nextDouble() {
       return Double.parseDouble(next());
   }

   static String nextLine(){
       String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
   }

}
