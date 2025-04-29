package giorgosathanasopoulos.com.github.computer_networks_aueb.network;

import giorgosathanasopoulos.com.github.computer_networks_aueb.uid.UID;
import giorgosathanasopoulos.com.github.computer_networks_aueb.json.JsonUtils;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("UserAgent")
    private final UserAgent c_USER_AGENT;
    @SerializedName("ID")
    private final int c_ID;
    @SerializedName("Type")
    private final Type c_TYPE;

    private final transient String c_SRC;

    public Message(UserAgent p_userAgent, Type p_type) {
        c_USER_AGENT = p_userAgent;
        c_ID = UID.getNextUID();
        c_TYPE = p_type;
        c_SRC = JsonUtils.toJson(this);
    }

    public UserAgent getUserAgent() {
        return c_USER_AGENT;
    }

    public int getID() {
        return c_ID;
    }

    public Type getType() {
        return c_TYPE;
    }

    public String getSrc() {
        return c_SRC;
    }

    public enum UserAgent {
        CLIENT,
        SERVER
    }

    public enum Type {
        REQUEST,
        RESPONSE
    }
}
