import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameServer {
    private int port;
    private List<Socket> clients;

    public GameServer(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (clients.size() < 2) {
                System.out.println("Waiting for clients to connect...");
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("Client connected: " + clientSocket.getInetAddress());
            }

            System.out.println("Both clients connected. Starting the game...");
            notifyClientsToStartGame();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void notifyClientsToStartGame() {
        try {
            for (Socket client : clients) {
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                out.writeObject("START_GAME");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter server port: ");
        int port = scanner.nextInt();

        GameServer server = new GameServer(port);
        server.start();

        scanner.close();
    }
}
