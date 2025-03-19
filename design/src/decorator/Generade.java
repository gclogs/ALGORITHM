package decorator;

// 유탄발사기
public class Generade extends WeaponAccessory{
    public Generade(Weapon rifle) {
        super(rifle);
    }
    
    @Override
    public void aim() {
        generadeFire();
        super.aim();
    }

    public void generadeFire() {
        System.out.println("히히 유탄 발사");
    }
}
