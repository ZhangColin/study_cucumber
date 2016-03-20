package nickbank;

/**
 * Created by Administrator on 2016/3/19.
 */
public class Teller {
    private CashSlot cashSlot;

    public Teller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account myAccount, int yuans) {
        myAccount.debit(yuans);
        cashSlot.dispense(yuans);
    }
}
