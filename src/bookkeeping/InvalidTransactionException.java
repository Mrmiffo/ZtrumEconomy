package bookkeeping;

public class InvalidTransactionException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8020378261188536809L;

	public InvalidTransactionException(String error){
		super(error);
	}
}
