package ch06.add;

public class InjectException extends Exception{
	public InjectException() {
		super();
	}

	public InjectException(String message) {
		super(message);
	}

	public InjectException(String message, Throwable cause) {
		super(message, cause);
	}
}
