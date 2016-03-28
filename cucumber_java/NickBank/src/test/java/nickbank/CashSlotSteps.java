package nickbank;

import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;

/**
 * Created by Administrator on 2016/3/19.
 */
public class CashSlotSteps {
    CashSlot cashSlot;

    public CashSlotSteps(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @那么("^ATM机应该吐出(\\d+)元$")
    public void atm机应该吐出元(int yuans) throws Throwable {
        Assert.assertEquals("不正确的账户余额 - ", yuans, cashSlot.getContents());
    }
}
