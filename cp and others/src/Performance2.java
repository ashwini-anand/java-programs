
public class Performance2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n2 = Integer.MAX_VALUE-500000;
		int a[] = new int[161310432+9939999];
		int n =10;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					a[i] = 1;
				}
			}
		}
		System.out.println(Runtime.getRuntime().freeMemory());
		System.out.println("here");
	}

}
