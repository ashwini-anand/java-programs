package gfg;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CopsAndRobbers2 {

	/**
	 * @param args
	 */
	static public Point p0;
	static Stack<Point> hull = new Stack<>();
	static Point pts[];

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point() {
			// TODO Auto-generated constructor stub
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			int orient = orientation(p0, this, o);
			if (orient == 0) {
				return (distSq(p0, o) >= distSq(p0, this)) ? -1 : 1;
			}
			return (orient == 2) ? -1 : 1;
		}

		public static int orientation(Point p, Point q, Point r) {

			int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
			if (val == 0)
				return 0;
			return (val > 0) ? 1 : 2;

		}

		public static int distSq(Point p1, Point p2) {
			return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
					* (p1.y - p2.y);
		}
	}

	public static Point[] convexhull() {
		hull.clear();
		int n = pts.length;
		if (n <= 3)
			return pts;

		int ymin = pts[0].y;
		int min = 0;
		for (int i = 1; i < pts.length; i++) {
			if (ymin > pts[i].y || (ymin == pts[i].y && pts[i].x < pts[min].x)) {
				ymin = pts[i].y;
				min = i;
			}
		}

		Point temp = pts[0];
		pts[0] = pts[min];
		pts[min] = temp;

		p0 = pts[0];

		Arrays.sort(pts, 1, n);
		int m = 1;

		for (int i = 1; i < n; i++) {
			while (i < n - 1 && Point.orientation(p0, pts[i], pts[i + 1]) == 0)
				i++;
			pts[m] = pts[i];
			m++;
		}

		if (m <= 3)
			return Arrays.copyOfRange(pts, 0, m); // returns range of array,
													// exclusive m.

		hull.push(pts[0]);
		hull.push(pts[1]);
		hull.push(pts[2]);
		for (int i = 3; i < m; i++) {
			while (Point.orientation(nextToTop(), hull.peek(), pts[i]) != 2) {
				hull.pop();
			}
			hull.push(pts[i]);
		}

		// while (!hull.isEmpty()) {
		// Point p = hull.pop();
		// System.out.println(p.x + " " + p.y);
		// }

		Point[] hullPoints = new Point[hull.size()];
		return hull.toArray(hullPoints);
	}

	public static Point nextToTop() {
		Point p = hull.pop();
		Point res = hull.peek();
		hull.push(p);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int t = 1;
		while (true) {
			int c = s.nextInt();
			int r = s.nextInt();
			int o = s.nextInt();

			if (c == 0 && r == 0 && o == 0)
				break;

			pts = new Point[c];
			for (int i = 0; i < c; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				Point p = new Point(x, y);
				pts[i] = p;
			}
			Point[] copsPoint = convexhull();

			pts = new Point[r];
			for (int i = 0; i < r; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				Point p = new Point(x, y);
				pts[i] = p;
			}
			Point[] robbersPoint = convexhull();

			System.out.println("Data set " + t + ":");
			t++;

			Polygon copsPoly = new Polygon();
			for (int i = 0; i < copsPoint.length; i++) {
				copsPoly.addPoint(copsPoint[i].x, copsPoint[i].y);
			}

			Polygon robbersPoly = new Polygon();
			for (int i = 0; i < robbersPoint.length; i++) {
				robbersPoly.addPoint(robbersPoint[i].x, robbersPoint[i].y);
			}

			for (int i = 0; i < o; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				boolean flag = false;
				if (c >= 3) {
					for (int j = 0; j < copsPoint.length - 1; j++) {
						Point p1 = copsPoint[j];
						Point p2 = copsPoint[j + 1];
						if (Line2D.ptSegDist(p1.x, p1.y, p2.x, p2.y, x, y) == 0) {
							System.out.println("     Citizen at (" + x + ","
									+ y + ") is safe.");
							flag = true;
							break;
						}
					}
					if (flag == false && copsPoint.length != 0) {
						int k = copsPoint.length - 1;
						if (Line2D.ptSegDist(copsPoint[k].x, copsPoint[k].y,
								copsPoint[0].x, copsPoint[0].y, x, y) == 0) {
							System.out.println("     Citizen at (" + x + ","
									+ y + ") is safe.");
							flag = true;
							continue;
						}
					}

					if (flag == false && copsPoly.contains(x, y)) {
						System.out.println("     Citizen at (" + x + "," + y
								+ ") is safe.");
						flag = true;
						continue;
					}
				}
				if (r >= 3) {

					if (flag == false) {
						for (int j = 0; j < robbersPoint.length - 1; j++) {
							Point p1 = robbersPoint[j];
							Point p2 = robbersPoint[j + 1];
							if (Line2D.ptSegDist(p1.x, p1.y, p2.x, p2.y, x, y) == 0) {
								System.out.println("     Citizen at (" + x
										+ "," + y + ") is robbed.");
								flag = true;
								break;
							}
						}
					}
					if (flag == false && robbersPoint.length != 0) {
						int k = robbersPoint.length - 1;
						if (Line2D.ptSegDist(robbersPoint[k].x,
								robbersPoint[k].y, robbersPoint[0].x,
								robbersPoint[0].y, x, y) == 0) {
							System.out.println("     Citizen at (" + x + ","
									+ y + ") is robbed.");
							flag = true;
							continue;
						}
					}
					if (flag == false && robbersPoly.contains(x, y)) {
						System.out.println("     Citizen at (" + x + "," + y
								+ ") is robbed.");
						flag = true;
						continue;
					}
				}
				if (flag == false) {
					System.out.println("     Citizen at (" + x + "," + y
							+ ") is neither.");
				}
			}
			System.out.println();
		}

	}

}
