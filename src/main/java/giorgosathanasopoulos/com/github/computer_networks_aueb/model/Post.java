package giorgosathanasopoulos.com.github.computer_networks_aueb.model;

import java.util.HashMap;
import java.util.Map;

// TODO: ability to post comments
public class Post {
    private final String c_TOPIC;

    private final Map<Integer, String> c_comments;

    public Post(String p_Topic) {
        c_TOPIC = p_Topic;
        c_comments = new HashMap<>();
    }

    public String getTopic() {
        return c_TOPIC;
    }
}
