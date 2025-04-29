package giorgosathanasopoulos.com.github.computer_networks_aueb.json;

import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JsonUtils {
    private static final Gson c_GSON = new Gson();

    public static String toJson(Object p_obj) {
        return c_GSON.toJson(p_obj);
    }

    public static <T> Optional<T> fromJson(String p_json, Class<T> p_class) {
        try {
            return Optional.of(c_GSON.fromJson(p_json, p_class));
        } catch (JsonSyntaxException e) {
            System.err.println("JsonUtils::fromJson class=" + p_class.getClass().getName() + ", json=" + p_json);
            return Optional.empty();
        }
    }
}
