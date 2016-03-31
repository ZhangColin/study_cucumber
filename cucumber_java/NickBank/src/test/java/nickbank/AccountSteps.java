package nickbank;

import cucumber.api.Transform;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import transforms.MoneyConverter;

/**
 * Created by Administrator on 2016/3/19.
 */
public class AccountSteps {
    @Autowired
    Account account;

    /*public AccountSteps() {

    }*/

    @假如("^给一个账户存入(\\d+\\.\\d+)元$")
    public void 给一个账户存入元(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        //this.account = AccountRepository.get(1234);
        account.credit(amount);
    }

    @那么("^账户应该还有(\\d+\\.\\d+)元余额$")
    public void 账户应该还有元余额(@Transform(MoneyConverter.class) Money balance) throws Throwable {
        this.account = AccountRepository.get(1234);

        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;

        while (!account.getBalance().equals(balance)
                && timeoutMilliSecs>0){
            Thread.sleep(pollIntervalMilliSecs);

            timeoutMilliSecs-=pollIntervalMilliSecs;
        }

        Assert.assertEquals("不正确的账户余额 - ", balance, account.getBalance());
    }
}
