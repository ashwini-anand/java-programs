
public class BadRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(rec(40));
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);

	}
	
	public static int rec(int n){
		if(n<2) return n;
		else return ((rec(n-1)+rec(n-2))%100);
	}

}
