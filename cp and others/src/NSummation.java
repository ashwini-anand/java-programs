import java.util.Scanner;

public class NSummation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        System.out.println("Enter the number 'n'");
        int n = s.nextInt();
        int sum=0;
        if(n <= 0){
        	System.out.println("Please enter number greater than 0");
        	System.exit(0);
        }
        for (int i = 1; i <= n; i++) {
			sum += i;
		}
        System.out.println("The sum of first "+n+" numbers is "+sum);
	}

}
