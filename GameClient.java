import java.io.IOException;
import java.net.Socket;

public class GameClient {
    private String ipAddress;
    private int port;

    public GameClient(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public void connect() {
        try {
            Socket socket = new Socket(ipAddress, port);
            System.out.println("Connected to server at " + ipAddress + ":" + port);
            // Handle communication with the server
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
