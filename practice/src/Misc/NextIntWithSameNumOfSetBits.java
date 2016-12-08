package Misc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class NextIntWithSameNumOfSetBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
//		Long z = 1L;
//		System.out.println((--z== 0L));
		while(t-- >0){
			int n = in.nextInt();
			String  B = "";
			for (int i = 0; i < n; i++) {
				long k = in.nextLong();
				if(i%2==0){
					while(true){
						if(k-->0L){
							B = B+"1";
						}else{
							break;
						}
					}
				}else{
					while(true){
						if(k-->0L){
							B = B+"0";
						}else{
							break;
						}
					}
				}
			}
			
			//System.out.println(B);
			if(B.length() == 0){
				System.out.println(1);
				System.out.println(0);
				continue;
			}
			BigInteger N = new BigInteger(B, 2);
//			System.out.println(N.intValue());
//			if(N.intValue()==0){
//				System.out.println(1+"here");
//				System.out.println(0);
//				continue;
//			}
			
			BigInteger negBigInt = N.negate();
			BigInteger k1 = N.and(negBigInt);
			BigInteger M = N.add(k1);
			BigInteger negM = M.negate();
			BigInteger K2 = M.and(negM);
			BigInteger one = new BigInteger("1");
			//System.out.println(k1.toString());
			BigInteger temp = K2.divide(k1);
			temp = temp.shiftRight(1);
			BigInteger res = M.add(temp);
			res  = res.subtract(one);
			
			String D = res.toString(2);
			//System.out.println(D);
			
			Long count =1L;
			//int size = 1;
			
			int i =0;
			for (i = 0; i < D.length(); i++) {
				if(D.charAt(i)!='0'){
					break;
				}
			}
			i++;
			ArrayList<Long> al = new ArrayList<>();
			for (; i < D.length(); i++) {
				if(D.charAt(i) == D.charAt(i-1)){
					count++;
				}else{
					al.add(count);
					count = 1L;
					
				}
			}
			al.add(count);
			
			System.out.println(al.size());
			
			for (int j = 0; j < al.size(); j++) {
				System.out.print(al.get(j)+" ");
			}
			System.out.println();
			
			
		}
		
		
//		int N = in.nextInt();
//		int K1 = N & -N;
//		int M = N + K1;
//		int K2 = M & -M;
//		int res =  M + ((K2/K1)>>1) - 1;
//		System.out.println(res);

	}

}
