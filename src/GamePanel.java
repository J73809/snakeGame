import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    static final int UNIT_SIZE = 50;
    static int SCORE = 0;

    Timer timer;
    Random random;
    Snake snake;
    Apple apple;

    public GamePanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(this);

        random = new Random();

        timer = new Timer(95, this);
        timer.start();

        snake = new Snake(50, 50, UNIT_SIZE, WIDTH, HEIGHT);
        apple = new Apple(250, 250);

        this.requestFocusInWindow(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillRect(apple.x, apple.y, UNIT_SIZE, UNIT_SIZE);

        g.setColor(Color.green);
        for (Point s : snake.tail){
            g.fillRect(s.x, s.y, UNIT_SIZE, UNIT_SIZE);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Score: " + SCORE, 20, 40);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        if (snake.getHeadX() == apple.x && snake.getHeadY() == apple.y) {
            SCORE++;
            snake.grow();
            apple.spawnApple(WIDTH, UNIT_SIZE);
        }
        repaint();
    }

    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && snake.direction != KeyEvent.VK_RIGHT) {
            snake.direction = KeyEvent.VK_LEFT;
        } else if (key == KeyEvent.VK_RIGHT && snake.direction != KeyEvent.VK_LEFT) {
            snake.direction = KeyEvent.VK_RIGHT;
        } else if (key == KeyEvent.VK_UP && snake.direction != KeyEvent.VK_DOWN) {
            snake.direction = KeyEvent.VK_UP;
        } else if (key == KeyEvent.VK_DOWN && snake.direction != KeyEvent.VK_UP) {
            snake.direction = KeyEvent.VK_DOWN;
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
}
