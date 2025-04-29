package giorgosathanasopoulos.com.github.computer_networks_aueb.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

import giorgosathanasopoulos.com.github.computer_networks_aueb.json.JsonUtils;
import giorgosathanasopoulos.com.github.computer_networks_aueb.network.Message;
import giorgosathanasopoulos.com.github.computer_networks_aueb.network.Response;

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
    private ServerSocket m_server;

    public NetworkServer() {
        bindSocket();
        listenForClients();
    }

    private void bindSocket() {
        try {
            m_server = new ServerSocket(NetworkServerConfig.c_SERVER_PORT, NetworkServerConfig.c_SERVER_BACKLOG);
        } catch (IOException e) {
            System.err.println("NetworkServer::bindSocket failed to bind socket: " + e.getMessage());
            System.exit(1);
        }
    }

    private void listenForClients() {
        while (!m_server.isClosed()) {
            try {
                Socket client = m_server.accept();
                new Thread(() -> handleClient(client)).start();
            } catch (IOException e) {
                System.err.println("NetworkServer::listenForClients failed to accept client: " + e.getMessage());
                continue;
            }
        }
    }

    private void handleClient(Socket p_client) {
        if (p_client == null || p_client.isClosed()) {
            System.err.println("NetworkServer::handleClient called with invalid client");
            return;
        }

        Scanner scanner;
        try {
            scanner = new Scanner(p_client.getInputStream());
        } catch (IOException e) {
            System.err.println(
                    "NetworkServer::handleClient failed to create scanner for client input steam: " + e.getMessage());
            return;
        }

        while (!p_client.isClosed()) {
            if (!scanner.hasNextLine())
                continue;

            String message = scanner.nextLine();
            new Thread(() -> handleMessage(p_client, message)).start();
        }

        scanner.close();
    }

    // TODO: fill out optional.of returns
    private Optional<Response> handleMessage(Socket p_client, String p_message) {
        if (p_client == null || p_client.isClosed()) {
            System.err.println("NetworkServer::handleMessage received message from invalid client");
            return Optional.empty(); // cannot send response back
        }
        if (p_message == null || p_message.isBlank()) {
            System.err.println(
                    "NetworkServer::handleMessage received empty message from: " + p_client.getRemoteSocketAddress());
            return Optional.of(new Response(Message.UserAgent.SERVER, Response.Status.FAILURE, "Invalid message"));
        }

        Optional<Message> messageOptional = JsonUtils.fromJson(p_message, Message.class);
        if (messageOptional.isEmpty()) {
            System.err.println("NetworkServer::handleMessage invalid message json: " + p_message);
            return Optional
                    .of(new Response(Message.UserAgent.SERVER, Response.Status.FAILURE, "Invalid message json format"));
        }
        Message message = messageOptional.get();

        switch (message.getType()) {
            case REQUEST -> {
                return handleRequest(p_client, message);
            }
            case RESPONSE -> {
                return handleResponse(p_client, message);
            }
        }

        return Optional.of(new Response(Message.UserAgent.SERVER, Response.Status.FAILURE,
                "Invalid message"));
    }

    private Optional<Response> handleRequest(Socket client, Message message) {
        if (client == null || client.isClosed()) {
            System.err.println("NetworkServer::handleRequest received request from invalid client");
            return Optional.empty(); // cannot send response back
        }
        if (message == null) {
            System.err.println("NetworkServer::handleRequest received null message from: "
                    + client.getRemoteSocketAddress());
            return Optional.of(new Response(Message.UserAgent.SERVER, Response.Status.FAILURE, "Invalid message"));
        }

        return Optional.of(new Response(Message.UserAgent.SERVER, Response.Status.FAILURE,
                "Invalid message"));
    }

    private Optional<Response> handleResponse(Socket client, Message message) {
        if (client == null || client.isClosed()) {
            System.err.println("NetworkServer::handleResponse received response from invalid client");
            return Optional.empty(); // cannot send response back
        }
        if (message == null) {
            System.err.println("NetworkServer::handleResponse received null message from: "
                    + client.getRemoteSocketAddress());
            return Optional.of(new Response(Message.UserAgent.SERVER, Response.Status.FAILURE, "Invalid message"));
        }

        return Optional.of(new Response(Message.UserAgent.SERVER, Response.Status.FAILURE,
                "Invalid message"));
    }
}
