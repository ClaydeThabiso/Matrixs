/**
 * An exception that will be thrown by the Matrix class.
 * 
 * This is a checked exception and must be handled.
 * @author Thabiso
 */
public class MatrixExceptioon extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MatrixExceptioon() {
        super();
    }
    
    public MatrixExceptioon(String message) {
        super(message);
    }
    
    public MatrixExceptioon(String message, Throwable cause) {
        super(message, cause);
    }
    
    public MatrixExceptioon(Throwable cause) {
        super(cause);
    } 
}
