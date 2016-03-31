package nickbank;

import cucumber.api.java.zh_cn.当;
import org.springframework.beans.factory.annotation.Autowired;
import support.AtmUserInterface;

/**
 * Created by Administrator on 2016/3/19.
 */
public class TellerSteps {
    @Autowired
    Account account;
    @Autowired
    Teller teller;

    /*public TellerSteps(AtmUserInterface teller) {
        this.account = AccountRepository.get(1234);
        this.teller = teller;
    }*/


    @当("^请求取现(\\d+)元$")
    public void 请求取现元(int yuans) throws Throwable {
        teller.withdrawFrom(account, yuans);
    }
}
