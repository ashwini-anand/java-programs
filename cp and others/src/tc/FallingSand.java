package tc;

import java.util.Arrays;

public class FallingSand {
	
//	public static void main(String[] args) {
//		String[] board = {"ooooo", "..x..", "....x", ".....", "....o"};
//		System.out.println(Arrays.toString(simulate(board)));
//	}
	
	public static String[] simulate(String[] board){
		if(board.length == 1){
			return board;
		}
		int count =1;
		while(true){
		if(count == 0) break;
		count =0;
		
		for(int i=board.length-2;i>=0;i--){
			for (int j = 0; j < board[i].length(); j++) {
				//System.out.println(board[i]+" "+board[i+1]+" "+i+" "+j);
				//if(board[i][j] == 'o' && board[i+1][j] == '.')
			//	System.out.println(board[i]+" "+j+" "+i+" "+board[i].length()+" "+board[i+1].charAt(j));
				//System.out.println(board[i+1]+" "+i+" "+j);
				if(board[i].charAt(j) == 'o' && board[i+1].charAt(j) == '.'){
					String t = board[i+1];
					String ti = board[i];
					String t2 = null ;
					String t3 = null ;
					if(j==0 && (j == board[i+1].length()-1)){
						t2 = "o";
						t3 = ".";
						count++;
					}
					else if(j==0){
						t2 = 'o'+t.substring(j+1);
						t3 = '.'+ti.substring(j+1);
						count++;
					}
					else if(j == board[i+1].length()-1){
						t2 = t.substring(0, j)+'o';
						t3 = ti.substring(0, j)+'.';
						count++;
					}
					else if(j<board[i+1].length()-1){
						//System.out.println(board[i]+" "+j+" "+i);
					   t2 = t.substring(0, j)+'o'+t.substring(j+1);
					   t3 = ti.substring(0, j)+'.'+ti.substring(j+1);
					   count++;
					   //System.out.println("T2 "+t2);
					}
					board[i+1] = t2;
					board[i] = t3;
				}
			}
		}
	}
		
		
		
		return board;
		
	}

}
