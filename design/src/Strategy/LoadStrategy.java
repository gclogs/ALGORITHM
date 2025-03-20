package Strategy;

public class LoadStrategy implements MoveableStrategy {
    @Override
    public void move() {
        System.out.println("도로를 통해 이동");
    }
}
