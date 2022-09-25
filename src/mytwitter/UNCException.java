package mytwitter;

public class UNCException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UNCException(String message) {
        super(message);
    }
 
    public UNCException(Throwable t) {
        super(t);
    }
	
}
