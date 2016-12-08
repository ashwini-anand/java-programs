package Misc;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Grand{
	int gg;
	Grand(){
		
	}
	 Grand(int i){
		gg = i;
	}
	void func1(){
		System.out.println("grand");
	}
}

class Dad extends Grand{
//	Dad(int i) {
//		super(i);
//		// TODO Auto-generated constructor stub
//	}

	void func2(){
		System.out.println("dad");
	}
}

class Test extends Dad{
	
	int age;
	String name;
	
	public Test(){
		
	}
	
	public Test(int a, String n){
		//super(a);
		this.age = a;
		this.name = n;
	}
	
//	public int compareTo(Test tt){
//		return this.age - tt.age;
//	}
	
	void func1(){
		//super.func2();
		//super.func1();
		System.out.println("test");
	}
	
	static class comp1 implements Comparator<Test>{
		public int compare(Test t1, Test t2){
			return t1.age - t2.age;
		}
	}
	
	static class comp2 implements Comparator<Test>{
		public int compare(Test t1, Test t2){
			return t1.name.compareTo(t2.name);
		}
	}
	
	public static void main(String[] args){
		Test[] tarr = new Test[3];
		tarr[0] = new Test(12,"abc");
		tarr[1] = new Test(23,"abc1");
		tarr[2] = new Test(15,"abc2");
//		Arrays.sort(tarr, new Comparator<Test>(){
//			
//			public int compare(Test o1, Test o2) {
////				Test t1 = (Test)o1;
////				Test t2 = (Test)o2;
//				return o1.age - o2.age;
//			}
//		});
		Arrays.sort(tarr,new comp1());
		
		for(Test te: tarr){
			System.out.println(te.name);
		}
		
		Arrays.sort(tarr,new comp2());
		
		for(Test te: tarr){
			System.out.println(te.name);
		}
		Dad d = new Dad();
		//d.f
		Grand g1 = new Grand();
		g1.func1();
		Grand g2 = new Test();
		g2.func1();
	}
	
}	
	
