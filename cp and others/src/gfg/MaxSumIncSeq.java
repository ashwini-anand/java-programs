package gfg;

public class MaxSumIncSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {10, 5, 4, 3};
		maxSum(array);

	}
	
	public static int maxSum(int[] array){
		int[] ms = new int[array.length];
		
		for (int i = 0; i < ms.length; i++) {
			ms[i] = array[i];
		}
		for (int i = 1; i < ms.length; i++) {
			for (int j = 0; j < i; j++) {
				if(array[i]>array[j] && ms[i] < ms[j]+array[i]) ms[i] = ms[j]+array[i];
			}
		}
		int max = 0;
		for (int i = 0; i < ms.length; i++) {
			max = Math.max(max, ms[i]);
		}
		System.out.println(max);
		
		
		return 0;
	}

}
