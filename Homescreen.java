import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Homescreen extends JFrame {
    public Homescreen() {
        setTitle("Game Launcher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the frame
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to fullscreen
        setUndecorated(true);
        setVisible(true);
        setResizable(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));

        // Create icons for games
        ImageIcon game1Icon = new ImageIcon("snakegame.png"); // Replace with actual icon file path
        JButton game1Button = new JButton( game1Icon);
        game1Button.setBackground(Color.RED);
        game1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Game 1
                openGame("snake game.jar"); // Replace with the actual executable file of Game 1
            }
        });
        panel.add(game1Button);

        ImageIcon game2Icon = new ImageIcon("ponggame.png"); // Replace with actual icon file path
        JButton game2Button = new JButton(game2Icon);
        game2Button.setBackground(Color.WHITE);
        game2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Game 2
                openGame("pong.jar"); // Replace with the actual executable file of Game 2
            }
        });
        panel.add(game2Button);

        ImageIcon game3Icon = new ImageIcon("TicTacToeGame.png"); // Replace with actual icon file path
        JButton game3Button = new JButton( game3Icon);
        game3Button.setBackground(Color.ORANGE);
        game3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open Game 3
                openGame("TicTacToe.jar"); // Replace with the actual executable file of Game 3
            }
        });
        panel.add(game3Button);

        add(panel);
        setVisible(true);
        game1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        game2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        game3Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ((JComponent) getContentPane()).registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.NORMAL);
                System.exit(0);
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        setVisible(true);
    
    }

    // Method to open a game based on its name
    private void openGame(String gameExecutable) {
        try {
            File file = new File(gameExecutable);
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Homescreen();
            }
        });
    }
}
