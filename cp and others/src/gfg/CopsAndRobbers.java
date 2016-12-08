package gfg;

import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.util.Scanner;

public class CopsAndRobbers {

	/**
	 * @param args
	 */
	static class Point {
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
			Polygon copspoly = new Polygon();
			Point copsPoint[] = new Point[c];
			for (int i = 0; i < c; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				Point p = new Point(x, y);
				copsPoint[i] = p;
				copspoly.addPoint(x, y);
			}

			Polygon robberspoly = new Polygon();
			Point robbersPoint[] = new Point[r];
			for (int i = 0; i < r; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				Point p = new Point(x, y);
				robbersPoint[i] = p;
				robberspoly.addPoint(x, y);
			}
			System.out.println("Data set " + t + ":");
			t++;

			for (int i = 0; i < o; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				boolean flag = false;
				for (int j = 0; j < copsPoint.length - 1; j++) {
					Point p1 = copsPoint[j];
					Point p2 = copsPoint[j + 1];
					if (Line2D.ptSegDist(p1.x, p1.y, p2.x, p2.y, x, y) == 0) {
						System.out.println("     Citizen at (" + x + "," + y
								+ ") is safe.");
						flag = true;
						break;
					}
				}
				if (flag == false && copsPoint.length!=0) {
					int k = copsPoint.length - 1;
					if (Line2D.ptSegDist(copsPoint[k].x, copsPoint[k].y,
							copsPoint[0].x, copsPoint[0].y, x, y) == 0) {
						System.out.println("     Citizen at (" + x + "," + y
								+ ") is safe.");
						flag = true;
					}
				}

				if (flag == false) {
					for (int j = 0; j < robbersPoint.length - 1; j++) {
						Point p1 = robbersPoint[j];
						Point p2 = robbersPoint[j + 1];
						if (Line2D.ptSegDist(p1.x, p1.y, p2.x, p2.y, x, y) == 0) {
							System.out.println("     Citizen at (" + x + ","
									+ y + ") is robbed.");
							flag = true;
							break;
						}
					}
				}
				if (flag == false && robbersPoint.length !=0) {
					int k = robbersPoint.length - 1;
					if (Line2D.ptSegDist(robbersPoint[k].x, robbersPoint[k].y,
							robbersPoint[0].x, robbersPoint[0].y, x, y) == 0) {
						System.out.println("     Citizen at (" + x + "," + y
								+ ") is robbed.");
						flag = true;
					}
				}

				if (flag == false) {
					if (copspoly.contains(x, y)) {
						System.out.println("     Citizen at (" + x + "," + y
								+ ") is safe.");
						continue;
					}
					if (robberspoly.contains(x, y)) {
						System.out.println("     Citizen at (" + x + "," + y
								+ ") is robbed.");
						continue;
					}
					System.out.println("     Citizen at (" + x + "," + y
							+ ") is neither.");
				}
			}
			System.out.println();
		}

	}

}
