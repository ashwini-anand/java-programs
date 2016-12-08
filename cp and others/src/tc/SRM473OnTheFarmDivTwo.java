package tc;

import java.util.Arrays;

public class SRM473OnTheFarmDivTwo {
	public static void main(String[] args) {
		
       System.out.println(Arrays.toString(animals(10,42)));
	}
	public static int[] animals(int heads, int legs){
		int a ,b;
		a= (legs/2) - heads;
		b= heads - a;
		if(a>-1&&b>-1&&(a+b == heads)&&(4*a+2*b == legs)){
			int[] anim = {b,a};
			return anim;
		}
		int[] animnull = {};
		return animnull;
		
	}

}
