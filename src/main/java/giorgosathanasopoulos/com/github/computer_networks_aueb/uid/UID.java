package giorgosathanasopoulos.com.github.computer_networks_aueb.uid;

public class UID {
    private static int s_uid = 0;

    public static int getNextUID() {
        return s_uid++;
    }
}
