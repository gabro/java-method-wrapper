package wrapper;

public class MethodNotImplementedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public MethodNotImplementedException(String string) {
		super(string);
	}

	public MethodNotImplementedException() {
		this(getMethodName(0) + " is not implemented!");
	}

	@SuppressWarnings("unused")
	private static final int CLIENT_CODE_STACK_INDEX;
	static {
		// Finds out the index of "this code" in the returned stack trace - funny but it differs in JDK 1.5 and 1.6
		int i = 0;
		for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
			i++;
			if (ste.getClassName().equals(MethodNotImplementedException.class.getName())) {
				break;
			}
		}
		CLIENT_CODE_STACK_INDEX = i;
	}

	/**
	 * Get the method name for a depth in call stack.
	 * Utility function
	 * WARNING: JDK 1.6 specific!
	 * @param depth depth in the call stack (0 means current method, 1 means call method, ...)
	 * @return method name
	 */
	private static String getMethodName(final int depth) {
		final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		return ste[ste.length - CLIENT_CODE_STACK_INDEX - depth].getMethodName();
	}
}