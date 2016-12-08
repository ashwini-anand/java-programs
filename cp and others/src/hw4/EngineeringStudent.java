package hw4;

public class EngineeringStudent extends Student{
    String branch;
    public EngineeringStudent(){}
	public EngineeringStudent(String n,int a,String b) {
		super(n, a);
		branch =b;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String toString(){
		return "Engineering "+super.toString()+" and branch "+this.branch;
	}

}
