package hw4;

public class Q2 {
	public static void main(String[] args) {
       Student s1 = new Student("Hari",22);
       System.out.println(s1.toString());
       
       EngineeringStudent es1 = new EngineeringStudent("Hari",22,"IT");
       System.out.println(es1.toString());
       
       Student s2 = new Student("Mohan",42);
       System.out.println(s2.toString());
       
       EngineeringStudent es2 = new EngineeringStudent("Mohan",42,"ESD");
       System.out.println(es2.toString());
	}

}
