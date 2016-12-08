package tc;

public class AB {

	public static void main(String[] args) {
         System.out.println(createString(50,401));
	}
	
	public static String createString(int N, int K){
		int a=N,b=K;
		int c = a/2;
		int d = a-c;
		if(c*d < K){
			return "";
		}
		String str = "";
		if(K==0){
			for (int i = 1; i < N ; i++) {
				str += "B";
			}
			return str+"A";
		}
		
		int e = 0;
		int numA = 0;
		int numB=0;
		for (int i = 1; i <= N ; i++) {
			for (int j = 1; j <= N ; j++){
				if((i*j == K) &&(i+j <=N)){
					numA = i;
					numB =j;
					e=1;
					break;
				}
			}
			
		}
		if(e==0) return "";
		int left = N-(numA+numB);
		for (int i = 1; i <= left; i++) {
			str += "B";
		}
		for (int i = 1; i <= numA; i++) {
			str += "A";
		}
		for (int i = 1; i <= numB; i++) {
			str += "B";
		}
		return str;
		
	}

}
