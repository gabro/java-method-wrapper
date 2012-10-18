package demo;
import java.util.concurrent.Callable;

import wrapper.MethodNotImplementedException;
import wrapper.Wrapper;

public class A {

	/**
	 * This is the method exposed to be called from outside
	 */
	public void methodToBeCalled() {
		// Wrap the call passing three Callable objects, respectively
		// the method to be wrapped, the preamble and the prologue.
		Wrapper.wrap(new Callable<Void>() {
	        public Void call() {
	            methodToExecuteWrapped();
	            return null;
	        }
	    },
	    new Callable<Void>() {
	    	public Void call() {
	    		System.out.println("Before!");
				return null;
	    	}
	    },
	    new Callable<Void>() {
	    	public Void call() {
	    		System.out.println("After!");
				return null;
	    	}
	    });
	}
	
	public void anotherMethodToBeCalled() {
		// Wrap the call passing three Callable objects, respectively
		// the method to be wrapped, the preamble and the prologue.
		Wrapper.wrap(new Callable<Void>() {
	        public Void call() {
	            methodToExecuteWrapped();
	            return null;
	        }
	    },
	    new Callable<Void>() {
	    	public Void call() {
	    		System.out.println("Before!");
				return null;
	    	}
	    },
	    new Callable<Void>() {
	    	public Void call() {
	    		System.out.println("After!");
				return null;
	    	}
	    });
	}
	
	/**
	 * This is the method that will be wrapped
	 * The standard implementation will throw a RuntimeException,
	 * since this is supposed to be implemented by the subclasses
	 */
	protected void methodToExecuteWrapped() {
		throw new MethodNotImplementedException();
	}
}
