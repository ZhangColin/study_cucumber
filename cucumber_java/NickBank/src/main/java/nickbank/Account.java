package nickbank;


/**
 * Created by Administrator on 2016/3/19.
 */
public class Account {
    private TransactionQueue queue = new TransactionQueue();

    public Account() {
    }

    public void credit(Money amount){
        queue.write("+"+amount.toString());
    }

    public Money getBalance() {
        return BalanceStore.getBalance();
    }

    public void debit(int yuans) {
        Money amount = new Money(yuans, 0);
        queue.write("-"+amount.toString());
    }
}
