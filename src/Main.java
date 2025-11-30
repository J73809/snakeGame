import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jframe = new JFrame("Snake game");

            jframe.add(new GamePanel());
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jframe.setResizable(false);
            jframe.pack();
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
        });
    }
}
