package giorgosathanasopoulos.com.github.computer_networks_aueb.network;

import com.google.gson.annotations.SerializedName;

public class Request extends Message {
    @SerializedName("Action")
    private final Action c_ACTION;

    public Request(UserAgent p_UserAgent, Action p_action) {
        super(p_UserAgent, Type.REQUEST);
        c_ACTION = p_action;
    }

    public Action getAction() {
        return c_ACTION;
    }

    public enum Action {

    }
}
