/**
 * Exception thrown when there are insufficient funds for a withdrawal.
 */
package transactionsystem;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
