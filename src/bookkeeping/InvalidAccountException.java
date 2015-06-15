package bookkeeping;

public class InvalidAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7262828687885480805L;

	public InvalidAccountException(String error){
		super(error);
	}
}
