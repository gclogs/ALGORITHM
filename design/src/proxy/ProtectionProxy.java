package proxy;

public class ProtectionProxy implements ISubject {
    private Subject subject;
    boolean access;

    public ProtectionProxy(Subject subject, boolean access) {
        this.subject = subject;
        this.access = access;
    }

    // 특정 클라이언트만 객체를 사용할 수 있도록 사용
    @Override
    public void action() {
        if (access) {
            subject.action();
        } else {
            System.out.println("Access Denied");
        }
    }
}

class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ISubject proxy = new ProtectionProxy(subject, true); // proxy 특정 객체에서 사용 가능
        proxy.action();
    }
}