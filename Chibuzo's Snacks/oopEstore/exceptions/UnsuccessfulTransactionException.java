package oopEstore.exceptions;

public class UnsuccessfulTransactionException extends RuntimeException {
    public UnsuccessfulTransactionException(String message) {
        super(message);
    }
}
