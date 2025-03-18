package single;

public class LazySingleton {
    // Lazy initialization
    private static LazySingleton instance = null;

    private LazySingleton() {}

    // 메소드에 synchronized 적용을 하여 lock을 걸어두었기 때문에
    // 매번 사용할 때마다 한 개의 thread만 접근 가능함

    public static synchronized LazySingleton getInstance() {
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
