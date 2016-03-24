package nickbank;

/**
 * Created by Administrator on 2016/3/19.
 */
public class Account {
    private Money _balance = new Money(0, 0);

    public Account() {
    }

    public void credit(Money amount){
        _balance=_balance.add(amount);
    }

    public Money getBalance() {
        return _balance;
    }

    public void debit(int yuans) {
        _balance = _balance.minus(new Money(yuans, 0));
    }
}
