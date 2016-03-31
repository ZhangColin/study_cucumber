package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringKeyboard;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/3/20.
 */
public class WebDriverHooks {
    @Autowired
    private EventFiringWebDriver webDriver;

    /*public WebDriverHooks(MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }*/

    @After
    public void finish(Scenario scenario){
        try {
            byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }catch (WebDriverException somePlatformsDontSupportScreenshots){
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            webDriver.close();
        }
    }
}
