package mytwitter;

public class UJCException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UJCException(String message) {
        super(message);
    }
 
    public UJCException(Throwable t) {
        super(t);
    }
    
}
