package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String content, String dataFormat) throws Exception {
        return switch (dataFormat) {
            case "json" -> getDataJson(content);
            case "yml", "yaml" -> getDataYaml(content);
            default -> throw new IOException("Unknown file extension! -> " + dataFormat);
        };
    }

    private static Map<String, Object> getDataJson(String content) throws IOException {
        ObjectMapper jsonMapper = new JsonMapper();
        return jsonMapper.readValue(content, new TypeReference<>() {
        });
    }

    private static Map<String, Object> getDataYaml(String content) throws IOException {
        ObjectMapper ymlMapper = new YAMLMapper();
        return ymlMapper.readValue(content, new TypeReference<>() {
        });
    }
}

