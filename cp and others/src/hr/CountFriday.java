package hr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CountFriday {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		while(t>0){
			t--;
			int d1 = s.nextInt();
			int m1 = s.nextInt();
			int y1 = s.nextInt();
			int d2 = s.nextInt();
			int m2 = s.nextInt();
			int y2 = s.nextInt();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c=Calendar.getInstance();
			int day = -1;
			int count =0;
			
			if(y1==y2){
				if(m1==m2){
					if(d1<=13 && d2>=13){
						String str = "13/"+m1+"/"+y1; 
						Date dt = sdf.parse(str);
						c.setTime(dt);
						day = c.get(Calendar.DAY_OF_WEEK);
						if(day == 6){
							//System.out.println("here1");
							count++;
						}
					
					}
				}else{
					if(d1<=13 ){
						String str = "13/"+m1+"/"+y1; 
						Date dt = sdf.parse(str);
						c.setTime(dt);
						day = c.get(Calendar.DAY_OF_WEEK);
						if(day == 6){
							//System.out.println("here1");
							count++;
						}
					}
					
					for (int i = m1+1; i < m2; i++) {
						String str = "13/"+i+"/"+y1; 
						Date dt = sdf.parse(str);
						c.setTime(dt);
						day = c.get(Calendar.DAY_OF_WEEK);
						if(day == 6){
							//System.out.println("here2");
							count++;
						}
					}
					
					if(d2>=13){
						String str = "13/"+m2+"/"+y2; 
						Date dt = sdf.parse(str);
						c.setTime(dt);
						day = c.get(Calendar.DAY_OF_WEEK);
						if(day == 6){
							//System.out.println("here5");
							count++;
						}
					}
				}
			}
			else{
			if(d1<=13 ){
				String str = "13/"+m1+"/"+y1; 
				Date dt = sdf.parse(str);
				c.setTime(dt);
				day = c.get(Calendar.DAY_OF_WEEK);
				if(day == 6){
					//System.out.println("here1");
					count++;
				}
			}
			
			for (int i = m1+1; i <= 12; i++) {
				String str = "13/"+i+"/"+y1; 
				Date dt = sdf.parse(str);
				c.setTime(dt);
				day = c.get(Calendar.DAY_OF_WEEK);
				if(day == 6){
					//System.out.println("here2");
					count++;
				}
			}
			
			for (int i = y1+1; i < y2; i++) {
				for(int j =1; j<=12;j++){
					String str = "13/"+j+"/"+i; 
					Date dt = sdf.parse(str);
					c.setTime(dt);
					day = c.get(Calendar.DAY_OF_WEEK);
					if(day == 6){
					//	System.out.println("here3");
						count++;
					}
				
				}
			}
			
			for (int i = 1; i < m2; i++) {
				String str = "13/"+i+"/"+y2; 
				Date dt = sdf.parse(str);
				c.setTime(dt);
				day = c.get(Calendar.DAY_OF_WEEK);
				if(day == 6){
				//	System.out.println("here4");
					count++;
				}
			
			}
			
			if(d2>=13){
				String str = "13/"+m2+"/"+y2; 
				Date dt = sdf.parse(str);
				c.setTime(dt);
				day = c.get(Calendar.DAY_OF_WEEK);
				if(day == 6){
				//	System.out.println("here5");
					count++;
				}
			}
		}	
			System.out.println(count);
		}
		
	}

}
