package support;


import hooks.ServerHooks;
import nickbank.Account;
import nickbank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/3/20.
 */
public class AtmUserInterface implements Teller {
    @Autowired
    private EventFiringWebDriver _webDriver;

    /*public AtmUserInterface(MyWebDriver _webDriver) {
        this._webDriver = _webDriver;
    }*/

    public void withdrawFrom(Account myAccount, int yuans) {
        //try{
            _webDriver.get("http://localhost:"+ ServerHooks.PORT);
            _webDriver.findElement(By.id("amount"))
                    .sendKeys(String.valueOf(yuans));
            _webDriver.findElement(By.id("withdraw")).click();
        /*}
        finally {
            _webDriver.close();
        }*/
    }
}
