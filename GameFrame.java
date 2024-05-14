import javax.swing.*;

public class GameFrame {
    
    public static void setupGUI() {
        JFrame window = new JFrame("First Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(new GameCanvas());
        window.pack();
        window.setLocationRelativeTo(null); // Center the frame on the screen
        window.setVisible(true);
    }

}
