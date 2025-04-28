package giorgosathanasopoulos.com.github.computer_networks_aueb.model;

import java.util.ArrayList;
import java.util.List;

import giorgosathanasopoulos.com.github.computer_networks_aueb.uid.UID;

public class Client {
    private final int c_ID;

    private final SocialGraph c_followers;
    private final SocialGraph c_following;
    private final SocialGraph c_pending;

    private final Profile c_profile;

    private final List<Profile> c_others;

    public Client() {
        c_ID = UID.getNextUID();
        c_followers = new SocialGraph();
        c_following = new SocialGraph();
        c_pending = new SocialGraph();
        c_profile = new Profile(true);
        c_others = new ArrayList<>();
    }

    public int getID() {
        return c_ID;
    }
}
