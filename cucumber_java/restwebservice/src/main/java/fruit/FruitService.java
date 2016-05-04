package fruit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

@Path("/fruit")
public class FruitService {
    @GET
    @Path("/fruits")
    @Produces(MediaType.APPLICATION_JSON)
    public Fruit[] getAllFruits(){
        List<Fruit> fruits = getFruitsFromFile();
        return fruits.toArray(new Fruit[]{});
    }

    private List<Fruit> getFruitsFromFile(){
        String fruitJson = readJsonFruitFile();
        return buildListFromJson(fruitJson);
    }

    private List<Fruit> buildListFromJson(String fruitJson) {
        final TypeToken<List<Fruit>> token = new TypeToken<List<Fruit>>(){};
        final Type type = token.getType();
        final Gson gson = new Gson();

        return gson.fromJson(fruitJson, type);
    }

    private String readJsonFruitFile() {
        java.nio.file.Path path = FileSystems.getDefault().getPath("fruit.json");
        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            return "[]";
        }
    }
}
