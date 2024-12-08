package pingPong;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WelcomePanel extends JPanel implements ActionListener {

    private JButton startButton;
    private AppFrame appFrame;

    public WelcomePanel(AppFrame appFrame) {
        this.appFrame = appFrame;
        this.setPreferredSize(new Dimension(appFrame.SCREEN_WIDTH, appFrame.SCREEN_HEIGHT));

        startButton = new JButton("Start Game");
        startButton.setBounds(appFrame.SCREEN_WIDTH / 2 - 75, appFrame.SCREEN_HEIGHT / 2 - 25, 150, 50);
        startButton.addActionListener(this);

        this.setLayout(null); // Allow absolute positioning for the button
        this.add(startButton);
        startButton.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            appFrame.switchToGamePanel(); // Switch to the game panel
        }
    }
}
