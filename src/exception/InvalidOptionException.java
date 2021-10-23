package exception;

public class InvalidOptionException extends RuntimeException{

    public InvalidOptionException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
