package exception;

public class NotEnoughMoneyException extends RuntimeException{

    public NotEnoughMoneyException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
