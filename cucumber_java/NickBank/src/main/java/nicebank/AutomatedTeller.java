package nicebank;

public class AutomatedTeller {

    public static void withdrawFrom(CashSlot cashSlot, Account myAccount, int yuans) {
        // TODO: 这里要考虑一个事务的问题
        cashSlot.dispense(yuans);
        myAccount.debit(yuans);
    }
}
