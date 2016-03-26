package hooks;

import cucumber.api.java.Before;
import nickbank.BalanceStore;
import nickbank.TransactionQueue;

/**
 * Created by Administrator on 2016/3/26.
 */
public class ResetHooks {
    @Before
    public void reset(){
        TransactionQueue.clear();
        BalanceStore.clear();
    }
}
