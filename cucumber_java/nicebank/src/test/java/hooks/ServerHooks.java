package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nicebank.Account;
import nicebank.AtmServer;
import nicebank.CashSlot;
import org.springframework.beans.factory.annotation.Autowired;

public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer _server;

    @Autowired
    private Account account;
    @Autowired
    private CashSlot cashSlot;

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
