import java.util.Scanner;

public class AgeVerification {
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
         System.out.println("Enter your age");
         double age = s.nextDouble();
         if(age > 18){
        	 System.out.println("Adult age");
         }else{
        	 System.out.println("Child");
         }
	}

}
