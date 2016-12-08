package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CircleIntersection {

	/**
	 * @param args
	 */
	
	public static class Circle{
		int x;
		int y;
		int r;
		public Circle(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
		
	}
	
	public static boolean vis[];
	public static Stack<Integer> stack = new Stack<>();
	public static ArrayList<Circle> cirlist;
	public static Circle circles[] ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();
		vis = new boolean[n];
		circles = new Circle[n];
		
		for (int i = 0; i < circles.length; i++) {
			int x = in.nextInt() + 20;
			int y = in.nextInt() + 20;
			
			Circle c1 = new Circle(x, y, r);
			circles[i] = c1;
		}
		//cirlist = new ArrayList<Circle>(Arrays.asList(circles));
		
		for (int i = 0; i < circles.length; i++) {
			
			if(vis[i]== false){
				//System.out.println(i+" ");
				toposort(i);
			}
		}
		Arrays.fill(vis, false);
		int count =0;
		//System.out.println(stack.toString());
		//System.out.println(stack.peek());
		while(!stack.isEmpty()){
			int i = stack.pop();
			if(!vis[i]){
				count++;
				toposort2(i);
			}
		}
			System.out.println(count);

	}
	
	public static void toposort(int i){
		//ArrayList<Circle> clist = new ArrayList<>();
		vis[i] = true;
		for (int j = 0; j < circles.length; j++) {
			//System.out.println(isIntersecting(circles[2], circles[3]));
			if(vis[j]== false && isIntersecting(circles[i], circles[j])){
				toposort(j);
			}
		}
		stack.push(i);
	}
	
	public static void toposort2(int i){
		//ArrayList<Circle> clist = new ArrayList<>();
		vis[i] = true;
		for (int j = 0; j < circles.length; j++) {
			
			if(vis[j]== false && isIntersecting(circles[i], circles[j])){
				toposort(j);
			}
		}
	}
	
	public static boolean isIntersecting(Circle c1,Circle c2){
		double x = (c1.r - c2.r)*(c1.r - c2.r);
		double y = (c1.r + c2.r)*(c1.r + c2.r);
		double z = (c1.x-c2.x)*(c1.x-c2.x)+(c1.y-c2.y)*(c1.y-c2.y);
		
//		if(c1.x==5 && c2.x==2){
//			System.out.println(x+" "+y+" "+z);
//		}
		
		if(x<=z && z <= y) {
			//System.out.println();
			return true;
		}
		return false;
		
	}

}

//Test case
//5 5
//3 2
//6 4
//5 2
//2 8
//1 10
