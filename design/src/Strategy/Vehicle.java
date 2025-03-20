package Strategy;

public class Vehicle {
    MoveableStrategy moveableStrategy;

    public void move() {
        moveableStrategy.move();
    }

    public void setMoveableStrategy(MoveableStrategy moveableStrategy) {
        this.moveableStrategy = moveableStrategy;
    }
}
