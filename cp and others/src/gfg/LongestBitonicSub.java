package gfg;

public class LongestBitonicSub {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {80, 60, 30, 40, 20, 10};
		maxBitonicSeq(array);

	}

	public static int maxBitonicSeq(int[] array){
		int[] sarray = new int[array.length];
		int[] tarray = new int[array.length];
		
		for (int i = 0; i < sarray.length; i++) {
			sarray[i] = 1;
			tarray[i] = -1;
		}
		for (int i = 1; i < sarray.length; i++) {
			for (int j = 0; j < i; j++) {
				if(array[i]>array[j] && sarray[i] < sarray[j]+1) {
					sarray[i] = sarray[j]+1;
				}else if(array[i]<array[j]){
					if(tarray[j] == -1) {
						tarray[i] = sarray[j]+1;
					}else{
						tarray[i] = tarray[j]+1;
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < sarray.length; i++) {
			
			max = Math.max(max, sarray[i]);
		}
		for (int i = 0; i < tarray.length; i++) {
			max = Math.max(max, tarray[i]);
		}
		System.out.println(max);
		
		
		return 0;
	}
}
