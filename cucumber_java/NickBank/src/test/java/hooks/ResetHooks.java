package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nickbank.Account;
import nickbank.AccountRepository;
import nickbank.BalanceStore;
import nickbank.TransactionQueue;
import org.javalite.activejdbc.Base;

/**
 * Created by Administrator on 2016/3/26.
 */
public class ResetHooks {
    @Before(order = 1)
    public void reset(){
        AccountRepository.deleteAll();

        Account _myAccount = new Account(1234);
        AccountRepository.insert(_myAccount);

        TransactionQueue.clear();
    }

    /*@After
    public void rollback(){
        Base.rollbackTransaction();
    }*/
}
