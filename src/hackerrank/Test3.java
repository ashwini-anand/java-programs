package hackerrank;

class Test3_1{
	Number func2(){
		System.out.println("func2 of parent");
		return  3;
	}
	void func1(){
		System.out.println("func1 of parent");
	}
}

class Test3 extends Test3_1{

	/**
	 * @param args
	 */
//	Number func2(){
//		System.out.println("func21");
//		return 2;
//	}
	Integer func2(){
		System.out.println("func2 of child");
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Test3 t3 = (Test3) new Test3_1();
		Test3 t3 = new Test3();
		Test3_1 t3_1 = t3;
		t3_1.func2();
		t3_1.func1();
		t3.func2();

	}

}
