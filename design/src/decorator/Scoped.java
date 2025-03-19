package decorator;

// 스코프
public class Scoped extends WeaponAccessory{
    public Scoped(Weapon rifle) {
        super(rifle);
    }

    public void aim() {
        actionAim();
        super.aim();
    }

    public void actionAim() {
        System.out.println("에임 조준중..");
    }
}
