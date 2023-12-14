package hexlet.code.Formatter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;
import java.util.List;

public class Json {
    public static String formatJson(List<Map<String, Object>> difference) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(difference).trim();
    }
}
