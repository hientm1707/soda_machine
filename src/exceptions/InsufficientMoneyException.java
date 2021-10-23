package exceptions;

public class InsufficientMoneyException extends RuntimeException{

    public InsufficientMoneyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
