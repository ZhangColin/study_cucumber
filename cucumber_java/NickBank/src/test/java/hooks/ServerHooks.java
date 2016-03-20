package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import nickbank.AtmServer;
import support.KnowTheDomain;

/**
 * Created by Administrator on 2016/3/20.
 */
public class ServerHooks {
    public static final int PORT = 8887;

    private AtmServer _server;
    private KnowTheDomain _helper;

    @Before
    public void startServer() throws Exception {
        _helper = KnowTheDomain.getHelper();
        _server = new AtmServer(PORT, _helper.getCashSlot(), _helper.getMyAccount());
        _server.start();
    }

    @After
    public void stopServer() throws Exception{
        _server.stop();
    }
}
