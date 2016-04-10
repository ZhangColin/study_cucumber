package hooks;

import cucumber.api.java.Before;
import nickbank.Account;
import nickbank.AccountRepository;
import nickbank.TransactionQueue;
import support.AtmInterfaceFactory;

public class ResetHooks {
    @Before(order = 1)
    public void reset(){
        AccountRepository.deleteAll();

        Account _myAccount = new Account(1234);
        AccountRepository.insert(_myAccount);

        TransactionQueue.clear();

        AtmInterfaceFactory.reset();
    }
}
