package Strategy;

public class RailLoadStrategy implements MoveableStrategy{
    @Override
    public void move() {
        System.out.println("선로를 통해 이동");
    }
}
