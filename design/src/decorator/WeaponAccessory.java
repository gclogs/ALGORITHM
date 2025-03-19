package decorator;

abstract class WeaponAccessory implements Weapon  {
    private Weapon rifle;

    public WeaponAccessory(Weapon  rifle) {
        this.rifle = rifle;
    }

    @Override
    public void aim() {
        rifle.aim();
    }
}
