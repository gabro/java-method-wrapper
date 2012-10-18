import demo.B;
import demo.C;



public class Main {
	public static void main(String[] args) {
		
		//B is a class not implementing the method to be executed wrapped
		//The call will generate a RuntimeException
		B b = new B();
		b.methodToBeCalled();
		
		System.out.println();
		
		//C is a class implementing the method to be executed wrapped
		//The call will execute just fine and wrapped between a preamble and a prologue
		C c = new C();
		c.methodToBeCalled();
	}
}
