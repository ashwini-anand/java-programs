package hackerrank;

class TestA {

	/**
	 * @param args
	 */
	int i = 10;
	{
	//	System.out.println(i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface I{
	int func();
}

class TestC extends TestB{
	int i = 30;
	{
		System.out.println(i+"c");
	}
//	public TestC(int a){
//		
//	}
	public TestC(){
		super();
		//this(10);
	//	System.out.println();
	}
}
class TestB extends TestA implements I{
	//int i = 20;
	{
	//	System.out.println(i);
	}
	
	TestB(){
		this.i = 20;
	}
	public static void main(String[] args) {
		TestA a = new TestB();
		System.out.println(a.i);
		int aa =10;
		aa = aa++;
		System.out.println(aa);
////		TestB b = (TestB) new TestA();
////		System.out.println(b.i);
//		TestB b2 = new TestB();
//		System.out.println(b2.i);
//		TestC c = new TestC();
//		System.out.println(c.i);
		

	}
	@Override
	public int func() {
		// TODO Auto-generated method stub
		return 0;
	}

}
