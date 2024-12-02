package transactionsystem;
/*
 * Interface defining the blueprint for financial transactions.
 */
import java.util.Calendar;
public interface TransactionInterface {
    double getAmount();
    Calendar getDate();
    String getTransactionID();
    /**
     * Applies the transaction to the given bank account.
     *
     * @param BankAccount the bank account to which the transaction will be applied.
     */
    void apply(BankAccount ba);

    void printTransactionDetails();
}
