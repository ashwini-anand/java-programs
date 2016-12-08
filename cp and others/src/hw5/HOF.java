package hw5;

import java.util.ArrayList;
import java.util.List;

public class HOF {
  public static List<Integer> map(Function F, List<Integer> list){
	 List<Integer> result = new ArrayList<Integer>();
	 for(int i: list){
		 result.add(F.doit(i));
	 }
	return result;
	  
  }
  
  public static int reduce(FuncReduce F, List<Integer> list,int j){
	     int accumulator = j;
		 for(int i: list){
			 accumulator= F.reduceit(accumulator,i);
		 }
		return accumulator;
		  
	  }
  
  public static List<Integer> filter(Func F, List<Integer> list){
		 List<Integer> result = new ArrayList<Integer>();
		 for(int i: list){
			 if(F.checkEven(i)) result.add(i);
		 }
		return result;
		  
	  }
}
