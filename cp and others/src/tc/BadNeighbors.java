package tc;

public class BadNeighbors {
	public static void main(String[] args) {
		int[] donations = 	{473, 313, 573, 144, 708, 739, 673, 913, 268, 258, 729, 444, 310, 647, 367, 384, 193, 239, 19, 259, 761, 531, 106, 368, 306, 319, 847, 317, 983, 729, 771, 69, 695, 973, 626, 797, 689, 258, 516} ;
		System.out.println(maxDonations(donations));

	}
	public static int maxDonations(int[] donations){
		int[] lastexc = new int[donations.length-1];
		int [] firstexc = new int[donations.length -1];
		
		if(donations.length == 1) return donations[0];
		if(donations.length == 2) return Math.max(donations[0], donations[1]);
		if(donations.length >= 3) {
			lastexc[0] = donations[0];
			lastexc[1] = Math.max(donations[0], donations[1]);
			firstexc[0]= donations[1];
			firstexc[1] = Math.max(donations[1], donations[2]);
		}
		if(donations.length == 3) return Math.max(lastexc[1], firstexc[1]);
        for (int i = 2; i < donations.length-1; i++) {
			lastexc[i] = Math.max(lastexc[i-2]+donations[i], lastexc[i-1]);
		}		
        int j=2;
        for (int i = 3; i < donations.length; i++) {
			firstexc[j] = Math.max(firstexc[j-2]+firstexc[j], firstexc[j-1]);
		}
        //System.out.println(lastexc.length+" "+firstexc.length);
		return Math.max(lastexc[lastexc.length-1], firstexc[firstexc.length -1]);
		
	}

}
