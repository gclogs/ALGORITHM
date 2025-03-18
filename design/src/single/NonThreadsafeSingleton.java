package single;

public class NonThreadsafeSingleton {
    private static NonThreadsafeSingleton instance = null;

    private NonThreadsafeSingleton() {

    }

    // 동시성에 매우 취약함
    // Thread-safe 를 보장할 수 없음
    public static NonThreadsafeSingleton getInstance() {
        if(instance == null) {
            instance = new NonThreadsafeSingleton();
        }
        return instance;
    }
}
