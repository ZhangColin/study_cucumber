package nicebank;

public class AutomatedTeller {

    public static void withdrawFrom(CashSlot cashSlot, Account account, int yuans) {
        // TODO: 这里要考虑一个事务的问题
        cashSlot.dispense(yuans);
        account.debit(yuans);

        // TODO: 避免队列而添加的
        AccountRepository.update(account);
    }
}
