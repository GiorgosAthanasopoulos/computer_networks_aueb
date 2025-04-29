package giorgosathanasopoulos.com.github.computer_networks_aueb.network;

import com.google.gson.annotations.SerializedName;

public class Response extends Message {
    @SerializedName("Status")
    private final Status c_STATUS;
    @SerializedName("Message")
    private final String c_MESSAGE;

    public Response(UserAgent p_UserAgent, Status p_Status, String p_Message) {
        super(p_UserAgent, Type.RESPONSE);
        this.c_STATUS = p_Status;
        this.c_MESSAGE = p_Message;
    }

    public Status getStatus() {
        return c_STATUS;
    }

    public String getMessage() {
        return c_MESSAGE;
    }

    public enum Status {
        SUCCESS,
        FAILURE
    }
}
