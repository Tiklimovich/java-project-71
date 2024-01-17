package hexlet.code.Formatter;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String formatPlain(List<Map<String, Object>> difference) {

        StringBuilder result = new StringBuilder();
        for (Map<String, Object> differences : difference) {
            switch (differences.get("status").toString()) {
                case "removed" -> result.append("Property ").append("'")
                        .append(differences.get("key")).append("'").append(" was removed").append("\n");
                case "added" -> result.append("Property ").append(complexValue(differences.get("key")))
                        .append(" was added with value: ")
                        .append(complexValue(differences.get("value")))
                        .append("\n");
                case "updated" -> result.append("Property ").append(complexValue(differences.get("key")))
                        .append(" was updated. From ")
                        .append(complexValue(differences.get("value1"))).append(" to ")
                        .append(complexValue(differences.get("value2")))
                        .append("\n");

                default -> result.append("");
            }
        }
        return result.toString().trim();
    }

    public static String complexValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
