package Facade;

/**
 * 클라이언트 클래스
 * 퍼사드 패턴을 사용하는 클라이언트 코드
 */
public class Client {
    public static void main(String[] args) {
        // 퍼사드 객체 생성 - 인터페이스 타입으로 참조
        IFacade facade = new Facade();
        
        // 시스템 초기화
        facade.init();
        System.out.println();
        
        // 기존 데이터 조회
        String testName = "test";
        Data testData = facade.getData(testName);
        if (testData != null) {
            printData(testData);
        }
        System.out.println();
        
        // 새 데이터 추가
        Data newData = new Data("user1", "secure123", "user1@example.com");
        facade.addData(newData);
        System.out.println();
        
        // 새로 추가한 데이터 조회
        Data retrievedData = facade.getData("user1");
        if (retrievedData != null) {
            printData(retrievedData);
        }
        System.out.println();
        
        // 존재하지 않는 데이터 조회
        facade.getData("nonexistent");
    }

    private static void printData(Data data) {
        System.out.println("=== 데이터 정보 ===");
        System.out.println("이름: " + data.getName());
        System.out.println("이메일: " + data.getEmail());
        System.out.println("생성 시간: " + data.getCreatedAt());
        System.out.println("==================");
    }
}
