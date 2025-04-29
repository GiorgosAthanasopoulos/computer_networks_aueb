package giorgosathanasopoulos.com.github.computer_networks_aueb.server;

import java.io.IOException;
import java.net.Socket;

// TODO: ability to login
// TODO: ability to sign up

// TODO: ability to upload
// TODO: on upload notify uploader's followers about post

// TODO: ability to comment on a post

// TODO: save/synchronize client profile file

// TODO: ability to download

// TODO: synchronize client directories with clients

// TODO: search Photo_name: (return client ids of clients that are followed by original requesting client)

// TODO: download: can download pictures from follower's directories
// TODO: 1. search (if you find multiple images with same name return a random one)
// TODO: 2. client sends request to server for access to searched file from specific follower
// TODO: 3. 3-way handshake (client to server, server to client, client to server with Photo_name)
// TODO: 4. stop-and-wait send file to client (in 10 chopped-up pieces) (use timer for timeout)
// TODO: 5. on the 3rd stop-and-wait packet client should intently not send ack (retransmit)
// TODO: 6. on the 6th packet the client should intently delay the ack (server should handle two acks for the same packet)
// TODO: 7. after the image file use 1 packet to send accompanying text file (1 packet because the file should be small). if no accompanying text file exists send appropriate message
// TODO: 8. show "transmission completed" message on the client when the transaction is complete. also synchronize client local and remote directories (synchronization)
public class Server {

}
