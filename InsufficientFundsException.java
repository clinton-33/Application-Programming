package transactionsystem;

/**
 * Custom exception class for insufficient funds in a bank account.
 */
public class InsufficientFundsException extends RuntimeException {

    /**
     * Constructs an InsufficientFundsException with the specified error message.
     * 
     * @param message the detail message for the exception.
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
