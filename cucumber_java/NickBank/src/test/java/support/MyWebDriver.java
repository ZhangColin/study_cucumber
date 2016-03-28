package support;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Administrator on 2016/3/29.
 */
public class MyWebDriver extends EventFiringWebDriver {
    public MyWebDriver() {
        super(new FirefoxDriver());
    }
}
