import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Administrator on 2016/3/19.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty", "html:out"}, snippets= SnippetType.CAMELCASE)
public class RunCukesTest {
}
