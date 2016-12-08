// Not able to get AC in Uva judge but runs correctly for all the sample and random test cases.

package gfg;

import java.util.Scanner;

public class OrchardTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (true) {
			double x1 = s.nextDouble();
			double y1 = s.nextDouble();
			double x2 = s.nextDouble();
			double y2 = s.nextDouble();
			double x3 = s.nextDouble();
			double y3 = s.nextDouble();
			if (x1 == 0 && y1 == 0 && x2 == 0 && y2 == 0 && x3 == 0 && y3 == 0)
				break;
			int count = 0;
			for (int i = 1; i <= 99; i++) {
				for (int j = 1; j <= 99; j++) {
					if (isInsideTriangle(x1, y1, x2, y2, x3, y3, (double)i, (double)j))
						count++;
				}
			}
			System.out.printf("%4d\n", count);
		}
	}

	static boolean isInsideTriangle(double x1, double y1, double x2, double y2,
			double x3, double y3, double x, double y) {
		double a = area(x1, y1, x2, y2, x3, y3);
		double a1 = area(x, y, x2, y2, x3, y3);
		double a2 = area(x1, y1, x, y, x3, y3);
		double a3 = area(x1, y1, x2, y2, x, y);
		if (Math.abs(a1 + a2 + a3 - a) < 1e-6) {
			return true;
		} else if (onBoundary(x1, y1, x, y) || onBoundary(x2, y2, x, y)
				|| onBoundary(x3, y3, x, y)) {
			return true;
		}
		return false;

	}

	static boolean onBoundary(double x1, double y1, double x, double y) {
		return Math.abs(x1 - x) < 1e-6 && Math.abs(y1 - y) < 1e-6;
	}

	static double area(double x1, double y1, double x2, double y2, double x3,
			double y3) {
		return Math
				.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);

	}

}
