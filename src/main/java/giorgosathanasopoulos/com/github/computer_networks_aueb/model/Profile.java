package giorgosathanasopoulos.com.github.computer_networks_aueb.model;

import java.util.ArrayList;
import java.util.List;

// TODO: ability to post
// TODO: naming "Profile_XclientID"
// TODO: this should be saved as a file
// TODO: the file should be synchronized
public class Profile {
    private final boolean c_personal;

    private final List<Post> c_posts;

    public Profile(boolean p_personal) {
        this.c_personal = p_personal;
        c_posts = new ArrayList<>();
    }
}
