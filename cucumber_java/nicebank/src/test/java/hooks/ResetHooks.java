package hooks;

import cucumber.api.java.Before;
import nicebank.Account;
import nicebank.AccountRepository;
import nicebank.TransactionQueue;
import support.AtmInterfaceFactory;

public class ResetHooks {
    @Before(order = 1)
    public void reset(){
        //TransactionQueue.clear();
        AccountRepository.deleteAll();

        Account _myAccount = new Account(1234);
        AccountRepository.insert(_myAccount);


        AtmInterfaceFactory.reset();
    }
}
