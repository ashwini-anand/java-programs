package hw4;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursiveDescentARMCompiler rda = new RecursiveDescentARMCompiler();
		rda.scan();
		rda.typecheck();
		rda.parse();
		rda.generateCode();
		System.out.println("--------------------------------");
		
		LALRX86Compiler lxc = new LALRX86Compiler();
		lxc.scan();
		lxc.typecheck();
		lxc.parse();
		lxc.generateCode();

	}

}
