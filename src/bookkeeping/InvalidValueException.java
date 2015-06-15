package bookkeeping;

public class InvalidValueException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9156617314893364783L;

	public InvalidValueException(String error){
		super(error);
	}

}
