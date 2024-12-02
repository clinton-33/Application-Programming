package transactionsystem;
import java.util.Calendar;
public interface TransactionInterface {
    double getAmount();
    Calendar getDate();
    String getTransactionID();
    void apply(BankAccount ba);
    void printTransactionDetails();
}
