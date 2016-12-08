package gfg;
import java.util.Scanner;

public class ReadBadInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		//String line;
		while(s.hasNextLine()){
			String line = s.nextLine();				
			//if(line.equals("")) break;
			System.out.println(line);
		}
		//System.out.println("ABC");
	}
}
