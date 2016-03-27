package nickbank;


import org.javalite.activejdbc.Model;

/**
 * Created by Administrator on 2016/3/19.
 */
public class Account extends Model {
    private TransactionQueue queue = new TransactionQueue();

    public Account() {
    }

    public Account(int number){
        setInteger("number", number);
        setString("balance", "0.00");
    }

    public void credit(Money amount){
        queue.write("+"+amount.toString()+","+getNumber());
    }

    public void debit(int yuans) {
        Money amount = new Money(yuans, 0);
        queue.write("-"+amount.toString()+","+getNumber());
    }

    public int getNumber() {
        return getInteger("number");
    }

    public Money getBalance() {
        refresh();
        return new Money(getString("balance"));
    }

    public void setBalance(Money amount){
        setString("balance", amount.toString().substring(1));
        saveIt();
    }
}
