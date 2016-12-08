class check{
	int a;
	int b;
	String c;
	public check(){
		System.out.println("Nothing");
	}
}


public class DefaultConstructor {
	public static void main(String[] args) {
       check cc=new check();
       System.out.println(cc.a+" "+cc.b+" "+cc.c);
	}

}
