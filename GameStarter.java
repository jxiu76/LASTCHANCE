import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class GameStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter server IP address: ");
        String serverAddress = scanner.next();
        System.out.print("Enter server port: ");
        int port = scanner.nextInt();

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server. Waiting for the game to start...");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            String message = (String) in.readObject();

            if ("START_GAME".equals(message)) {
                System.out.println("Game is starting...");
                SwingUtilities.invokeLater(GameFrame::setupGUI);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
