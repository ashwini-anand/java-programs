package uva.numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class TwinPrimes {

	/**
	 * @param args
	 */
	public static boolean primes[];
	public static int twins[];
	static int M = 20000005;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primes = new boolean[M];
		twins = new int[M];
		Arrays.fill(primes, true);
		sieve();
		generateTwins();
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextInt()){
			int n = in.nextInt();
			int twin1 = twins[n];
			int twin2 = twins[n]+2;
			System.out.println("("+twin1+", "+twin2+")");
		}
		in.close();

	}
	
	public static void sieve(){
		int n = (int) Math.sqrt(M);
		primes[1] = false;
		
		for (int i = 3; i <= n; i++) {
			if(primes[i]){
				for (int j = 2*i; j < M; j=j+i) {
					primes[j] = false;
				}
			}
		}
		
	}
	
	public static void generateTwins(){
		int  j =1;
		for (int i = 3; i < M-3; i++) {
			if(primes[i] && primes[i+2]){
				twins[j++] = i;
			}
		}
	}

}
