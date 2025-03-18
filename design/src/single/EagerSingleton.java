package single;

public class EagerSingleton {
    // 클래스 로드 타임에 instnace가 생성됨
    // Eager-binding (부지런한 할당)
    // 단점: instance를 사용하고 싶지 않은데도 생성됨.
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {}

    public static EagerSingleton getInstance() {
        return instance;
    }
}
