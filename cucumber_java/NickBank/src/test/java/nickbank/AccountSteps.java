package nickbank;

import cucumber.api.Transform;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import support.KnowTheDomain;
import transforms.MoneyConverter;

/**
 * Created by Administrator on 2016/3/19.
 */
public class AccountSteps {
    private KnowTheDomain _helper;

    public AccountSteps() {
        _helper = KnowTheDomain.getHelper();
    }

    @假如("^给一个账户存入(\\d+\\.\\d+)元$")
    public void 给一个账户存入元(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        _helper.getMyAccount().credit(amount);
    }

    @那么("^账户应该还有(\\d+\\.\\d+)元余额$")
    public void 账户应该还有元余额(@Transform(MoneyConverter.class) Money balance) throws Throwable {
        /*try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }*/

        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;

        while (!_helper.getMyAccount().getBalance().equals(balance)
                && timeoutMilliSecs>0){
            Thread.sleep(pollIntervalMilliSecs);

            timeoutMilliSecs-=pollIntervalMilliSecs;
        }

        Assert.assertEquals("不正确的账户余额 - ", balance, _helper.getMyAccount().getBalance());
    }
}
