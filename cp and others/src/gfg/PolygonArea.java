package gfg;

import java.util.Scanner;

public class PolygonArea {	private static int N;
/**
 * @param args
 */
//Take care of sign of area (CCW/CW)
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner sc= new Scanner(System.in);
	int testCases = sc.nextInt();
	for(int t=0;t<testCases;t++){
		N=sc.nextInt();
		int x[]=new int[N];
		int y[]=new int[N];
		for(int i=0;i<N;i++) {
			x[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			y[i]=sc.nextInt();
		}
		double area=0;
		for(int i=0;i<N;i++){
			area+=(x[(i+1)%N]-x[i])*(y[(i+1)%N]+y[i]);
		}
		System.out.println(area/2); //Take care of sign of area (CCW/CW)
	}
}}

//or
//double A = 0.0;
//for (int i = 0; i < N; ++i) {
//	int j = (i + 1) % N;
//	A += p[i].x * p[j].y - p[j].x * p[i].y;
//}
//
//return A / 2.0;
//
//negative for clockwise
//
//or
//double polygonArea(double *X, double *Y, int points) {
//
//double  area=0. ;
//int     i, j=points-1  ;
//
//for (i=0; i<points; i++) {
//area+=(X[j]+X[i])*(Y[j]-Y[i]); j=i; }
//
//return area*.5; }
//
//negative for counterclockwise
//or

//double area(Point* A, int a) {
//    double area = 0;        
//    for(int i=0; i<a; i++) {
//        int j = (i+1)%a;
//        area += (A[i].x + A[j].x) * (A[i].y - A[j].y);
//    }
//    return area / 2;
//}

//or
//int area = 0;
//int N = lengthof(p);
////We will triangulate the polygon
////into triangles with points p[0],p[i],p[i+1]
//
//for(int i = 1; i+1<N; i++){
//    int x1 = p[i][0] - p[0][0];
//    int y1 = p[i][1] - p[0][1];
//    int x2 = p[i+1][0] - p[0][0];
//    int y2 = p[i+1][1] - p[0][1];
//    int cross = x1*y2 - x2*y1;
//    area += cross;
//}
//return abs(cross/2.0);