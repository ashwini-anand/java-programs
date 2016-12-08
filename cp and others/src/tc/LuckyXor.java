package tc;

public class LuckyXor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//System.out.println(construct(7));
	}
	
	public static int construct(int a){
		int num = -1;
		boolean flag = true;
		for (int i = a+1; i <= 100; i++) {
			int x = a ^ i;
		//	System.out.println(x);
			String s = Integer.toString(x);
			flag = true;
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)!='7' && s.charAt(j)!='4'){
					flag = false;
					break;
				}
			}
			if(flag) {
				num =  i;
				break;
			}
		}
		if(num < 1 || num >100) return -1;
		
      	return num;
	}

}
