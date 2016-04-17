package fruit;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;

/**
 * Created by Administrator on 2016/4/17.
 */
public class FruitSteps {
    @假如("^系统中有以下水果：$")
    public void 系统中有以下水果(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @当("^客户端使用Get请求 /fruits$")
    public void 客户端使用get请求_fruits() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @那么("^输出如下JSON：$")
    public void 输出如下json(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
