package Misc;

import java.util.ArrayList;
import java.util.Comparator;


//interface inttest{
//	
//}
//
//interface intest2 extends inttest{
//	
//}

class Test11{
	TestMain2 tt ;
}

class TestMain2 extends TestMain implements Comparable<TestMain2>, Comparator<TestMain2>{

	/**
	 * @param args
	 */
	
	static{
		System.out.println("static abc");
	}
	
	public TestMain2(){
		System.out.println("cons mine");
	}
	public static void main(String[] args) {
		TestMain2 tm2 = new TestMain2();
		System.gc();
		tm2.finalize();
		double dd = 3.0;
		Number nn = dd;
		System.out.println(dd);
		
	}
	
	public void abc1(){
		System.out.println("hhhh");
	}

	@Override
	public int compareTo(TestMain2 o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(TestMain2 o1, TestMain2 o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void finalize(){
		System.out.println("in destroy");
	}
}
class TestMain {

	/**
	 * @param args
	 */
//	public void abc1(){
//		
//	}
	public TestMain(){
		System.out.println("Cons paremt");
	}
	public static void abc(){
		
	}
	protected void finalize(){
		System.out.println("in destroy parent");
	}

}

