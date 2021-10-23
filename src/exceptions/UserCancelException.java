package exceptions;

public class UserCancelException extends RuntimeException {
    public UserCancelException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
