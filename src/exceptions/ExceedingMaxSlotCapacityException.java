package exceptions;

public class ExceedingMaxSlotCapacityException extends RuntimeException {
    public ExceedingMaxSlotCapacityException(String message) {
        super(message);
    }
}
