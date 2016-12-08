package abstractclass.learning;

public class Main {

	public static void main(String[] args) {
         Professor pf = new Professor("Ktaz", "001");
         Student st= new Student("Petr", "Mt2016201");
         System.out.println("Professor ");
         System.out.println("Name : " + pf.getName()+"    ID : "+pf.getId());
         System.out.print(pf.getName()+" ");
         pf.doWork();
         System.out.println("----------------");
         System.out.println("Student");
         System.out.println("Name : " + st.getName()+"    ID : "+st.getId());
         System.out.print(st.getName()+" ");
         st.doWork();
         
	}

}
