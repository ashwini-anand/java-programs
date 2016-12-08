package tc;

public class BearCheats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String eyesight(int A, int B){
		String str1 = String.valueOf(A);
		String str2 =  String.valueOf(B);
		int count = 0;
		for (int i = 0; i <str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)){
				count++;
			}
		}
		if(count <= 1){
			return "happy";
		}
		
		
		return "glasses";
		
	}

}
