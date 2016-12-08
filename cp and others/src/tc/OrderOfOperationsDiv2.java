package tc;

public class OrderOfOperationsDiv2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s[]= 	{"01000100000000001101", "00000000000000010001", "00000000000000000010", "01100000010000000000", "00000010000100110000", "00010101000001000000", "00000010010000010000", "00010010000001000000", "10000000000000000000", "00001011001001010001", "00000000000111000000", "00101001000000000010", "01000000000001100000", "00101001000100000000", "01100101100010000000", "00000100000101011110", "00010001000001001011", "00100000100000010100", "00000100000010000010", "00000000010010000000"}
;
		
		System.out.println(minTime(s));

	}

	public static int minTime(String[] s){
		
		int m = s[0].length();
		int n = s.length;
		boolean arrm[] = new boolean[m];
		boolean arrn[] = new boolean[n];
		int k =0;
		int time = 0;
		while(k<s.length){
		k++;	
		int min = Integer.MAX_VALUE;
		String mins = null;
		int spos = -1;
		for (int i = 0; i < s.length; i++) {
			int count=0;
			if(arrn[i]==false){
			for (int j = 0; j < s[i].length(); j++) {
				if(s[i].charAt(j)=='1' && arrm[j]==false) count++;
			}
			if(min>count) {
				min = count;
				mins = s[i];
				spos = i;
			}
		 }	
		}
		int n1=0;
		arrn[spos] = true;
		for (int i = 0; i < mins.length(); i++) {
			if(mins.charAt(i)=='1'&& arrm[i]==false) {
				n1++;
				arrm[i] = true;
			}
		}
		//System.out.println(n1);
		time += n1*n1;
	}
		return time;
		
	}
}
