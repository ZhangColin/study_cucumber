package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nickbank.BalanceStore;
import nickbank.TransactionQueue;
import org.javalite.activejdbc.Base;

/**
 * Created by Administrator on 2016/3/26.
 */
public class ResetHooks {
    @Before
    public void reset(){
        TransactionQueue.clear();
    }

    /*@After
    public void rollback(){
        Base.rollbackTransaction();
    }*/
}
