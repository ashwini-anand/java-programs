import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
        Year year = new Year();
        String[] stmonths = {"January",
							"February",
							"March",
							"April",
							"May",
							"June",
							"July",
							"August",
							"September",
							"October",
							"November",
							"December"};
       int[] numOfDaysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};
       year.setName(args[0]);
//       Scanner s = new Scanner(System.in);
//       year.setName(s.nextLine());
       for (int i = 0; i < numOfDaysInMonths.length; i++) {
    	   year.months[i] = new Month();
		   year.months[i].setName(stmonths[i]);
		   year.months[i].setNumofDays(numOfDaysInMonths[i]);
	}
     int yearName = Integer.parseInt(year.getName());
     if(yearName%4==0){
	       if((yearName%100!=0) || (yearName%100==0 && yearName%400==0) ){
	    	 year.months[1].setNumofDays(29);
    	 }
     }
     int firstday = firstDayOfYear(yearName);
    // System.out.println(firstday);
     for (int i = 0; i < year.months.length; i++) {
		System.out.println("\n\n \t\t"+year.months[i].getName()+" "+year.getName());
		System.out.println("S\tM\tTu\tW\tTh\tF\tS");
		for (int j = 0; j < (firstday); j++) {
			System.out.print("\t");
		}
		for (int k = 1; k <= year.months[i].getNumofDays(); k++) {
			//System.out.print(String.format("%d", k));
			System.out.print(k);
			if((firstday+k)%7 > 0){
				System.out.print("\t");
			}else{
				System.out.println();
			}
		}
		firstday = (year.months[i].getNumofDays() + firstday) % 7;
	}
     System.out.println();
	}
	
	public static int firstDayOfYear(int yearName){
		int daycode;
		int d1, d2, d3;
		d1 = (yearName - 1)/ 4;
		d2 = (yearName - 1)/ 100;
		d3 = (yearName - 1)/ 400;
		daycode = (yearName + d1 - d2 + d3) %7;
		return daycode;
		
	}
	

}
