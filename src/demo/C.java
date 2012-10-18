package demo;

public class C extends A {

	@Override
	protected void methodToExecuteWrapped() {
		System.out.println("I've been called!");
	}
}
