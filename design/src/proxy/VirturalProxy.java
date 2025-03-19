package proxy;

public class VirturalProxy implements ISubject {
    private Subject subject;
    
    public VirturalProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        // 실제 객체의 생성에 많은 자원이 소모 되지만 사용 빈도는 낮을 때 쓰는 방식
        // 프록시 객체는 실제 요청(action(메소드 호출)이 들어 왔을 때 실제 객체를 생성한다
        if (subject == null) {
            subject = new Subject();
        }
        subject.action();
    }
}
