package giorgosathanasopoulos.com.github.computer_networks_aueb.model;

import java.util.Set;
import java.util.HashSet;

public class SocialGraph {
    private final Set<Integer> c_members;

    public SocialGraph() {
        c_members = new HashSet<>();
    }

    /**
     * @return false is p_is is already member
     */
    public boolean addMember(int p_id) {
        if (isMember(p_id)) return false;

        c_members.add(p_id);
        return true;
    }

    public boolean removeMember(int p_id) {
        return c_members.remove((Object) p_id);
    }

    public boolean isMember(int p_id) {
        return c_members.contains(p_id);
    }
}
