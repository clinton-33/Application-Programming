package transactionsystem;

import java.util.Calendar;

/**
 * Interface defining the blueprint for financial transactions.
 */
public interface TransactionInterface {
    /**
     * Gets the amount of the transaction.
     * 
     * @return the transaction amount as a double.
     */
    double getAmount();

    /**
     * Gets the date of the transaction.
     * 
     * @return the transaction date as a Calendar object.
     */
    Calendar getDate();

    /**
     * Gets the unique identifier of the transaction.
     * 
     * @return the transaction ID as a String.
     */
    String getTransactionID();

    /**
     * Prints the transaction details.
     */
    void printTransactionDetails();

    /**
     * Applies the transaction to the given bank account.
     * 
     * @param bankAccount the bank account to which the transaction will be applied.
     */
    void apply(BankAccount bankAccount);
}
