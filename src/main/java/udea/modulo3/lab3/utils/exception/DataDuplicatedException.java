package udea.modulo3.lab3.utils.exception;

public class DataDuplicatedException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataDuplicatedException(String message) {
        super(message);
    }
}
