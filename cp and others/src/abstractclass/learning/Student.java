package abstractclass.learning;


public class Student extends Person {

	public Student(String name, String id){
		this.name =  name;
		this.id = id;
	}
	@Override
	public void doWork() {

		System.out.println("studies");
	}

}
