package tc;
public class ABBA {

  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canObtain("B","ABBA"));

	}
	
	public static String reverse(String s){
		return new StringBuilder(s).reverse().toString();
	}
	
	public static String canObtain(String initial, String target){
		String a[][] = new String[1002][9999];
		int count = 0,k=0,j=0;
		int tleng = target.length();
		int ileng = initial.length();
		a[ileng][0] = initial;
		while(ileng <=tleng){
			ileng++;
			count =1;
			k=0;
			for(int i=0;i<count;i++){
				a[ileng][k] =  a[ileng][count]+'A';
				k++;
				a[ileng][k]=reverse(a[ileng][count])+'B';
				count = 2*count;
				k++;
			}
			
			
		}
		for(int i=0;i<count;i++){
			if(a[ileng][i].equalsIgnoreCase(target)) return "Possible";
		}
		return "Impossible";
	}

}
