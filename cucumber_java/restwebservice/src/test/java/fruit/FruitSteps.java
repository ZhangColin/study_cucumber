package fruit;

import com.google.gson.Gson;
import cucumber.api.java.zh_cn.假如;

import java.io.PrintWriter;
import java.util.List;

public class FruitSteps {

    @假如("^系统中有以下水果：$")
    public void 系统中有以下水果(List<Fruit> fruits) throws Throwable {
        Gson gson = new Gson();
        PrintWriter writer = new PrintWriter("fruit.json", "UTF-8");
        writer.print(gson.toJson(fruits));
        writer.close();
    }
}
