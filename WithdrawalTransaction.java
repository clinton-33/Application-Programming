package transactionsystem;

import java.util.Calendar;

/**
 * Represents a withdrawal transaction.
 * Includes functionality to reverse a withdrawal.
 */
public class WithdrawalTransaction extends BaseTransaction {

    /**
     * Constructs a WithdrawalTransaction with the specified amount and date.
     * 
     * @param amount the amount to withdraw.
     * @param date   the date of the transaction.
     */
    public WithdrawalTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    /**
     * Applies the withdrawal transaction to the specified bank account.
     * If insufficient funds are available, an exception is thrown.
     * 
     * @param bankAccount the bank account to which the withdrawal will be applied.
     * @throws InsufficientFundsException if there are insufficient funds in the account.
     */
    @Override
    public void apply(BankAccount bankAccount) {
        try {
            if (bankAccount.getBalance() < amount) {
                throw new InsufficientFundsException("Insufficient funds for withdrawal.");
            }
            bankAccount.withdraw(amount);
            System.out.println("Withdrawal applied.");
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction completed.");
        }
    }

    /**
     * Reverses the withdrawal by depositing the withdrawn amount back into the account.
     * 
     * @param bankAccount the bank account from which the withdrawal was made.
     * @return true if the reversal was successful.
     */
    public boolean reverse(BankAccount bankAccount) {
        bankAccount.deposit(amount);
        System.out.println("Withdrawal reversed.");
        return true;
    }
}
