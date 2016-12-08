import java.util.Arrays;

public class PrettyPrintArray {
	public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(arr).replace('[','{').replace(']', '}'));
	}

}
