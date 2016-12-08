package hw4;

public abstract class Compiler {
   final void scan(){
	   System.out.println("In scan method: Its final method in Compiler class");
   }
   final void typecheck(){
	   System.out.println("In typecheck method: Its final method in Compiler class");
   }
   
   abstract void parse();
   abstract void generateCode();
}
