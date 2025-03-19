package decorator;

// 개머리판
public class Buttstock extends WeaponAccessory{
    public Buttstock(Weapon rifle) {
        super(rifle);
    }

    public void aim() {
        holding();
        super.aim();
    }
    
    public void holding() {
        System.out.println("견착 완료");
    }
}
