package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleTrouble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			t--;
			int n = s.nextInt();
			double edgeArr[]  = new double[n];
			for (int i = 0; i < edgeArr.length; i++) {
				edgeArr[i] = s.nextDouble();
			}
			Arrays.sort(edgeArr);
			double maxarea = 0;
			for (int i = n-1; i >= 2; i--) {
				maxarea = Math.max(maxarea, getArea(edgeArr[i], edgeArr[i-1], edgeArr[i-2]));
			}
			System.out.printf("%.2f\n",maxarea);
		}

	}
	
	public static double getArea(double a, double b, double c){
		
		if(a+b<c||a+c<b||b+c<a) return 0;
		double s = (a+b+c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return area;
		
	}

}
