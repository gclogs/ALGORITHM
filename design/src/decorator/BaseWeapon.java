package decorator;

public class BaseWeapon implements Weapon{
    @Override
    public void aim() {
        System.out.println("히히 총알 발사");
    }
}

class Client {
    public static void main(String[] args) {

        Weapon generade = new Generade(new BaseWeapon());
        generade.aim();

        Weapon buttostockScopedRifle = new Buttstock(new Scoped(new BaseWeapon()));
        buttostockScopedRifle.aim();

        Weapon buttostockScopedGenerade = new Buttstock(new Scoped(new Generade(new BaseWeapon())));
        buttostockScopedGenerade.aim();
    }
}