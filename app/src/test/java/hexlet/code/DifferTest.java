package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DifferTest {
    private static String defaultFormat;
    private static String jsonFile1;
    private static String jsonFile2;
    private static String jsonResult;
    private static String ymlFile1;
    private static String ymlFile2;
    private static String ymlResult;
    private static String jsonFile3;
    private static String jsonFile4;
    private static String jsonResult2;
    private static String ymlFile3;
    private static String ymlFile4;
    private static String ymlResult2;
    private static String plainResult;
    private static String formatJsonResult;

    @BeforeAll
    public static void beforeAll() throws Exception {
        defaultFormat = "stylish";
        jsonFile1 = "src/test/resources/file1.json";
        jsonFile2 = "src/test/resources/file2.json";
        jsonResult = Files.readString(Paths.get("src/test/resources/jsonResult"));
        ymlFile1 = "src/test/resources/file1.yml";
        ymlFile2 = "src/test/resources/file2.yml";
        ymlResult = Files.readString(Paths.get("src/test/resources/ymlResult"));
        jsonFile3 = "src/test/resources/file3.json";
        jsonFile4 = "src/test/resources/file4.json";
        jsonResult2 = Files.readString(Paths.get("src/test/resources/jsonResult2"));
        ymlFile3 = "src/test/resources/file3.yml";
        ymlFile4 = "src/test/resources/file4.yml";
        ymlResult2 = Files.readString(Paths.get("src/test/resources/ymlResult2"));
        plainResult = Files.readString(Paths.get("./src/test/resources/plainResult"));
        formatJsonResult = Files.readString(Paths.get("./src/test/resources/formatJsonResult"));

    }
    @Test
    public void jsonTest() throws Exception {
        String result = Differ.generate(jsonFile1, jsonFile2, "stylish");
        assertThat(result).isEqualTo(jsonResult);
    }
    @Test
    public void ymlTest() throws Exception {
        String result = Differ.generate(ymlFile1, ymlFile2, "stylish");
        assertThat(result).isEqualTo(ymlResult);
    }
    @Test
    public void jsonTest2() throws Exception {
        String result = Differ.generate(jsonFile3, jsonFile4, "stylish");
        assertThat(result).isEqualTo(jsonResult2);
    }
    @Test
    public void ymlTest2() throws Exception {
        String result = Differ.generate(ymlFile3, ymlFile4, "stylish");
        assertThat(result).isEqualTo(ymlResult2);
    }
    @Test
    public void jsonTestPlain() throws Exception {
        String result = Differ.generate(jsonFile3, jsonFile4, "plain");
        assertThat(result).isEqualTo(plainResult);
    }
    @Test
    public void ymlTestPlain() throws Exception {
        String result = Differ.generate(ymlFile3, ymlFile4, "plain");
        assertThat(result).isEqualTo(plainResult);
    }
    @Test
    public void jsonTestDefault() throws Exception {
        String result = Differ.generate(jsonFile3, jsonFile4, defaultFormat);
        assertThat(result).isEqualTo(jsonResult2);
    }
    @Test
    public void ymlTestDefault() throws Exception {
        String result = Differ.generate(ymlFile3, ymlFile4, defaultFormat);
        assertThat(result).isEqualTo(ymlResult2);
    }
    @Test
    public void jsonTestJson() throws Exception {
        String result = Differ.generate(jsonFile3, jsonFile4, "json");
        assertThat(result).isEqualTo(formatJsonResult);
    }
    @Test
    public void ymlTestJson() throws Exception {
        String result = Differ.generate(ymlFile3, ymlFile4, "json");
        assertThat(result).isEqualTo(formatJsonResult);
    }
}


