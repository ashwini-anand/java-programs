package hw5;

public class Sample {
	
	public static void sum(){
		int x = 10;
		int y = 20;
		int sum = 0;
		int[] a = new int[5];
		try{
		    x = a[5];
			throw new ArithmeticException("Sum");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException caught");
		}catch(ArithmeticException e){
			System.out.println("Arithmetic Exception caught");
		}catch(Exception e){
			System.out.println("Exception caught");
		}finally{
			System.out.println("Finally called");
		}
	}
	
	public static void main(String[] args) {

	}

}
