package single;

public class StaticSingleton {
    private static StaticSingleton instance;

    private StaticSingleton() {}

    static {
        try {
            instance = new StaticSingleton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StaticSingleton getInstance() {
        return instance;
    }
}
