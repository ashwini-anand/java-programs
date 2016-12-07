package hackerrank;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class IliaTriangle {

	public static PrintWriter out;
	public int x;

	public static void main(String[] args) {

		MyScanner s = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = s.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[n];
		int rt = 0;
		int at = 0;
		int ot = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
			// arr1[i] = arr[i] * arr[i];
		}

		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i] * arr[i];
		}

		for (int i = 0; i < arr1.length - 2; i++) {
			for (int j = i + 1; j < arr1.length - 1; j++) {
				for (int j2 = j + 1; j2 < arr1.length; j2++) {
					if (arr[i] + arr[j] > arr[j2]) {
						if (arr1[i] + arr1[j] == arr1[j2]) {
							rt++;

						} else if (arr1[i] + arr1[j] > arr1[j2]) {
							at++;
						} else {
							ot++;
							// ot = ot+(arr.length-j2-1);
							// break;
							int count = 0;
							for (int k = j2 + 1; k < arr1.length; k++) {
								if (arr[i] + arr[j] > arr[k])
									count++;
								else
									break;
							}
							ot += count;
							break;

						}
					} else {
						break;
					}
				}
			}
		}

		// System.out.println(at + " " + rt + " " + ot);
		out.println(at + " " + rt + " " + ot);

		out.close();
	}

	static class MyScanner {
		static BufferedReader br;
		static StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	// --Not used, just for reference, can be used in future--//
	static class FasterScanner {

		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}

}
