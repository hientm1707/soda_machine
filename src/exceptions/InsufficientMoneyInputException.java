package exceptions;

public class InsufficientMoneyInputException extends RuntimeException{

    public InsufficientMoneyInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
