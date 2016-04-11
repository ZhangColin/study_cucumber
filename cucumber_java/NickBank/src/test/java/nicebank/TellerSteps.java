package nicebank;

import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import support.AtmInterface;

public class TellerSteps {
    @Autowired
    Account account;
    @Autowired
    AtmInterface teller;


    @当("^取(\\d+)元$")
    public void 取元(int yuans) throws Throwable {
        teller.withdrawFrom(account, yuans);
    }

    @当("^取一些钱$")
    public void 取一些钱() throws Throwable {
        int dollarsRequested = 10;
        teller.withdrawFrom(account, dollarsRequested);
    }

    @当("^输入(\\d+)元$")
    public void 输入元(int amount) throws Throwable {
        teller.type(amount);
    }

    @那么("^将看到一条出故障的消息$")public void 将看到一条出故障的消息() throws Throwable {
        Assert.assertTrue("Expected error message not displayed", teller.isDisplaying("Out of order"));
    }

    @那么("^将看到一条机器现金不足的消息$")
    public void 将看到一条机器现金不足的消息() throws Throwable {
        Assert.assertTrue("Expected error message not displayed", teller.isDisplaying("Insufficient ATM funds"));
    }
}
