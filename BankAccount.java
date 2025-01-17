package transactionsystem;
/**
 * Represents a bank account with basic deposit and withdrawal operations.
 */
public class BankAccount {
    private String accountNumber; // Unique account number
    private double balance; // Current account balance

    /**
     * Constructs a BankAccount with the specified account number and initial balance.
     * 
     * @param accountNumber the unique identifier for the bank account.
     * @param balance       the initial balance of the account.
     */
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Gets the account number.
     * 
     * @return the account number as a String.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance.
     * 
     * @return the balance as a double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Deposits the specified amount into the account.
     * 
     * @param amount the amount to deposit.
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * Withdraws the specified amount from the account.
     * 
     * @param amount the amount to withdraw.
     */
    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
