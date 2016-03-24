package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import support.KnowTheDomain;

/**
 * Created by Administrator on 2016/3/20.
 */
public class WebDriverHooks {
    private KnowTheDomain _helper;
    public WebDriverHooks() {
        _helper = KnowTheDomain.getHelper();
    }

    @After
    public void finish(Scenario scenario){
        try {
            byte[] screenshot = _helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }catch (WebDriverException somePlatformsDontSupportScreenshots){
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        finally {
            _helper.getWebDriver().close();
        }
    }
}
