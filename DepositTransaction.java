package transactionsystem;

import java.util.Calendar;

/**
 * Represents a deposit transaction.
 */
public class DepositTransaction extends BaseTransaction {

    /**
     * Constructs a DepositTransaction with the specified amount and date.
     * 
     * @param amount the amount to deposit.
     * @param date   the date of the transaction.
     */
    public DepositTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    /**
     * Applies the deposit transaction to the specified bank account.
     * 
     * @param bankAccount the bank account to which the deposit will be applied.
     */
    @Override
    public void apply(BankAccount bankAccount) {
        bankAccount.deposit(amount);
        System.out.println("Deposit applied.");
    }
}


