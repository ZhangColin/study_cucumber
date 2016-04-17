package nicebank;

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

        // TODO: 避免队列而添加的
        AccountRepository.update(account);
    }

    @假如("^有一个账户$")
    public void 有一个账户() throws Throwable {
        originalBalance = new Money(30, 0);
        account.credit(originalBalance);

        // TODO: 避免队列而添加的
        AccountRepository.update(account);
    }

    @那么("^账户余额还剩(\\d+\\.\\d+)元$")
    public void 账户余额还剩(@Transform(MoneyConverter.class) Money balance) throws Throwable {
        checkBalanceIs(balance);
    }

    @那么("^账户余额不变$")
    public void 账户余额不变() throws Throwable {
        checkBalanceIs(originalBalance);
    }

    private void checkBalanceIs(Money amount) throws InterruptedException {
        this.account = AccountRepository.get(1234);

        int timeoutMilliSecs = 6000;
        int pollIntervalMilliSecs = 100;

        while (!account.getBalance().equals(amount)
                && timeoutMilliSecs>0){
            Thread.sleep(pollIntervalMilliSecs);

            timeoutMilliSecs-=pollIntervalMilliSecs;
        }

        Assert.assertEquals("账户余额不正确 - ", amount, account.getBalance());
    }
}
