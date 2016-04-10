package nickbank;

import cucumber.api.Transform;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import transforms.MoneyConverter;

public class AccountSteps {
    @Autowired
    Account account;

    private Money originalBalance;

    @假如("^给一个账户存入(\\d+\\.\\d+)元$")
    public void 给一个账户存入元(@Transform(MoneyConverter.class)Money amount) throws Throwable {
        account.credit(amount);
    }

    @假如("^有一个账户$")
    public void 有一个账户() throws Throwable {
        originalBalance = new Money(30, 0);
        account.credit(originalBalance);
    }

    @那么("^账户应该还有(\\d+\\.\\d+)元余额$")
    public void 账户应该还有元余额(@Transform(MoneyConverter.class) Money balance) throws Throwable {
        checkBalanceIs(balance);
    }

    @那么("^账户余额应该没有产生变化$")
    public void 账户余额应该没有产生变化() throws Throwable {
        checkBalanceIs(originalBalance);
    }

    private void checkBalanceIs(Money amount) throws InterruptedException {
        this.account = AccountRepository.get(1234);

        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;

        while (!account.getBalance().equals(amount)
                && timeoutMilliSecs>0){
            Thread.sleep(pollIntervalMilliSecs);

            timeoutMilliSecs-=pollIntervalMilliSecs;
        }

        Assert.assertEquals("不正确的账户余额 - ", amount, account.getBalance());
    }
}
