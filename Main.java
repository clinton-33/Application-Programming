import java.util.Calendar;
import java.util.UUID;

public interface TransactionInterface {
    double getAmount();
    Calendar getDate();
    String getTransactionID();
    void printTransactionDetails();
    void apply(BankAccount bankAccount);
}



public abstract class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    public BaseTransaction(double amount, Calendar date) {
        this.amount = amount;
        this.date = date;
        this.transactionID = UUID.randomUUID().toString();
    }

    public double getAmount() {
        return amount;
    }

    public Calendar getDate() {
        return date;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: " + amount);
    }

    public abstract void apply(BankAccount bankAccount);
}

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }
}


public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    public void apply(BankAccount bankAccount) {
        bankAccount.deposit(amount);
        System.out.println("Deposit applied.");
    }
}


public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    public void apply(BankAccount bankAccount) {
        if (bankAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        bankAccount.withdraw(amount);
        System.out.println("Withdrawal applied.");
    }

    public boolean reverse(BankAccount bankAccount) {
        bankAccount.deposit(amount);
        System.out.println("Withdrawal reversed.");
        return true;
    }
}

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 500.00);
        DepositTransaction deposit = new DepositTransaction(200.00, Calendar.getInstance());
        deposit.apply(account);
        deposit.printTransactionDetails();
        System.out.println("New balance: " + account.getBalance());

        WithdrawalTransaction withdrawal = new WithdrawalTransaction(100.00, Calendar.getInstance());
        try {
            withdrawal.apply(account);
            withdrawal.printTransactionDetails();
            System.out.println("New balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        withdrawal.reverse(account);
        System.out.println("Balance after reversal: " + account.getBalance());

        try {
            WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(1000.00, Calendar.getInstance());
            largeWithdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
