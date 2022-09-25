package mytwitter;

public class PIException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PIException(String message) {
        super(message);
    }
 
    public PIException(Throwable t) {
        super(t);
    }
    
}
