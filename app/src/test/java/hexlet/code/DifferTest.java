package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;


import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {
    private static String jsonFile1;
    private static String jsonFile2;
    private static String stylishResult;
    private static String ymlFile1;
    private static String ymlFile2;
    private static String plainResult;
    private static String jsonResult;

    @BeforeAll
    public static void beforeAll() throws Exception {
        jsonFile1 = "src/test/resources/file1.json";
        jsonFile2 = "src/test/resources/file2.json";
        stylishResult = Files.readString(Paths.get("src/test/resources/stylishResult"));
        ymlFile1 = "src/test/resources/file1.yml";
        ymlFile2 = "src/test/resources/file2.yml";
        plainResult = Files.readString(Paths.get("./src/test/resources/plainResult"));
        jsonResult = Files.readString(Paths.get("./src/test/resources/jsonResult.json"));

    }
    @Test
    public void jsonTest2() throws Exception {
        String result = Differ.generate(jsonFile1, jsonFile2, "stylish");
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void ymlTest2() throws Exception {
        String result = Differ.generate(ymlFile1, ymlFile2, "stylish");
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void jsonTestPlain() throws Exception {
        String result = Differ.generate(jsonFile1, jsonFile2, "plain");
        assertThat(result).isEqualTo(plainResult);
    }
    @Test
    public void ymlTestPlain() throws Exception {
        String result = Differ.generate(ymlFile1, ymlFile2, "plain");
        assertThat(result).isEqualTo(plainResult);
    }
    @Test
    public void jsonTestDefault() throws Exception {
        String result = Differ.generate(jsonFile1, jsonFile2);
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void ymlTestDefault() throws Exception {
        String result = Differ.generate(ymlFile1, ymlFile2);
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void jsonTestJson() throws Exception {
        String result = Differ.generate(jsonFile1, jsonFile2, "json");
        Assertions.assertThat(result).isEqualTo((jsonResult));
    }
    @Test
    public void ymlTestJson() throws Exception {
        String result = Differ.generate(ymlFile1, ymlFile2, "json");
        Assertions.assertThat(result).isEqualTo(jsonResult);
    }
}


