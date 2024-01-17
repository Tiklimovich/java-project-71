package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;

public class DifferFinder {
    public static List<Map<String, Object>> differFinder(Map<String, Object> data1,
                                                         Map<String, Object> data2, String format) throws IOException {

        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> keysFromFile = new TreeSet<String>(data1.keySet());
        keysFromFile.addAll(data2.keySet());

        for (String key : keysFromFile) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("key", key);
            if (!data2.containsKey(key)) {
                map.put("value", data1.get(key));
                map.put("status", "removed");
            } else if (!data1.containsKey(key)) {
                map.put("value", data2.get(key));
                map.put("status", "added");
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                map.put("value1", data1.get(key));
                map.put("value2", data2.get(key));
                map.put("status", "updated");

            } else {
                map.put("value", data1.get(key));
                map.put("status", "unchanged");
            }
            result.add(map);
        }
        return result;
    }
}
