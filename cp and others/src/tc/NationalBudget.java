package tc;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NationalBudget {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] csts = {"$100,000,000,000.00","-$10,000.00"};
//		double dd = 1000000000000000000d;
//		System.out.println(dd);
		tally(csts);
	}
	
	public static String tally(String[] costs){
	    double[] digits = new double[costs.length];
		for (int i = 0; i < costs.length; i++) {
			costs[i] = costs[i].replace(",", "").replace("$", "");
		}
		for (int i = 0; i < costs.length; i++) {
			digits[i] = Double.parseDouble(costs[i]);
		//	System.out.println(digits[i]);
		}
		
		double sum =0;
		for (int i = 0; i < digits.length; i++) {
			sum += digits[i];
		}
		
		System.out.println(sum);
		
		String ssum = String.valueOf(sum);
		
		//System.out.println(ssum);
		
		int m1 = 0;
		int n1 =0;
		
		int idxdec = ssum.indexOf(".");
		int length= ssum.length();
		System.out.println(idxdec+" "+length);
		if(length-idxdec-1 == 1) ssum = ssum+"0"; 
		System.out.println(ssum);
		//if(((sum < 0 ) && (idxdec >= 6 )) || ((sum >= 0 ) && (idxdec >= 5 ))){
//			StringBuilder sb = new StringBuilder();
//			if(sum <0) {
//				m1 = idxdec-1;
//				n1 = 1;
//			}else{
//				m1 = idxdec;
//				n1=0;
//			}
//			sb.append(ssum.substring(n1,(m1%3)+n1));
//			sb.append(",");
//			System.out.println(sb);
//			for (int i = m1%3; i < digits.length; i++) {
//				
//			}
		    Locale us = new Locale("en","US");
			NumberFormat formatter = NumberFormat.getCurrencyInstance(us);
			//Currency currency = Currency.getInstance(" ");
			//formatter.setCurrency(currency);
			
			String moneyString = formatter.format(sum);
			System.out.println(moneyString);
	//	}
		
		return moneyString;
		
	}

}
