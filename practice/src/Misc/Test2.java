package Misc;

class Test22{
	static{
		System.out.println("in static block");
	}
	
	Test22(){
		System.out.println("in constructor test22");
	}
}

public class Test2 {

	/**
	 * @param args
	 */
	static Test22 t22;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		t22 = new Test22();
		boolean[] arr = new boolean[5];
		System.out.println(arr[0]);
	}

}
