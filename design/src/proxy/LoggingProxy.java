package proxy;

public class LoggingProxy implements ISubject {
    private Subject subject;

    public LoggingProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        // 프록시 객체는 실제 객체를 사용하기 전에 로깅을 한다
        // 서비스 메서드를 실행하고 전달하기 전에 로깅을 하는 기능을 추가하여 재정의
        System.out.println("LoggingProxy");
        
        subject.action();
        
        System.out.println("프록시");
        
        System.out.println("LoggingProxy");
    }
}
