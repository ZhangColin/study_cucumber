package nickbank;

import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import support.TestCashSlot;

public class CashSlotSteps {
    @Autowired
    TestCashSlot cashSlot;

    @那么("^ATM机应该吐出(\\d+)元$")
    public void atm机应该吐出元(int yuans) throws Throwable {
        Assert.assertEquals("不正确的账户余额 - ", yuans, cashSlot.getContents());
    }

    @假如("^ATM机有一个开发引起的错误$")
    public void atm机有一个开发引起的错误() throws Throwable {
        cashSlot.inijectFault();
    }
}
