package tc;

import java.util.HashSet;
import java.util.Set;

public class ChildlessNumbers {
	public static void main(String[] args) {
		int a=275;
	    int b=300;
        System.out.println(howMany(a,b));
	}
	public static int getDigitSum(int num){
		return num==0 ? 0 : num%10 + getDigitSum(num/10);
	}
	
	public static int howMany(int A, int B){
		int count = 0;
		for (int i = A; i <=B; i++) {
			boolean isChildless = true;
			int digitSum = 0;
			Set<Integer> sumSet  = new HashSet<Integer>();
			int idx= 2;
			while(isChildless){
				digitSum = i * idx;
				//do{
					digitSum = getDigitSum(digitSum);
				//}while(digitSum >= 10);
//				if(sumSet.contains(digitSum)){
//					count++;
//					System.out.println(i);
//					break;
//				}
				if(idx == 100){
					count++;
					System.out.println(i);
					break;
				}
				sumSet.add(digitSum);
				if((i*idx)/digitSum == i){
					isChildless = false;
				}
				idx++;
				
			}
		}
		return count;
		
	}
}
