package transactionsystem;

import java.util.Calendar;
import java.util.UUID;

/**
 * Abstract base class representing a financial transaction.
 * Implements shared properties and methods for all transactions.
 */
public abstract class BaseTransaction implements TransactionInterface {
    protected double amount; // The transaction amount
    protected Calendar date; // The transaction date
    protected String transactionID; // Unique identifier for the transaction

    /**
     * Constructs a BaseTransaction with the specified amount and date.
     * 
     * @param amount the amount involved in the transaction.
     * @param date   the date of the transaction.
     */
    public BaseTransaction(double amount, Calendar date) {
        this.amount = amount;
        this.date = date;
        this.transactionID = UUID.randomUUID().toString();
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: " + amount);
    }

    /**
     * Abstract method to apply the transaction to a bank account.
     * Implementation provided by subclasses.
     * 
     * @param bankAccount the bank account to which the transaction will be applied.
     */
    @Override
    public abstract void apply(BankAccount bankAccount);
}
