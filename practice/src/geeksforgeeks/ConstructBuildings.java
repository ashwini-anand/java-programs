package geeksforgeeks;

import java.util.*;

public class ConstructBuildings{
	public static int count;
	static boolean[][] mat;
	static int plots;
	public static void main(String[] args){
		
		count =0;
		plots = 3;
		mat= new boolean[plots+1][plots+1];
		//for(
		countWays(1,"1");
		countWays(1,"0");
		System.out.println(count*count);
	}

	public static void countWays(int n, String str){
		if(n==plots){
			System.out.println(str);
		    count++;
		    return;
		} 
		//System.out.println(str.substring(str.length()-1,str.length()));
		if(mat[n][Integer.parseInt(str.substring(str.length()-1,str.length()))] == true) return ;
		else{
			mat[n][Integer.parseInt(str.substring(str.length()-1,str.length()))] = true;
			if(str.charAt(str.length()-1)=='1'){
				//System.out.println("ABC");
				countWays(n+1,str+"0");
			}else{
				//System.out.println("ABC2");
				countWays(n+1,str+"0");
				countWays(n+1,str+"1");
			}

		}
		//return mat[n][Integer.parseInt(str.charAt(str.length()-1))];
		
	}

}