package hackerrank;

import java.io.IOException;

abstract class Test1 {
	// /final static int a =0;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void func3() throws IOException {
		System.out.println("In test1");
		String str = "Knowledge";
		str = str.concat("base");
		System.out.println(str);
		throw new IOException();
	}
	public void fun7(Object abc){
		
	}
	public void fun7(String st){
		
	}
//	public void func7() throws IOException {
//		func3();
//	}

	public void func4(int a) {
		System.out.println("In test1");
		if(a==2){
			throw new ArithmeticException();
		}else if(a==3){
			throw new NullPointerException();
		}
	}

	public void func6(){
		try{
			System.out.println("In test1 func6");
		}catch(ArithmeticException e){
			
		}catch(Exception e){
			
		}
	}

	public static void main(String[] args) throws NullPointerException, IOException {
		// TODO Auto-generated method stub
		// func1();
		Test1 t = new Test();
		t.func3();
		t.func4(3);
		t.func6();
		t.fun7(null);
		((Test) t).func5();
		try {
			//throw new IOException("exception thrown");
		} catch (MyException e) {
			System.out.println("Exception occured "+e);
		}

	}
}

class MyException extends RuntimeException{

	public MyException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	
}

class Test extends Test1 {

	/**
	 * @param args
	 */

	public static class Node {
		int data;
		Node a;
	}

	public static void func1() {
		Node A = new Node();
		System.out.println(A);
		func2(A);
		// System.out.println(A);
	}

	private static void func2(final Node a) {
		// TODO Auto-generated method stub
		System.out.println(a);
		a.a = new Node();
		System.out.println(a);

	}

	public void func4() {
		System.out.println("In test");
	}

	public void func5() {
		System.out.println("In test func 5");
	}

	public void func6() {
		System.out.println("In test func6");
	}

}
