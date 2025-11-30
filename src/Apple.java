import java.util.Random;

public class Apple {
    int x;
    int y;

    Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Random random = new Random();

    public void spawnApple(int bound, int size){
        x = random.nextInt(bound / size) * size;
        y = random.nextInt(bound / size) * size;
    }
}
