package mytwitter;

public class PDException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PDException(String message) {
        super(message);
    }
 
    public PDException(Throwable t) {
        super(t);
    }
	
}
