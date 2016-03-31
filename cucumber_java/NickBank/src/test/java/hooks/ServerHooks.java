package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nickbank.Account;
import nickbank.AccountRepository;
import nickbank.AtmServer;
import nickbank.CashSlot;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/3/20.
 */
public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer _server;

    @Autowired
    private Account account;
    @Autowired
    private CashSlot cashSlot;

    /*public ServerHooks( CashSlot cashSlot) {
        this.account = AccountRepository.get(1234);
        this.cashSlot = cashSlot;
    }*/

    @Before
    public void startServer() throws Exception {
        _server = new AtmServer(PORT, cashSlot, account);
        _server.start();
    }

    @After
    public void stopServer() throws Exception{
        _server.stop();
    }
}
