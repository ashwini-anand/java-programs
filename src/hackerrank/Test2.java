package hackerrank;

class Test2_1{
	int a =10; 
	final int b=20;
	static int c = 30;
	private int d = 40;
	
	void func1(){
		System.out.println("func1");
	}
	static void func2(){
		System.out.println("func2");
	}
	final void func3(){
		System.out.println("func3");
	}
	private void func4(){
		System.out.println("func4");
	}
}

public class Test2 extends Test2_1{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t2 = new Test2();
		System.out.println(t2.a+" "+t2.b+" "+t2.c+" ");
		t2.func1();
		t2.func2();
		t2.func3();

	}

}
