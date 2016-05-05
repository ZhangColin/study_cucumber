package fruit;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.owlike.genson.ext.jaxrs.GensonJsonConverter;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.glassfish.jersey.client.ClientResponse;
import org.junit.Assert;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;
import java.net.HttpURLConnection;
import java.net.URI;


public class RestSteps {
    private ClientResponse response;
    private Fruit[] fruits;

    @当("^客户端使用Get请求 /fruits$")
    public void 客户端使用get请求_fruits() throws Throwable {
        try {
            URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(baseUri);

            fruits = target.path("/fruit/fruits").request()
                    .accept("application/json").get(Fruit[].class);
            /*response = target.path("/fruit/fruits").request()
                    .accept("application/json").get(ClientResponse.class);*/
            //WebResource webResource = client.resource("http://localhost:" + ServerHooks.PORT + "/fruits");

            //response = webResource.type("application/json")
                    //.get(ClientResponse.class);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            System.out.print("Exception caught");
            e.printStackTrace();
        }

        /*Assert.assertEquals("Did not receive OK response: ",
                HttpURLConnection.HTTP_OK, response.getStatus());*/
        Assert.assertEquals(2, fruits.length);
    }

    @那么("^输出如下JSON：$")
    public void 输出如下json(String jsonExpected) throws Throwable {
        JsonParser parser = new JsonParser();
        Gson gson = new Gson();
        Assert.assertEquals("Unexpected JSON.",
                parser.parse(jsonExpected), parser.parse(gson.toJson(fruits)));
    }
}
