package hooks;


import cucumber.api.java.Before;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResetHooks {
    @Before(order=1)
    public void deleteFruitFile() throws IOException {
        Path path = FileSystems.getDefault().getPath("fruit.json");
        Files.deleteIfExists(path);
    }
}
