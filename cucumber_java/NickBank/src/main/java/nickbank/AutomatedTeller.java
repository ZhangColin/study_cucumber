package nickbank;

/**
 * Created by Administrator on 2016/3/19.
 */
public class AutomatedTeller implements Teller {
    private CashSlot cashSlot;

    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(Account myAccount, int yuans) {
        myAccount.debit(yuans);
        cashSlot.dispense(yuans);
    }
}
