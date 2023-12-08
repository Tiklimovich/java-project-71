package hexlet.code;

import hexlet.code.Formatter.Stylish;
import hexlet.code.Formatter.Plain;

import java.util.List;
import java.io.IOException;
import java.util.Map;

public class Format {
    public static String formatStyle(List<Map<String, Object>> difference, String format) throws IOException {
        switch (format) {
            case "stylish":
                return Stylish.formatStylish(difference);
            case "plain":
                return Plain.formatPlain(difference);
            default:
                throw new Error("Unknown format: " + format);

        }
    }
}

