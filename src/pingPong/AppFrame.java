package pingPong;

import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class AppFrame extends JFrame {
    public final int TILE_SIZE = 100;
    public final int ROWS = 7;
    public final int COLS = 12;
    public final int SCREEN_HEIGHT = TILE_SIZE * ROWS;
    public final int SCREEN_WIDTH = TILE_SIZE * COLS;
    private AppPanel gamePanel;
    private WelcomePanel welcomePanel;

    public AppFrame() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        ImageIcon logo = new ImageIcon(getClass().getResource("/logo.jpg"));
        this.setTitle("Ping Pong!");
        this.setIconImage(logo.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use CardLayout for switching between panels
        this.getContentPane().setLayout(new CardLayout());

        // Initialize panels
        this.gamePanel = new AppPanel();
        this.welcomePanel = new WelcomePanel(this);

        // Add panels with unique names
        this.getContentPane().add(welcomePanel, "WelcomePanel");
        this.getContentPane().add(gamePanel, "GamePanel");

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to switch to the game panel
    public void switchToGamePanel() {
        // Switch to the game panel
        ((CardLayout) this.getContentPane().getLayout()).show(this.getContentPane(), "GamePanel");

        // Request focus for the AppPanel to listen for key events
        gamePanel.requestFocusInWindow();
    }
}
