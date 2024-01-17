package hexlet.code.Formatter;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> difference) {

        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> differences : difference) {
            switch (differences.get("status").toString()) {
                case "removed" -> result.append("  - ").append(differences.get("key")).append(": ")
                        .append(differences.get("value")).append("\n");
                case "added" -> result.append("  + ").append(differences.get("key")).append(": ")
                        .append(differences.get("value")).append("\n");
                case "unchanged" -> result.append("    ").append(differences.get("key")).append(": ")
                        .append(differences.get("value")).append("\n");
                default -> {
                    result.append("  - ").append(differences.get("key")).append(": ")
                            .append(differences.get("value1")).append("\n");
                    result.append("  + ").append(differences.get("key")).append(": ")
                            .append(differences.get("value2")).append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
