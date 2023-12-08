package hexlet.code.Formatter;

import java.util.Map;
import java.util.List;

public class Stylish {
    public static String formatStylish(List<Map<String, Object>> difference) {

        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> differences : difference) {
            switch (differences.get("status").toString()) {
                case "removed" -> result.append("  - ").append(differences.get("key")).append(": ")
                        .append(differences.get("oldValue")).append("\n");
                case "added" -> result.append("  + ").append(differences.get("key")).append(": ")
                        .append(differences.get("newValue")).append("\n");
                case "unchanged" -> result.append("    ").append(differences.get("key")).append(": ")
                        .append(differences.get("oldValue")).append("\n");
                default -> {
                    result.append("  - ").append(differences.get("key")).append(": ")
                            .append(differences.get("oldValue")).append("\n");
                    result.append("  + ").append(differences.get("key")).append(": ")
                            .append(differences.get("newValue")).append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
