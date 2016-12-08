package gfg;

import java.util.Scanner;
import static java.lang.Math.*;
public class Logo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			t--;
			int n = s.nextInt();
			double x =0;
			double y =0;
			double angle = 0;
			while(n>0){
				n--;
				String ss = s.next();
				double ad = s.nextDouble();
				//splitting String on space
				//String[] strarr = ss.split("\\s+");
				//System.out.println(ss);
				if(ss.equals("fd")){
					x+= ad*cos(toRadians(angle));
					y+= ad*sin(toRadians(angle));
					//System.out.println(ad*cos(toRadians(angle))+" "+x+" "+y);
				}else if(ss.equals("bk")){
					x-= ad*cos(toRadians(angle));
					y-= ad*sin(toRadians(angle));
					//System.out.println(ad*cos(toRadians(angle))+" "+x+" "+y);
				}else if(ss.equals("lt")){
					angle = (angle+ad)%360;
				}else{
					angle = (angle-ad)%360;
				}
			}
			//System.out.println(x+" "+y);
			//int res  = round(hypot(x, y));
			System.out.println(round(hypot(x, y)));
		}

	}

}
