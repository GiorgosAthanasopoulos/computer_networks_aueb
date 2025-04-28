package giorgosathanasopoulos.com.github.computer_networks_aueb.server;

import java.net.Socket;

// TODO: multithreaded - should server multiple clients at once

// TODO: store map of IP:PORT->clientID

// TODO: when client connects send "welcome client clientID" message

// TODO: upload/download

// TODO: client local and remote directory synchronization

// TODO: search

// TODO: send image to client

// NOTE: important java classes
// ● java.net.ServerSocket
// ● java.net.Socket
// ● java.io.DataInputStream
// ● java.io.DataOutputStream
// ● java.io.File
// ● java.io.FileInputStream
// ● java.io.FileOutputStream
// ● java.io.ObjectInputStream
// ● java.io.ObjectOutputStream
// ● javax.imageio.ImageIO
// ● java.util.concurrent.ConcurrentHashMap<K, V>
public class NetworkServer {
    private Socket m_socket;
}
