package Strategy;

public class ClientStrategy {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        train.setMoveableStrategy(new RailLoadStrategy());
        bus.setMoveableStrategy(new LoadStrategy());

        train.move();
        bus.move();
    }
}
