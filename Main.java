package transactionsystem;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Calendar date = Calendar.getInstance();
        DepositTransaction deposit = new DepositTransaction(500, date, "D001");
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(300, date, "W001");

        deposit.apply(account);
        withdrawal.apply(account);

        deposit.printTransactionDetails();
        withdrawal.printTransactionDetails();

        if (withdrawal.reverse(account)) {
            System.out.println("Withdrawal reversed.");
        }

        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
