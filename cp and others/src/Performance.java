
public class Performance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n=10,s=2;
		long startTime = System.nanoTime();
		for (int i = 0; i < n ;i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					s=2*s+1;
					//System.out.println(s);
				}
			}
		}
		//int i = 4294967294;
		//System.out.println(2147483647+2147483647);
		int k = 1000000000;
		int p = 1000000000;
		int k1 = 1000000000;
		int p1 = 1000000000;
		System.out.println((k*k1) % (p*p1) == 0);
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);
		System.out.println(s);
	}

}
