package uva.DP;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TakeTheLand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(true){
			int m = in.nextInt();
			int n = in.nextInt();
			if(m==0 && n==0) break;
			int mat[][] = new int[m][n];
			
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					int ele = in.nextInt();
					mat[i][j] = ele ==0 ? 1:0;
				}
			}
			int temp[] = new int[n];
			int area =0;
			int maxArea =0;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < temp.length; j++) {
					if(mat[i][j]==0){
						temp[j] =0;
					}else{
						temp[j] += mat[i][j];	
					}
				}
				area = maxHistogram(temp);
				if(area > maxArea){
					maxArea = area;
				}
			}
			System.out.println(maxArea);
			
		}

	}
	
	public static int maxHistogram(int input[]){
		Deque<Integer> stack = new LinkedList<>();
		int maxArea = 0;
		int area =0;
		int i;
		for (i = 0; i < input.length;) {
			if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
				stack.offerFirst(i++);
			}else{
				int top = stack.pollFirst();
				if(stack.isEmpty()){
					area = input[top] * i;
				}else{
					area = input[top] * (i-stack.peekFirst()-1);
				}
				
				if(area > maxArea){
					maxArea  = area;
				}
			}
			
		}
		while(!stack.isEmpty()){
			int top = stack.pollFirst();
			if(stack.isEmpty()){
				area = input[top] * i;
			}else{
				area = input[top] * (i-stack.peekFirst()-1);
			}
			
			if(area > maxArea){
				maxArea  = area;
			}
		}
		
		return maxArea;
		
	}

}
