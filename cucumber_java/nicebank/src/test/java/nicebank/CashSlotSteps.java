package nicebank;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import support.TestCashSlot;

public class CashSlotSteps {
    @Autowired
    TestCashSlot cashSlot;

    @那么("^取钞口送出(\\d+)元$")
    public void 取钞口送出元(int yuans) throws Throwable {
        Assert.assertEquals("不正确的账户余额 - ", yuans, cashSlot.getContents());
    }

    @假如("^取钞口有一个技术故障$")
    public void 取钞口有一个技术故障() throws Throwable {
        cashSlot.inijectFault();
    }

    @假如("^ATM机里只有(\\d+)元$")
    public void atm机里只有元(int yuans) throws Throwable {
        cashSlot.load(yuans);
    }
}
