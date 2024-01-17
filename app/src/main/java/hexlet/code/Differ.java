package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String dataContent1 = getData(filePath1);
        String dataContent2 = getData(filePath2);

        Map<String, Object> map1 = Parser.parser(dataContent1, getExtension(filePath1));
        Map<String, Object> map2 = Parser.parser(dataContent2, getExtension(filePath2));

        List<Map<String, Object>> result = DifferFinder.differFinder(map1, map2, format);

        return Format.formatStyle(result, format).trim();
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    private static Path getAbsolutePath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    private static String getData(String filePath) throws Exception {
        return Files.readString(getAbsolutePath(filePath));
    }

    private static String getExtension(String filePath) {
        return filePath.substring(filePath.lastIndexOf(".") + 1);
    }
}
