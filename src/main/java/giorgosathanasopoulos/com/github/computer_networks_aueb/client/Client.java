package giorgosathanasopoulos.com.github.computer_networks_aueb.client;

import java.util.ArrayList;
import java.util.List;

import giorgosathanasopoulos.com.github.computer_networks_aueb.model.Profile;
import giorgosathanasopoulos.com.github.computer_networks_aueb.model.SocialGraph;
import giorgosathanasopoulos.com.github.computer_networks_aueb.uid.UID;

// TODO: create client directory (class?)
// TODO: keep client directory synchronized with the server

// TODO: access_profile following (no access to profile's dir neither locally nor remotely)
// TODO: deny_profile

// TODO: upload_and_sync: when uploading images (and/or accompanying text files)
// TODO: also create post with format: clientID posted Photo_name

// TODO: unfollow request (accepted immediately by server)
// TODO: follow (follow-back, follow, deny)
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
