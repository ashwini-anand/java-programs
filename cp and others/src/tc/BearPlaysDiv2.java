package tc;

import java.util.Arrays;

public class BearPlaysDiv2 {
	public static boolean found[][] = new boolean[1500][1500];

//	public static void main(String[] args) {
//		System.out.println(equalPiles(2, 11, 5));
//
//	}
	
	public static boolean ifpossible(int A, int B, int C){

		int[] a = new int[3];
		a[0] = A;
		a[1] = B;
		a[2] = C;
		boolean possible = false;
		if(a[0]==a[1] && a[1]==a[2]) {return true;}
		if((a[0]+a[1]+a[2])%3 != 0  ) return false;
		if(found[a[0]][a[1]] == true || found[a[0]][a[2]] == true || found[a[1]][a[0]] == true || found[a[1]][a[2]] == true || found[a[2]][a[0]] == true || found[a[2]][a[1]] == true )
			return false;
		else{
		found[a[0]][a[1]] = true;
		found[a[0]][a[2]] = true;
		found[a[1]][a[0]] = true;
		found[a[1]][a[2]] = true;
		found[a[2]][a[0]] = true;
		found[a[2]][a[1]] = true;
		
		//if(ispossible) return "possible";
		//System.out.println(ispossible);
		
			if(a[0] < a[1])  possible = possible ? possible : ifpossible(A+A, B-A, C);
			if(a[0] > a[1])  possible = possible ? possible : ifpossible(A-B, B+B, C);
			if(a[0] < a[2])  possible = possible ? possible : ifpossible(A+A, B, C-A);
			if(a[0] > a[2])  possible = possible ? possible : ifpossible(A-C, B, C+C);
			if(a[1] < a[2])  possible = possible ? possible : ifpossible(A, B+B, C-B);
			if(a[1] > a[2])  possible = possible ? possible : ifpossible(A, B-C, C+C);
		}
	//	System.out.println("Hiiiiiiiiii");
		return possible;		
		
	}
	
	public static String equalPiles(int A, int B, int C){
		//Arrays.fill(found, false);
		for (int i = 0; i < 1500; i++) {
			for (int j = 0; j < 1500; j++) {
				found[i][j] = false;
			}
			
		}
		boolean isposs = ifpossible(A,B,C);
		if(isposs){
			return "possible";
		}else{
			return "impossible";
		}
	}

}
