package tc;

public class BigFatInteger2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	public static String isDivisible(int A, int B, int C, int D){
//		if(((A%C ==0)&&(B%D==0)) ||((A%D==0)&&(B%C==0))){
//			return "divisible";
//		}
//		return "not divisible";
//	}
	
	public static String isDivisible(int A, int B, int C, int D){
		if((A*B)%(C*D) == 0){
			return "divisible";
		}
		return "not divisible";
	}

}
