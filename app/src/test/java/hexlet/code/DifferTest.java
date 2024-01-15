package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;

public class DifferTest {
    private static final String FILE1JSON = getFilePath("file1.json").toString();
    private static final String FILE2JSON = getFilePath("file2.json").toString();
    private static final String FILE1YML = getFilePath("file1.yml").toString();
    private static final String FILE2YML = getFilePath("file2.yml").toString();
    private static String stylishResult;
    private static String plainResult;
    private static String jsonResult;
    private static Path getFilePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }
    private static String getResult(String fileName) throws IOException {
        return Files.readString(getFilePath(fileName));
    }
    @BeforeAll
    public static void beforeAll() throws Exception {
        stylishResult = getResult("stylishResult");
        plainResult = getResult("plainResult");
        jsonResult = getResult("jsonResult.json");
    }
    @Test
    public void jsonTest2() throws Exception {
        String result = Differ.generate(FILE1JSON, FILE2JSON, "stylish");
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void ymlTest2() throws Exception {
        String result = Differ.generate(FILE1YML, FILE2YML, "stylish");
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void jsonTestPlain() throws Exception {
        String result = Differ.generate(FILE1JSON, FILE2JSON, "plain");
        assertThat(result).isEqualTo(plainResult);
    }
    @Test
    public void ymlTestPlain() throws Exception {
        String result = Differ.generate(FILE1YML, FILE2YML, "plain");
        assertThat(result).isEqualTo(plainResult);
    }
    @Test
    public void jsonTestDefault() throws Exception {
        String result = Differ.generate(FILE1JSON, FILE2JSON);
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void ymlTestDefault() throws Exception {
        String result = Differ.generate(FILE1YML, FILE2YML);
        assertThat(result).isEqualTo(stylishResult);
    }
    @Test
    public void jsonTestJson() throws Exception {
        String result = Differ.generate(FILE1JSON, FILE2JSON, "json");
        JSONAssert.assertEquals(jsonResult, result, false);
    }
    @Test
    public void ymlTestJson() throws Exception {
        String result = Differ.generate(FILE1YML, FILE2YML, "json");
        JSONAssert.assertEquals(jsonResult, result, false);
    }
}


