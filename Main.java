package transactionsystem;

import java.util.Calendar;

/**
 * Main class to demonstrate the functionality of the transaction system.
 */
public class Main {
    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount("123456789", 500.00);

        // Test deposit transaction
        DepositTransaction deposit = new DepositTransaction(200.00, Calendar.getInstance());
        deposit.apply(account);
        deposit.printTransactionDetails();
        System.out.println("New balance: " + account.getBalance());

        // Test withdrawal transaction with insufficient funds
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(1000.00, Calendar.getInstance());
        System.out.println("Attempting large withdrawal:");
        largeWithdrawal.apply(account);

        // Test valid withdrawal transaction
        WithdrawalTransaction smallWithdrawal = new WithdrawalTransaction(100.00, Calendar.getInstance());
        System.out.println("Attempting small withdrawal:");
        smallWithdrawal.apply(account);
        smallWithdrawal.printTransactionDetails();
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}
