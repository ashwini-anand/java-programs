package uva.string;

import java.util.Scanner;

public class BigNumberOfTeamsWillSolveThis {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        int k =1;
        while(k<= t){
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            //System.out.println(s1+" "+s2);
            System.out.print("Case "+k+": ");
            if(s1.equals(s2)){
                System.out.println("Yes");
            }else{
                s1 = s1.replaceAll("\\s+", "");
                s2 = s2.replaceAll("\\s+", "");
                //System.out.println(s1+" "+s2);
                if(s1.equals(s2)){
                    System.out.println("Output Format Error");
                }else{
                    System.out.println("Wrong Answer");
                }    
            }
            k++;
        }
    }

}