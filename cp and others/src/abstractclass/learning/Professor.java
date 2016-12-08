package abstractclass.learning;


public class Professor extends Person {
    
	public Professor(String name, String id){
		this.name =  name;
		this.id = id;
	}
	@Override
	public void doWork() {
        System.out.println("teaches");
	}

}
