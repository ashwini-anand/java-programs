import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
	   if(age<=60){
		this.age = age;
	   }else{
		System.out.println("age can not be more tha 60");
	}
	}
	
}

class MtechClass{
	public List<Student> sList = new ArrayList<Student>();
	public String name;
	public void add(Student st){
		if(sList.size() > 10){
			System.out.println("Can not add more than 10 students");
			System.exit(0);
		}else{
			sList.add(st);
		}
	}
	
}
public class MtClass {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of classes\n");
        int numOfClasses = s.nextInt();
        s.nextLine();
        List<MtechClass> mclass = new ArrayList<MtechClass>();
        for (int i = 0; i < numOfClasses; i++) {
        	MtechClass mm = new MtechClass();
           	System.out.println("Enter the name of class\n");
        	String className = s.nextLine();
        	mm.name = className;
        	mclass.add(mm);
			int numOfStudents = 0;
			do{
				System.out.println("Enter number of students\n");
			    numOfStudents = s.nextInt();
			    s.nextLine();
			    if(numOfStudents > 10){
				System.out.println("Number of student can nt be more than 10\n");
			    }
			}while(numOfStudents>10);
			for (int j = 0; j < numOfStudents; j++) {
				Student ss = new Student();
				System.out.println("Enter the name of the student\n");
				String name = s.nextLine();
				ss.setName(name);
				int age = 0;
				do{
					System.out.println("Enter the age of the student\n");
					age=s.nextInt();
				    s.nextLine();
				    if(age > 60){
				    	System.out.println("Age can not be more than 60");
				    }
				}while(age > 60);    
				ss.setAge(age);
				mclass.get(i).add(ss);
			}
		}
        s.close();
        System.out.println("Your entered class and students in the class are as below\n");
        for (int i = 0; i < mclass.size(); i++) {
        	System.out.println("Name of class is :"+mclass.get(i).name +"\n");
        	for (int j = 0; j < mclass.get(i).sList.size(); j++) {
				System.out.println("Name of student "+mclass.get(i).sList.get(j).getName()+"\n");
				System.out.println("Age of student "+mclass.get(i).sList.get(j).getAge()+"\n");
			}
        	System.out.println("-----------------------------");
			
		}
	}

}
