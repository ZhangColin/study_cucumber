package fruit;

import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import hooks.ServerHooks;
import org.junit.Assert;

import java.net.HttpURLConnection;


public class RestSteps {
    private ClientResponse response;

    @当("^客户端使用Get请求 /fruits$")
    public void 客户端使用get请求_fruits() throws Throwable {
        try {
            Client client = Client.create();

            WebResource webResource = client.resource("http://localhost:" + ServerHooks.PORT + "/fruits");

            response = webResource.type("application/json")
                    .get(ClientResponse.class);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            System.out.print("Exception caught");
            e.printStackTrace();
        }

        Assert.assertEquals("Did not receive OK response: ",
                HttpURLConnection.HTTP_OK, response.getStatus());
    }

    @那么("^输出如下JSON：$")
    public void 输出如下json(String jsonExpected) throws Throwable {
        JsonParser parser = new JsonParser();

        Assert.assertEquals("Unexpected JSON.",
                parser.parse(jsonExpected), parser.parse(response.getEntity(String.class)));
    }
}
