package nickbank;


/**
 * Created by Administrator on 2016/3/19.
 */
public class Account {
    private TransactionQueue queue = new TransactionQueue();

    private int number;
    private Money balance;
    public Account() {
    }

    public Account(int number)  {
        this.number = number;
        balance = new Money(0,0);
    }

    public void credit(Money amount){
        queue.write("+"+amount.toString()+","+getNumber());
    }

    public void debit(int yuans) {
        Money amount = new Money(yuans, 0);
        queue.write("-"+amount.toString()+","+getNumber());
    }

    public int getNumber() {
        return this.number;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money amount) {
        balance = amount;
    }

}
