import java.util.Scanner;

public class Summation {
	public static void main(String[] args) {
           Scanner s = new Scanner(System.in);
           System.out.println("Enter the first number");
           double a = s.nextDouble();
           System.out.println("Enter the second number");
           double b = s.nextDouble();
           double sum = a+b;
           System.out.println("Sum = "+ sum);
           s.close();
	}

}
