package nickbank;

import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import support.KnowTheDomain;

/**
 * Created by Administrator on 2016/3/19.
 */
public class CashSlotSteps {
    private KnowTheDomain _helper;

    public CashSlotSteps() {
        _helper = KnowTheDomain.getHelper();
    }

    @那么("^ATM机应该吐出(\\d+)元$")
    public void atm机应该吐出元(int yuans) throws Throwable {
        Assert.assertEquals("不正确的账户余额 - ", yuans, _helper.getCashSlot().getContents());
    }
}
