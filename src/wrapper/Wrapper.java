package wrapper;

import java.util.concurrent.Callable;

public class Wrapper {	
	/**
	 * This will call the method wrapping it with a preamble and a prologue
	 * @param method the method to be executed
	 * @param preamble the preamble or null
	 * @param prologue the prologue or null
	 */
	public static void wrap(Callable<Void> method, Callable<Void> preamble, Callable<Void> prologue) {
		try {
			if (null != preamble) preamble.call();
			method.call();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != prologue) prologue.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
