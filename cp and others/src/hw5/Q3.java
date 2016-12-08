package hw5;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
  public static void main(String[] args) {
	List<Integer> olist = new ArrayList<>();
	olist.add(2);
	olist.add(3);
	olist.add(4);
	olist.add(10);
	olist.add(12);
	olist.add(15);
	olist.add(20);
	List<Integer> result = new ArrayList<>();
	System.out.println("Input List is : "+olist+"\n");
	System.out.println("map called to double the elements: ");
	result = HOF.map(new Function(){
		public int doit(int i){return 2*i;}
	}, olist);
	System.out.println("output of map : "+result);
	System.out.println("---------------------------");
	System.out.println("reduce called to get product of elements");
	int product = HOF.reduce(new FuncReduce(){
		public int reduceit(int acc,int i){return acc*i;}
	}, olist,1);
	System.out.println("output of reduce is : "+product);
	System.out.println("---------------------------");
	System.out.println("Filter called to filter out even numbers");
	result = HOF.filter(new Func(){
		public boolean checkEven(int i){return (i%2==0 ? true:false);}
	}, olist);
	System.out.println("output of filter is : "+result);
}
}
