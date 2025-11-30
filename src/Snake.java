import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Snake implements Moveable {
    int unitSize;
    int direction;
    int screenWidth;
    int screenHeight;

    LinkedList<Point> tail = new LinkedList<>();

    public Snake(int x, int y, int unitSize, int screenWidth, int screenHeight){
        this.unitSize = unitSize;
        this.direction = KeyEvent.VK_RIGHT;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        tail.add(new Point(x, y));
    }

    public int getHeadX() { return tail.getFirst().x; }
    public int getHeadY() { return tail.getFirst().y; }

    public void grow() {
        tail.add(new Point(tail.getLast()));
    }

    @Override
    public void move() {
        Point head = tail.getFirst();
        int newX = head.x;
        int newY = head.y;

        switch(direction) {
            case KeyEvent.VK_LEFT -> newX -= unitSize;
            case KeyEvent.VK_RIGHT -> newX += unitSize;
            case KeyEvent.VK_UP -> newY -= unitSize;
            case KeyEvent.VK_DOWN -> newY += unitSize;
        }

        if (newX < 0) newX = screenWidth - unitSize;
        if (newX >= screenWidth) newX = 0;
        if (newY < 0) newY = screenHeight - unitSize;
        if (newY >= screenHeight) newY = 0;

        tail.addFirst(new Point(newX, newY));
        tail.removeLast();

        for (int i = 1; i < tail.size(); i++) {
            if (tail.get(i).equals(tail.getFirst())) {
                throw new RuntimeException("GAME OVER!");
            }
        }
    }
}
