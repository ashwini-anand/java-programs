package gfg;

import java.util.Arrays;
import java.util.Stack;

public class GrahamScan {

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

	public static void convexhull() {
		int n = pts.length;
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
//		for (int i = 0; i < pts.length; i++) {
//			System.out.println(pts[i].x+" "+pts[i].y);
//		}
//		System.out.println("-----------------------");
		int m = 1;

		for (int i = 1; i < n; i++) {
			while (i < n - 1 && Point.orientation(p0, pts[i], pts[i + 1]) == 0)
				i++;
			pts[m] = pts[i];
			m++;
		}

		if (m < 3)
			return;

		hull.push(pts[0]);
		hull.push(pts[1]);
		hull.push(pts[2]);
		for (int i = 3; i < m; i++) {
			while (Point.orientation(nextToTop(), hull.peek(), pts[i]) != 2) {
				hull.pop();
			}
			hull.push(pts[i]);
		}

		while (!hull.isEmpty()) {
			Point p = hull.pop();
			System.out.println(p.x + " " + p.y);
		}
	}

	public static Point nextToTop() {
		Point p = hull.pop();
		Point res = hull.peek();
		hull.push(p);
		return res;
	}

	public static void main(String[] args) {
		pts = new Point[] { new Point(0, 3), new Point(1, 1), new Point(2, 2),
				new Point(4, 4), new Point(0, 0), new Point(1, 2),
				new Point(3, 1), new Point(3, 3) };
		convexhull();
	}

}
