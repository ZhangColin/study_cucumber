package nickbank;

import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import support.AtmUserInterface;

public class TellerSteps {
    @Autowired
    Account account;
    @Autowired
    AtmUserInterface teller;


    @当("^请求取现(\\d+)元$")
    public void 请求取现元(int yuans) throws Throwable {
        teller.withdrawFrom(account, yuans);
    }

    @当("^请求取一些钱$")
    public void 请求取一些钱() throws Throwable {
        int dollarsRequested = 10;
        teller.withdrawFrom(account, dollarsRequested);
    }

    @那么("^将看到一条出故障的消息$")public void 将看到一条出故障的消息() throws Throwable {
        Assert.assertTrue("Expected error message not displayed", teller.isDisplaying("Out of order"));
    }
}
