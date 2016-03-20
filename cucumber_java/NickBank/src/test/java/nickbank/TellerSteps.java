package nickbank;

import cucumber.api.java.zh_cn.当;
import support.KnowTheDomain;

/**
 * Created by Administrator on 2016/3/19.
 */
public class TellerSteps {
    private KnowTheDomain _helper;

    public TellerSteps() {
        _helper = KnowTheDomain.getHelper();
    }

    @当("^请求取现(\\d+)元$")
    public void 请求取现元(int yuans) throws Throwable {
        _helper.getTeller().withdrawFrom(_helper.getMyAccount(), yuans);
    }
}
