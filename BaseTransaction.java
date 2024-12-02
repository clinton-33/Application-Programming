package transactionsystem;

import java.util.Calendar;
/**
 * Abstract base class representing a financial transaction.
 * Implements shared properties and methods for all transactions.
 */

public abstract class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() { return amount; }

    @Override
    public Calendar getDate() { return date; }

    @Override
    public String getTransactionID() { return transactionID; }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: " + amount);
    }

    @Override
    public abstract void apply(BankAccount ba);
}
