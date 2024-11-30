package transactionsystem;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private boolean reversed = false;

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) {
        try {
            if (ba.getBalance() < amount) {
                throw new InsufficientFundsException("Insufficient funds for this withdrawal.");
            }
            ba.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean reverse(BankAccount ba) {
        if (!reversed) {
            ba.deposit(amount);
            reversed = true;
            return true;
        }
        return false;
    }
}
